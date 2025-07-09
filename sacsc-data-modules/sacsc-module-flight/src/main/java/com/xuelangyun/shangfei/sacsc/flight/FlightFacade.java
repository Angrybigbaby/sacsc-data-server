package com.xuelangyun.shangfei.sacsc.flight;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.xuelangyun.shangfei.sacsc.datasource.mapper.*;
import com.xuelangyun.shangfei.sacsc.domain.entity.*;
import com.xuelangyun.shangfei.sacsc.flight.enums.AircraftModel;
import com.xuelangyun.shangfei.sacsc.flight.enums.FlightStatusV2;
import com.xuelangyun.shangfei.sacsc.flight.excel.FlightPlanExcelHelper;
import com.xuelangyun.shangfei.sacsc.flight.vo.FlightPlanVO;
import com.xuelangyun.shangfei.sacsc.flight.vo.FlightPlanVO.FlightPlanAircraftNoGroup;
import com.xuelangyun.shangfei.sacsc.flight.vo.FlightPlanVO.FlightPlanCompanyGroup;
import com.xuelangyun.shangfei.sacsc.flight.vo.FlightPlanVO.FlightPlanData;
import com.xuelangyun.shangfei.sacsc.flight.vo.FlightPlanVO.FlightPlanItem;
import com.xuelangyun.shangfei.sacsc.core.exception.BusinessException;
import com.xuelangyun.shangfei.sacsc.core.response.StatusCode;
import com.xuelangyun.shangfei.sacsc.core.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.WeekendSqls;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zijian.qjd
 * @since 2023/6/19 16:44
 */
@Component
@Slf4j
public class FlightFacade {

  @Autowired private CsRunFlightPlanMapper flightPlanMapper;

  @Autowired private CsRunOverseasFlightPlanMapper overseasFlightPlanMapper;

  @Autowired private CsRunExpressFlightPlanMapper expressFlightPlanMapper;

  @Autowired private AdsMblAircraftDeliveryInfoMapper deliveryInfoMapper;

  @Autowired private CsRunFlightPlanCompanyDimMapper companyDimMapper;

  @Autowired private AdsAirlineCompanyThreeCodeMapper companyThreeCodeMapper;

  @Autowired private CsFileTypeSrcMapper fileTypeSrcMapper;

  @Autowired private OdsAirlineNameMappingInfoMapper airlineNameMappingMapper;

  @Autowired private FlightTailnumberDimMapper tailnumberDimMapper;

  public void exportExcel(final String path) {
    ExcelWriter writer = ExcelUtil.getWriter(path);
    FlightPlanExcelHelper.setStyle(writer);

    final FlightPlanVO todayFlightPlan = this.getFlightPlan(DateUtil.getCurrentDate());
    writer.renameSheet("当日计划表");
    FlightPlanExcelHelper.setTodaySheetAlias(writer);
    FlightPlanExcelHelper.writeFlightPlan(writer, todayFlightPlan, true);

    final FlightPlanVO yesterdayFlightPlan =
        this.getFlightPlan(
            LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    writer.setSheet(writer.getWorkbook().createSheet("昨日执行表"));
    writer.clearHeaderAlias();
    FlightPlanExcelHelper.setYesterdaySheetAlias(writer);
    FlightPlanExcelHelper.writeFlightPlan(writer, yesterdayFlightPlan, false);

    writer.close();
  }

  public Pair<Date, List<CsRunFlightPlan>> getCorrectedOriginPlan(
      String flightDate,
      boolean isToday,
      Map<String, Map<String, CsRunFlightPlanCompanyDim>> companyDimMapping,
      Map<String, AdsMblAircraftDeliveryInfo> aircraftNoMapping) {

    List<CsRunFlightPlan> csRunFlightPlans = flightPlanMapper.selectWithoutCancel(flightDate);
    if (CollectionUtils.isEmpty(csRunFlightPlans)) {
      return Pair.of(null, Lists.newArrayList());
    }

    // 数据更新时间
    final Date dataChangeTime = csRunFlightPlans.get(0).getCreateTime();

    // 印尼数据、快线 - 以飞书表格为准，通过机号去重
    // 印尼数据只用于当日计划
    // 快线数据历史航班计划也要展示
    csRunFlightPlans = handleFeishuFligthPlan(csRunFlightPlans, flightDate, isToday);

    final List<CsRunFlightPlan> res =
        doCorrectFlightPlan(csRunFlightPlans, companyDimMapping, aircraftNoMapping);

    return Pair.of(dataChangeTime, res);
  }

  public List<CsRunFlightPlan> doCorrectFlightPlan(
      List<CsRunFlightPlan> csRunFlightPlans,
      Map<String, Map<String, CsRunFlightPlanCompanyDim>> companyDimMapping,
      Map<String, AdsMblAircraftDeliveryInfo> aircraftNoMapping) {
    if (CollectionUtils.isEmpty(csRunFlightPlans)) {
      return Lists.newArrayList();
    }

    // 航班号（不为空） - 航段（如果有总航段，则 index 为 0）
    final Map<String, List<CsRunFlightPlan>> flightWithMultiSegMapping =
        flightWithMultiSeg(csRunFlightPlans);

    // 获取所有已交付航司的三字码
    final Set<String> allDeliveryAirlineThreeCode = getAllDeliveryAirlineThreeCode();

    // 注册号信息映射
    final Map<String, FlightTailnumberDim> tailnumberDimMapping = tailnumberDimMapping();

    return csRunFlightPlans.stream()
        // 如果航班号对应的航班计划有多个 就过滤总航段
        // 如果航班号对应的航段只有一个就不过滤
        .filter(
            e -> {
              if (StringUtils.isNotEmpty(e.getFlightNo())
                  && CollectionUtils.size(flightWithMultiSegMapping.get(e.getFlightNo())) == 1) {
                return true;
              }
              return !StringUtils.equals(e.getStopFlag(), "1");
            })
        .peek(e -> modifyFlight(e, tailnumberDimMapping))
        // 处理共享航班，过滤掉不是已交付的航司
        .filter(e -> isDeliveryAirline(e, allDeliveryAirlineThreeCode))
        // 机型、航司修正
        .peek(e -> correctCompanyName(e, companyDimMapping))
        // 修正注册号
        .peek(e -> correctAircraft(e, aircraftNoMapping, flightWithMultiSegMapping))
        // 修正时区
        .peek(this::correctTimezone)
        .collect(Collectors.toList());
  }

  private void modifyFlight(
      CsRunFlightPlan csRunFlightPlan, Map<String, FlightTailnumberDim> tailnumberDimMapping) {
    if (Objects.isNull(csRunFlightPlan) || MapUtils.isEmpty(tailnumberDimMapping)) {
      return;
    }
    final FlightTailnumberDim d = tailnumberDimMapping.get(csRunFlightPlan.getAircraftNo());
    if (Objects.nonNull(d)) {
      csRunFlightPlan.setAirlineThreeCode(d.getStandardCompanyThreeCode());
      csRunFlightPlan.setAirlineCompany(d.getStandardCompany());
    }
  }

  private Set<String> getAllDeliveryAirlineThreeCode() {
    final List<AdsAirlineCompanyThreeCode> adsAirlineCompanyThreeCodes =
        companyThreeCodeMapper.selectAll();
    if (CollectionUtils.isEmpty(adsAirlineCompanyThreeCodes)) {
      return Sets.newHashSet();
    }
    return adsAirlineCompanyThreeCodes.stream()
        .map(AdsAirlineCompanyThreeCode::getAirlineThreeCode)
        .collect(Collectors.toSet());
  }

  private boolean isDeliveryAirline(
      CsRunFlightPlan csRunFlightPlan, Set<String> allDeliveryAirlineThreeCode) {

    if (CollectionUtils.isEmpty(allDeliveryAirlineThreeCode) || csRunFlightPlan == null) {
      return true;
    }
    return allDeliveryAirlineThreeCode.contains(csRunFlightPlan.getAirlineThreeCode());
  }

  public FlightPlanVO getFlightPlan(String date) {
    if (StringUtils.isNotEmpty(date) && !GenericValidator.isDate(date, "yyyy-MM-dd", true)) {
      log.error("error date: {}", date);
      throw new BusinessException(StatusCode.ERROR, "日期参数格式不对");
    }

    final FlightPlanVO res = new FlightPlanVO();

    //
    final String flightDate = StringUtils.isEmpty(date) ? DateUtil.getCurrentDate() : date;
    final LocalDate flightLocalDate = LocalDateTimeUtil.parseDate(flightDate, "yyyy-MM-dd");
    final boolean isToday = StringUtils.equals(flightDate, DateUtil.getCurrentDate());
    final Date flightDateEnd = DateUtil.getTodayEnd(DateUtil.StrToDate(flightDate, "yyyy-MM-dd"));
    final Date flightDateStart =
        DateUtil.getTodayStart(DateUtil.StrToDate(flightDate, "yyyy-MM-dd"));

    // 机型 - 航司三字码 - 纬度信息（简称、优先级）
    final Map<String, Map<String, CsRunFlightPlanCompanyDim>> companyDimMapping =
        companyDimMapping();

    // 查询维度表 - originalName - standardName
    final Map<String, String> companyOriginNameMapping =
        airlineNameMappingMapper.selectAll().stream()
            .filter(Objects::nonNull)
            .filter(
                e ->
                    StringUtils.isNotEmpty(e.getOriginalName())
                        && StringUtils.isNotEmpty(e.getStandardName()))
            .collect(
                Collectors.toMap(
                    OdsAirlineNameMappingInfo::getOriginalName,
                    OdsAirlineNameMappingInfo::getStandardName,
                    (e1, e2) -> e1));

    // 替换 key 为航管处理后的航司名
    final Map<String, String> companyLogoMapping =
        fileTypeSrcMapper.selectByTypeDesc("航司LOGO").stream()
            .filter(
                e ->
                    StringUtils.isNotEmpty(e.getSrcDesc())
                        && StringUtils.isNotEmpty(e.getFileUrl()))
            .peek(
                e -> {
                  final String company = companyOriginNameMapping.get(e.getSrcDesc());
                  if (StringUtils.isNotEmpty(company)) {
                    e.setSrcDesc(company);
                  }
                })
            .collect(
                Collectors.toMap(
                    CsFileTypeSrc::getSrcDesc, CsFileTypeSrc::getFileUrl, (e1, e2) -> e1));

    // 机号（连字号、非连字号 都有） - msn、交付时间
    final Map<String, AdsMblAircraftDeliveryInfo> aircraftNoMapping = aircraftNoMapping();

    final Pair<Date, List<CsRunFlightPlan>> correctedOriginPlan =
        getCorrectedOriginPlan(flightDate, isToday, companyDimMapping, aircraftNoMapping);
    if (correctedOriginPlan == null
        || correctedOriginPlan.getLeft() == null
        || CollectionUtils.isEmpty(correctedOriginPlan.getRight())) {
      return res;
    }

    final Date dataChangeTime = correctedOriginPlan.getLeft();
    final List<CsRunFlightPlan> csRunFlightPlans = correctedOriginPlan.getRight();

    // ARJ21、C919 分组并修正数据
    final Map<String, List<CsRunFlightPlan>> modelMapping =
        csRunFlightPlans.stream()
            // 过滤航班
            .filter(e -> filterFlyInFlightDate(e, isToday, flightDateEnd, flightDateStart))
            // 机型分组
            .collect(Collectors.groupingBy(CsRunFlightPlan::getAircraftType));

    // 机队数
    final Map<String, AdsAirlineCompanyThreeCode> deliveryCompanyMapping =
        companyThreeCodeMapper.selectAll().stream()
            .collect(
                Collectors.toMap(
                    AdsAirlineCompanyThreeCode::getAirlineName, e -> e, (e1, e2) -> e1));
    // 机型 - 航司/all - 机队数
    final Map<String, Map<String, Integer>> fleetNumMapping =
        fleetNumMapping(deliveryCompanyMapping);

    // fill data

    res.setDataChangeDateTime(DateUtil.getFormatDate(dataChangeTime, "yyyy-MM-dd HH:mm"));
    res.setFlightYear("" + flightLocalDate.getYear());
    res.setFlightMonth("" + flightLocalDate.getMonthValue());
    res.setFlightDay("" + flightLocalDate.getDayOfMonth());

    final FlightPlanData arj21 = new FlightPlanData();
    final FlightPlanData c919 = new FlightPlanData();

    fillFlightPlanData(
        arj21,
        modelMapping.get(AircraftModel.ARJ21.getModel()),
        isToday,
        aircraftNoMapping,
        companyDimMapping.get(AircraftModel.ARJ21.getModel()),
        fleetNumMapping.get(AircraftModel.ARJ21.getModel()),
        companyOriginNameMapping,
        companyLogoMapping);
    fillFlightPlanData(
        c919,
        modelMapping.get(AircraftModel.C919.getModel()),
        isToday,
        aircraftNoMapping,
        companyDimMapping.get(AircraftModel.C919.getModel()),
        fleetNumMapping.get(AircraftModel.C919.getModel()),
        companyOriginNameMapping,
        companyLogoMapping);

    res.setArj21(arj21);
    res.setC919(c919);

    return res;
  }

  private Map<String, Map<String, Integer>> fleetNumMapping(
      Map<String, AdsAirlineCompanyThreeCode> deliveryCompanyMapping) {
    final List<AdsMblAircraftDeliveryInfo> deliveryInfoList =
        deliveryInfoMapper.selectByExample(
            Example.builder(AdsMblAircraftDeliveryInfo.class)
                .andWhere(
                    WeekendSqls.<AdsMblAircraftDeliveryInfo>custom()
                        .andEqualTo(AdsMblAircraftDeliveryInfo::getDimensionType, "airline"))
                .build());
    if (CollectionUtils.isEmpty(deliveryInfoList)) {
      return Maps.newHashMap();
    }

    final Map<String, Map<String, List<AdsMblAircraftDeliveryInfo>>> deliveryMapping =
        deliveryInfoList.stream()
            .collect(
                Collectors.groupingBy(
                    AdsMblAircraftDeliveryInfo::getAircraftModel,
                    Collectors.groupingBy(AdsMblAircraftDeliveryInfo::getAirlineStandardName)));

    Map<String, Map<String, Integer>> res = Maps.newHashMap();

    // ARJ
    final Map<String, List<AdsMblAircraftDeliveryInfo>> arj21Mapping =
        deliveryMapping.get(AircraftModel.ARJ21.getModel());
    if (MapUtils.isNotEmpty(arj21Mapping)) {
      Map<String, Integer> arjFleetNumMapping = Maps.newHashMap();
      res.put(AircraftModel.ARJ21.getModel(), arjFleetNumMapping);

      int arjFleetNum = arj21Mapping.values().stream().map(List::size).reduce(0, Integer::sum);
      arjFleetNumMapping.put("all", arjFleetNum);

      for (String company : arj21Mapping.keySet()) {
        final AdsAirlineCompanyThreeCode airlineCompany = deliveryCompanyMapping.get(company);
        String key;
        if (airlineCompany == null || StringUtils.isEmpty(airlineCompany.getAirlineCompany())) {
          key = company;
        } else {
          key = airlineCompany.getAirlineCompany();
        }
        arjFleetNumMapping.put(key, arj21Mapping.get(company).size());
      }
    }

    // C919
    final Map<String, List<AdsMblAircraftDeliveryInfo>> c919Mapping =
        deliveryMapping.get(AircraftModel.C919.getModel());
    if (MapUtils.isNotEmpty(c919Mapping)) {
      Map<String, Integer> c919FleetNumMapping = Maps.newHashMap();
      res.put(AircraftModel.C919.getModel(), c919FleetNumMapping);

      int c919FleetNum = c919Mapping.values().stream().map(List::size).reduce(0, Integer::sum);
      c919FleetNumMapping.put("all", c919FleetNum);

      for (String company : c919Mapping.keySet()) {
        final AdsAirlineCompanyThreeCode airlineCompany = deliveryCompanyMapping.get(company);
        String key;
        if (airlineCompany == null || StringUtils.isEmpty(airlineCompany.getAirlineCompany())) {
          key = company;
        } else {
          key = airlineCompany.getAirlineCompany();
        }
        c919FleetNumMapping.put(key, c919Mapping.get(company).size());
      }
    }

    return res;
  }

  private void correctAircraft(
      CsRunFlightPlan csRunFlightPlan,
      Map<String, AdsMblAircraftDeliveryInfo> aircraftNoMapping,
      Map<String, List<CsRunFlightPlan>> flightWithMultiSegMapping) {

    if (null == csRunFlightPlan || MapUtils.isEmpty(aircraftNoMapping)) {
      return;
    }

    String originAircraftNo = csRunFlightPlan.getAircraftNo();

    if (StringUtils.isEmpty(originAircraftNo)
        && StringUtils.isNotEmpty(csRunFlightPlan.getFlightNo())) {
      // 机号为空处理 - 如果该航班有多航段，则用前一个航段的机号
      final List<CsRunFlightPlan> flightSegs =
          flightWithMultiSegMapping.get(csRunFlightPlan.getFlightNo()).stream()
              // 过滤掉除总航段外其余没有架机号的航段
              .filter(
                  plan ->
                      StringUtils.equals(plan.getStopFlag(), "1")
                          || StringUtils.isNotEmpty(plan.getAircraftNo()))
              .collect(Collectors.toList());

      if (CollectionUtils.isNotEmpty(flightSegs)
          && StringUtils.equals(flightSegs.get(0).getStopFlag(), "1")) {
        // 判断计划起降时间是否在总航段的计划起降时间窗口内

        final CsRunFlightPlan seg = flightSegs.get(0);

        boolean isInWindows =
            StringUtils.isNotEmpty(csRunFlightPlan.getDepPlanTime())
                && StringUtils.isNotEmpty(csRunFlightPlan.getArrPlanTime())
                && StringUtils.isNotEmpty(seg.getDepPlanTime())
                && StringUtils.isNotEmpty(seg.getArrPlanTime())
                && StringUtils.compare(csRunFlightPlan.getDepPlanTime(), seg.getDepPlanTime()) >= 0
                && StringUtils.compare(csRunFlightPlan.getArrPlanTime(), seg.getArrPlanTime()) <= 0;

        if (isInWindows) {
          originAircraftNo = flightSegs.get(flightSegs.size() - 1).getAircraftNo();
        }
      }

      if (StringUtils.isEmpty(originAircraftNo)) {
        originAircraftNo =
            correctAircraftWithBackOrForthFlight(csRunFlightPlan, flightWithMultiSegMapping);
      }
    }

    final AdsMblAircraftDeliveryInfo deliveryInfo = aircraftNoMapping.get(originAircraftNo);
    if (StringUtils.isEmpty(originAircraftNo) || deliveryInfo == null) {
      return;
    }

    csRunFlightPlan.setAircraftNo(deliveryInfo.getAircraftNoWithHyphen());
  }

  private String correctAircraftWithBackOrForthFlight(
      final CsRunFlightPlan csRunFlightPlan,
      Map<String, List<CsRunFlightPlan>> flightWithMultiSegMapping) {

    // 去程航班有机号，如果回程没机号，就采用去程的机号
    // 回程航班有机号，如果去程没机号，就采用回程的机号
    // 如果有机号的有多航段，取最后一个航段

    final String flightNo = csRunFlightPlan.getFlightNo();
    if (StringUtils.isEmpty(flightNo)) {
      return StringUtils.EMPTY;
    }

    final MatchResult matchResult = ReUtil.lastIndexOf("[a-zA-Z]", flightNo);

    if (null == matchResult) {
      log.warn("航班号处理异常: {}", flightNo);
      return StringUtils.EMPTY;
    }

    final String suffix = StringUtils.substring(flightNo, matchResult.end());
    final String prefix = StringUtils.substring(flightNo, 0, matchResult.end());

    if (!GenericValidator.isInt(suffix)) {
      log.warn("航班号处理异常: {}", flightNo);
      return StringUtils.EMPTY;
    }

    final int num = Integer.parseInt(suffix);
    final String forthFlightNo = prefix + (num - 1);
    final String backFlightNo = prefix + (num + 1);

    // 处理多航段的问题
    final List<CsRunFlightPlan> currFlightPlans = flightWithMultiSegMapping.get(flightNo);
    final CsRunFlightPlan currFlightPlan =
        CollectionUtils.isNotEmpty(currFlightPlans) ? currFlightPlans.get(0) : csRunFlightPlan;

    final List<CsRunFlightPlan> forthPlans = flightWithMultiSegMapping.get(forthFlightNo);
    if (CollectionUtils.isNotEmpty(forthPlans)) {

      final CsRunFlightPlan forthPlan = forthPlans.get(0);
      if (StringUtils.equalsIgnoreCase(currFlightPlan.getDepFourCode(), forthPlan.getArrFourCode())
          && StringUtils.equalsIgnoreCase(
              currFlightPlan.getArrFourCode(), forthPlan.getDepFourCode())) {
        final String preAircraftNo = forthPlans.get(forthPlans.size() - 1).getAircraftNo();
        if (StringUtils.isNotEmpty(preAircraftNo)) {
          return preAircraftNo;
        }
      }
    }

    final List<CsRunFlightPlan> backPlans = flightWithMultiSegMapping.get(backFlightNo);
    if (CollectionUtils.isNotEmpty(backPlans)) {

      final CsRunFlightPlan backPlan = backPlans.get(0);
      if (StringUtils.equalsIgnoreCase(currFlightPlan.getDepFourCode(), backPlan.getArrFourCode())
          && StringUtils.equalsIgnoreCase(
              currFlightPlan.getArrFourCode(), backPlan.getDepFourCode())) {
        final String afterAircraftNo = backPlans.get(backPlans.size() - 1).getAircraftNo();
        if (StringUtils.isNotEmpty(afterAircraftNo)) {
          return afterAircraftNo;
        }
      }
    }

    return StringUtils.EMPTY;
  }

  private Map<String, List<CsRunFlightPlan>> flightWithMultiSeg(
      List<CsRunFlightPlan> csRunFlightPlans) {

    if (CollectionUtils.isEmpty(csRunFlightPlans)) {
      return Maps.newHashMap();
    }

    return csRunFlightPlans.stream()
        // 过滤掉没有航班号的
        .filter(e -> StringUtils.isNotEmpty(e.getFlightNo()))
        // 根据航班号分组
        .collect(
            Collectors.groupingBy(
                CsRunFlightPlan::getFlightNo,
                Collectors.mapping(
                    Function.identity(),
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        e ->
                            e.stream()
                                .sorted(
                                    (o1, o2) -> {
                                      // 将总航段排在前面
                                      if (StringUtils.equals(o1.getStopFlag(), "1")) {
                                        return -1;
                                      }
                                      if (StringUtils.equals(o2.getStopFlag(), "1")) {
                                        return 1;
                                      }
                                      // 其余航段以计划起飞时间升序排序
                                      return StringUtils.compare(
                                          o1.getDepPlanTime(), o2.getDepPlanTime(), true);
                                    })
                                .collect(Collectors.toList())))));
  }

  private void correctTimezone(CsRunFlightPlan csRunFlightPlan) {
    if (csRunFlightPlan == null) {
      return;
    }

    if (!StringUtils.equals("28800", csRunFlightPlan.getDepTimezone())
        && GenericValidator.isInt(csRunFlightPlan.getDepTimezone())) {
      // 修改起飞时间
      csRunFlightPlan.setDepActTime(
          correctTime(csRunFlightPlan.getDepActTime(), csRunFlightPlan.getDepTimezone()));
      csRunFlightPlan.setDepPlanTime(
          correctTime(csRunFlightPlan.getDepPlanTime(), csRunFlightPlan.getDepTimezone()));
      csRunFlightPlan.setDepReadyTime(
          correctTime(csRunFlightPlan.getDepReadyTime(), csRunFlightPlan.getDepTimezone()));
    }

    if (!StringUtils.equals("28800", csRunFlightPlan.getArrTimezone())
        && GenericValidator.isInt(csRunFlightPlan.getArrTimezone())) {
      // 修改到达时间
      csRunFlightPlan.setArrActTime(
          correctTime(csRunFlightPlan.getArrActTime(), csRunFlightPlan.getArrTimezone()));
      csRunFlightPlan.setArrPlanTime(
          correctTime(csRunFlightPlan.getArrPlanTime(), csRunFlightPlan.getArrTimezone()));
      csRunFlightPlan.setArrReadyTime(
          correctTime(csRunFlightPlan.getArrReadyTime(), csRunFlightPlan.getArrTimezone()));
    }
  }

  private String correctTime(String time, String timezone) {
    if (GenericValidator.isDate(time, "yyyy-MM-dd HH:mm:ss", true)) {
      final Date date = DateUtil.StrToDate(time, "yyyy-MM-dd HH:mm:ss");
      final Date correctedDate =
          DateUtil.addSeconds(date, Integer.parseInt("28800") - Integer.parseInt(timezone));
      return DateUtil.getFormatDate(correctedDate, "yyyy-MM-dd HH:mm:ss");
    }
    return time;
  }

  private void correctCompanyName(
      CsRunFlightPlan csRunFlightPlan,
      Map<String, Map<String, CsRunFlightPlanCompanyDim>> companyDimMapping) {

    if (null == csRunFlightPlan) {
      return;
    }

    // ARJ21
    if (StringUtils.contains(csRunFlightPlan.getAircraftType(), "ARJ")) {

      csRunFlightPlan.setAircraftType(AircraftModel.ARJ21.getModel());

      final Map<String, CsRunFlightPlanCompanyDim> arjMapping =
          companyDimMapping.get(AircraftModel.ARJ21.getModel());

      if (MapUtils.isEmpty(arjMapping)) {
        return;
      }

      final CsRunFlightPlanCompanyDim dim = arjMapping.get(csRunFlightPlan.getAirlineThreeCode());

      if (dim == null || StringUtils.isEmpty(dim.getAbbreviation())) {
        return;
      }

      csRunFlightPlan.setAirlineCompany(dim.getAbbreviation());
      return;
    }

    // C919
    if (StringUtils.contains(csRunFlightPlan.getAircraftType(), "C919")) {

      csRunFlightPlan.setAircraftType(AircraftModel.C919.getModel());

      final Map<String, CsRunFlightPlanCompanyDim> c919Mapping =
          companyDimMapping.get(AircraftModel.C919.getModel());

      if (MapUtils.isEmpty(c919Mapping)) {
        return;
      }

      final CsRunFlightPlanCompanyDim dim = c919Mapping.get(csRunFlightPlan.getAirlineThreeCode());

      if (dim == null || StringUtils.isEmpty(dim.getAbbreviation())) {
        return;
      }

      csRunFlightPlan.setAirlineCompany(dim.getAbbreviation());
    }
  }

  private boolean filterFlyInFlightDate(
      CsRunFlightPlan csRunFlightPlan, boolean isToday, Date flightDateEnd, Date flightDateStart) {
    // 以前的航班计划是航班起飞时间在当天的时间范围内的数据
    if (!isToday) {

      if (StringUtils.isEmpty(csRunFlightPlan.getDepActTime())) {
        return false;
      }

      // 这里实际起飞时间已经转成北京时间了，需要重新转换成之前的实际起飞时间判断

      if (!StringUtils.equals("28800", csRunFlightPlan.getDepTimezone())
          && GenericValidator.isInt(csRunFlightPlan.getDepActTime())) {

        final Date depDateBj =
            DateUtil.StrToDate(csRunFlightPlan.getDepActTime(), "yyyy-MM-dd HH:mm:ss");

        if (depDateBj == null) {
          return false;
        }

        final Date depDateOrigin =
            DateUtil.addSeconds(
                depDateBj,
                Integer.parseInt(csRunFlightPlan.getDepTimezone()) - Integer.parseInt("28800"));
        return depDateOrigin.after(flightDateStart) && depDateOrigin.before(flightDateEnd);
      }

      final Date depDate =
          DateUtil.StrToDate(csRunFlightPlan.getDepActTime(), "yyyy-MM-dd HH:mm:ss");
      return depDate != null && depDate.after(flightDateStart) && depDate.before(flightDateEnd);
    }
    return true;
  }

  public Map<String, FlightTailnumberDim> tailnumberDimMapping() {
    Map<String, FlightTailnumberDim> res = Maps.newHashMap();
    final List<FlightTailnumberDim> flightTailnumberDims = tailnumberDimMapper.selectAll();
    if (CollectionUtils.isNotEmpty(flightTailnumberDims)) {
      res =
          flightTailnumberDims.stream()
              .collect(
                  Collectors.toMap(FlightTailnumberDim::getTailnumber, e -> e, (e1, e2) -> e2));
    }
    return res;
  }

  public Map<String, Map<String, CsRunFlightPlanCompanyDim>> companyDimMapping() {
    final List<CsRunFlightPlanCompanyDim> companyDimList = companyDimMapper.selectAll();
    if (CollectionUtils.isEmpty(companyDimList)) {
      return Maps.newHashMap();
    }

    return companyDimList.stream()
        .filter(Objects::nonNull)
        .filter(
            e ->
                StringUtils.isNotEmpty(e.getModel())
                    && StringUtils.isNotEmpty(e.getAbbreviation())
                    && StringUtils.isNotEmpty(e.getThreeCode())
                    && e.getPriority() != null)
        .collect(
            Collectors.groupingBy(
                CsRunFlightPlanCompanyDim::getModel,
                Collectors.toMap(CsRunFlightPlanCompanyDim::getThreeCode, e -> e, (e1, e2) -> e1)));
  }

  public Map<String, AdsMblAircraftDeliveryInfo> aircraftNoMapping() {
    return deliveryInfoMapper.selectAll().stream()
        .peek(
            e -> {
              final String planeRegSerial = e.getPlaneRegSerial();
              if (StringUtils.isNotEmpty(planeRegSerial)) {
                e.setAircraftNoWithHyphen(StringUtils.substringBefore(planeRegSerial, "("));
                e.setAircraftNoWithoutHyphen(e.getAircraftNoWithHyphen().replace("-", ""));
                e.setMsn(StringUtils.substringBetween(planeRegSerial, "(", ")"));
              }
            })
        .flatMap(
            e -> {
              AdsMblAircraftDeliveryInfo e1 = new AdsMblAircraftDeliveryInfo();
              BeanUtils.copyProperties(e, e1);
              e1.setAircraftNo(e1.getAircraftNoWithHyphen());

              AdsMblAircraftDeliveryInfo e2 = new AdsMblAircraftDeliveryInfo();
              BeanUtils.copyProperties(e, e2);
              e2.setAircraftNo(e2.getAircraftNoWithoutHyphen());

              return Stream.of(e1, e2);
            })
        .collect(
            Collectors.toMap(AdsMblAircraftDeliveryInfo::getAircraftNo, e -> e, (e1, e2) -> e2));
  }

  public List<CsRunFlightPlan> doHandleFeishuFlightPlan(
      List<CsRunFlightPlan> csRunFlightPlans,
      List<CsRunFlightPlan> overseasPlans,
      List<CsRunFlightPlan> expressPlans,
      boolean isToday) {
    if (CollectionUtils.isEmpty(csRunFlightPlans)) {
      return csRunFlightPlans;
    }

    Set<String> feishuAircraftNo = Sets.newHashSet();
    final List<CsRunFlightPlan> overseasFlightPlan = Lists.newArrayList();
    final List<CsRunFlightPlan> expressFlightPlan = Lists.newArrayList();

    final String now =
        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    if (isToday) {
      try {

        final List<CsRunFlightPlan> overseas =
            overseasPlans.stream().peek(e -> mockActData(now, e)).collect(Collectors.toList());

        if (CollectionUtils.isNotEmpty(overseas)) {

          overseasFlightPlan.addAll(overseas);

          final Set<String> aircraftNos =
              overseas.stream()
                  .map(CsRunFlightPlan::getAircraftNo)
                  .filter(StringUtils::isNotEmpty)
                  .collect(Collectors.toSet());
          if (CollectionUtils.isNotEmpty(aircraftNos)) {
            feishuAircraftNo.addAll(aircraftNos);
          }
        }
      } catch (Exception e) {
        log.error("select overseas data ex", e);
      }
    }

    try {

      final List<CsRunFlightPlan> express =
          expressPlans.stream()
              .peek(
                  e -> {
                    if (!isToday) {
                      e.setDepActTime(e.getDepPlanTime());
                      e.setDepReadyTime(e.getDepPlanTime());
                      e.setArrActTime(e.getArrPlanTime());
                      e.setArrReadyTime(e.getArrPlanTime());
                      e.setFlightState(FlightStatusV2.ARRIVE.getComment());
                    } else {
                      mockActData(now, e);
                    }
                  })
              .collect(Collectors.toList());

      if (CollectionUtils.isNotEmpty(express)) {

        expressFlightPlan.addAll(express);

        final Set<String> aircraftNos =
            express.stream()
                .map(CsRunFlightPlan::getAircraftNo)
                .filter(StringUtils::isNotEmpty)
                .collect(Collectors.toSet());
        if (CollectionUtils.isNotEmpty(aircraftNos)) {
          feishuAircraftNo.addAll(aircraftNos);
        }
      }
    } catch (Exception e) {
      log.error("select express data ex", e);
    }

    // 以飞书数据为准 - 通过注册号来过滤
    if (CollectionUtils.isNotEmpty(feishuAircraftNo)) {
      csRunFlightPlans =
          csRunFlightPlans.stream()
              .filter(e -> !feishuAircraftNo.contains(e.getAircraftNo()))
              .collect(Collectors.toList());
    }

    if (CollectionUtils.isNotEmpty(overseasFlightPlan)) {
      csRunFlightPlans.addAll(overseasFlightPlan);
    }

    if (CollectionUtils.isNotEmpty(expressFlightPlan)) {
      csRunFlightPlans.addAll(expressFlightPlan);
    }

    return csRunFlightPlans;
  }

  public List<CsRunFlightPlan> handleFeishuFligthPlan(
      List<CsRunFlightPlan> csRunFlightPlans, String flightDate, boolean isToday) {

    if (CollectionUtils.isEmpty(csRunFlightPlans)) {
      return csRunFlightPlans;
    }

    return doHandleFeishuFlightPlan(
        csRunFlightPlans,
        isToday ? getOverseasFlightPlan(flightDate) : Lists.newArrayList(),
        getExpressFlightPlan(flightDate),
        isToday);
  }

  public void mockActData(String now, CsRunFlightPlan csRunFlightPlan) {

    if (StringUtils.compare(now, csRunFlightPlan.getDepPlanTime()) >= 0) {
      csRunFlightPlan.setDepReadyTime(csRunFlightPlan.getDepPlanTime());
      csRunFlightPlan.setDepActTime(csRunFlightPlan.getDepPlanTime());
    }
    if (StringUtils.compare(now, csRunFlightPlan.getArrPlanTime()) >= 0) {
      csRunFlightPlan.setArrReadyTime(csRunFlightPlan.getArrPlanTime());
      csRunFlightPlan.setArrActTime(csRunFlightPlan.getArrPlanTime());
    }

    csRunFlightPlan.setFlightState(FlightStatusV2.SCHEDULE.getComment());

    if (StringUtils.isNotEmpty(csRunFlightPlan.getArrActTime())) {
      csRunFlightPlan.setFlightState(FlightStatusV2.ARRIVE.getComment());
    } else if (StringUtils.isNotEmpty(csRunFlightPlan.getDepActTime())) {
      csRunFlightPlan.setFlightState(FlightStatusV2.TAKE_OFF.getComment());
    }
  }

  private List<CsRunFlightPlan> getOverseasFlightPlan(final String flightDate) {
    if (StringUtils.isEmpty(flightDate)) {
      return Lists.newArrayList();
    }

    final List<CsRunOverseasFlightPlan> csRunOverseasFlightPlans =
        overseasFlightPlanMapper.selectWithDate(flightDate);

    if (CollectionUtils.isEmpty(csRunOverseasFlightPlans)) {
      return Lists.newArrayList();
    }

    return csRunOverseasFlightPlans.stream()
        .map(
            e -> {
              CsRunFlightPlan csRunFlightPlan = new CsRunFlightPlan();
              BeanUtils.copyProperties(e, csRunFlightPlan);
              return csRunFlightPlan;
            })
        .collect(Collectors.toList());
  }

  private List<CsRunFlightPlan> getExpressFlightPlan(final String flightDate) {
    if (StringUtils.isEmpty(flightDate)) {
      return Lists.newArrayList();
    }

    final List<CsRunExpressFlightPlan> csRunExpressFlightPlans =
        expressFlightPlanMapper.selectWithDate(flightDate);

    if (CollectionUtils.isEmpty(csRunExpressFlightPlans)) {
      return Lists.newArrayList();
    }

    return csRunExpressFlightPlans.stream()
        .map(
            e -> {
              CsRunFlightPlan csRunFlightPlan = new CsRunFlightPlan();
              BeanUtils.copyProperties(e, csRunFlightPlan);
              return csRunFlightPlan;
            })
        .collect(Collectors.toList());
  }

  private void fillFlightPlanData(
      FlightPlanData planData,
      List<CsRunFlightPlan> planList,
      boolean isToday,
      Map<String, AdsMblAircraftDeliveryInfo> aircraftNoMapping,
      Map<String, CsRunFlightPlanCompanyDim> companyDimMapping,
      Map<String, Integer> fleetNumMapping,
      Map<String, String> companyOriginNameMapping,
      Map<String, String> companyLogoMapping) {

    if (CollectionUtils.isEmpty(planList)) {
      return;
    }

    // 飞机数
    Set<String> planeSet = Sets.newHashSet();
    // 航段数
    int flyLeg = 0;
    // 航司 - 机号
    Map<String, Set<String>> companyPlane = Maps.newHashMap();
    // 航司 - 三字码
    Map<String, String> airlineThreeCode = Maps.newHashMap();
    // 航司 - 机号（有可能为空） - 航班计划
    Map<String, Map<String, List<CsRunFlightPlan>>> flightMapping = Maps.newHashMap();

    for (final CsRunFlightPlan csRunFlightPlan : planList) {

      // 不是今天的去除计划的航班

      if (isToday
          || !StringUtils.equals(
              FlightStatusV2.SCHEDULE.getComment(), csRunFlightPlan.getFlightState())) {

        // 执飞飞机总数
        if (StringUtils.isNotEmpty(csRunFlightPlan.getAircraftNo())) {
          planeSet.add(csRunFlightPlan.getAircraftNo());
        }

        // 执飞航段总数
        flyLeg += 1;

        // 航司 - 飞机
        companyPlane.compute(
            csRunFlightPlan.getAirlineCompany(),
            (key, val) -> {
              if (CollectionUtils.isEmpty(val)) {
                if (StringUtils.isNotEmpty(csRunFlightPlan.getAircraftNo())) {
                  return Sets.newHashSet(csRunFlightPlan.getAircraftNo());
                } else {
                  return Sets.newHashSet();
                }
              }
              if (StringUtils.isNotEmpty(csRunFlightPlan.getAircraftNo())) {
                val.add(csRunFlightPlan.getAircraftNo());
              }
              return val;
            });

        if (StringUtils.isNotEmpty(csRunFlightPlan.getAirlineCompany())
            && StringUtils.isNotEmpty(csRunFlightPlan.getAirlineThreeCode())) {
          airlineThreeCode.put(
              csRunFlightPlan.getAirlineCompany(), csRunFlightPlan.getAirlineThreeCode());
        }

        // 航司 - 机号 - 航班
        flightMapping.compute(
            csRunFlightPlan.getAirlineCompany(),
            (company, planeFlightMapping) -> {
              if (MapUtils.isEmpty(planeFlightMapping)) {
                Map<String, List<CsRunFlightPlan>> m = Maps.newHashMap();
                m.put(csRunFlightPlan.getAircraftNo(), Lists.newArrayList(csRunFlightPlan));
                return m;
              }

              planeFlightMapping.compute(
                  csRunFlightPlan.getAircraftNo(),
                  (aircraftNo, flightPlanList) -> {
                    if (CollectionUtils.isEmpty(flightPlanList)) {
                      return Lists.newArrayList(csRunFlightPlan);
                    }
                    flightPlanList.add(csRunFlightPlan);
                    return flightPlanList;
                  });

              return planeFlightMapping;
            });
      }
    }

    // === 处理没有航班计划的航司
    for (CsRunFlightPlanCompanyDim dim : companyDimMapping.values()) {
      if (!companyPlane.containsKey(dim.getAbbreviation())) {
        companyPlane.put(dim.getAbbreviation(), Sets.newHashSet());
        airlineThreeCode.put(dim.getAbbreviation(), dim.getThreeCode());
        flightMapping.put(dim.getAbbreviation(), Maps.newHashMap());
      }
    }
    // ===

    // 执飞飞机总数
    planData.setFlyPlaneNum(planeSet.size());
    // 执飞航段总数
    planData.setFlyLegNum(flyLeg);
    // 机队总数
    planData.setFleetNum(fleetNumMapping.get("all"));

    List<FlightPlanCompanyGroup> companyFlightPlanes = Lists.newArrayList();

    for (String company : companyPlane.keySet()) {
      FlightPlanCompanyGroup companyGroup = new FlightPlanCompanyGroup();

      companyGroup.setCompany(company);
      companyGroup.setAirlineThreeCode(airlineThreeCode.get(company));
      companyGroup.setFlyPlaneNum(companyPlane.get(company).size());
      companyGroup.setFleetNum(fleetNumMapping.get(company));

      if (MapUtils.isNotEmpty(companyOriginNameMapping)
          && MapUtils.isNotEmpty(companyLogoMapping)) {
        companyGroup.setCompanyLogo(companyLogoMapping.get(companyOriginNameMapping.get(company)));
      }

      final Map<String, List<CsRunFlightPlan>> aircraftPlanMapping = flightMapping.get(company);
      if (MapUtils.isNotEmpty(aircraftPlanMapping)) {
        final Integer legNum =
            aircraftPlanMapping.values().stream().map(List::size).reduce(0, Integer::sum);
        companyGroup.setFlyLegNum(legNum);
      } else {
        companyGroup.setFlyLegNum(0);
      }

      List<FlightPlanAircraftNoGroup> aircraftNoFlightPlans = Lists.newArrayList();

      for (String aircraftNo : flightMapping.get(company).keySet()) {
        FlightPlanAircraftNoGroup aircraftNoGroup = new FlightPlanAircraftNoGroup();

        final AdsMblAircraftDeliveryInfo deliveryInfo = aircraftNoMapping.get(aircraftNo);

        aircraftNoGroup.setAircraftNo(aircraftNo);
        aircraftNoGroup.setMsn(deliveryInfo != null ? deliveryInfo.getMsn() : "");
        aircraftNoGroup.setFlightPlans(
            flightMapping.get(company).get(aircraftNo).stream()
                .map(e -> convertFlightPlan(e, deliveryInfo))
                .collect(Collectors.toList()));

        aircraftNoFlightPlans.add(aircraftNoGroup);
      }

      companyGroup.setAircraftNoFlightPlans(aircraftNoFlightPlans);

      companyFlightPlanes.add(companyGroup);
    }

    planData.setCompanyFlightPlans(companyFlightPlanes);

    sortFlightPlan(planData, isToday, aircraftNoMapping, companyDimMapping);

    fillNo(planData);
  }

  private FlightPlanItem convertFlightPlan(
      final CsRunFlightPlan e, final AdsMblAircraftDeliveryInfo deliveryInfo) {

    final FlightPlanItem item = new FlightPlanItem();
    item.setAircraftType(e.getAircraftType());
    item.setAircraftNo(e.getAircraftNo());
    item.setMsn(deliveryInfo != null ? deliveryInfo.getMsn() : "");
    item.setFlightNo(e.getFlightNo());
    item.setState(e.getFlightState());
    item.setServiceType(convertServiceType(e.getServiceType()));
    item.setDepAirport(e.getDepAirport());
    item.setDepPlanTime(e.getDepPlanTime());
    item.setDepActTime(e.getDepActTime());
    item.setArrAirport(e.getArrAirport());
    item.setArrPlanTime(e.getArrPlanTime());
    item.setArrActTime(e.getArrActTime());
    item.setCompany(e.getAirlineCompany());
    item.setAirlineThreeCode(e.getAirlineThreeCode());
    item.setDepFourCode(e.getDepFourCode());
    item.setArrFourCode(e.getArrFourCode());
    return item;
  }

  private String convertServiceType(String originServiceType) {

    if (StringUtils.equalsIgnoreCase(originServiceType, "O")) {
      return "调机";
    } else if (StringUtils.equalsIgnoreCase(originServiceType, "F")) {
      return "货机";
    } else {
      return "正班";
    }
  }

  private void sortFlightPlan(
      FlightPlanData data,
      boolean isToday,
      Map<String, AdsMblAircraftDeliveryInfo> aircraftNoMapping,
      Map<String, CsRunFlightPlanCompanyDim> companyDimMapping) {

    if (null == data) {
      return;
    }

    if (CollectionUtils.isNotEmpty(data.getCompanyFlightPlans())) {

      // 航司排序
      final List<FlightPlanCompanyGroup> sortedCompanyFlightPlans =
          data.getCompanyFlightPlans().stream()
              .sorted(
                  (o1, o2) -> {
                    final String o1Code = o1.getAirlineThreeCode();
                    final String o2Code = o2.getAirlineThreeCode();

                    if (StringUtils.isEmpty(o1Code)
                        || companyDimMapping.get(o1Code) == null
                        || companyDimMapping.get(o1Code).getPriority() == null) {
                      return 1;
                    }

                    if (StringUtils.isEmpty(o2Code)
                        || companyDimMapping.get(o2Code) == null
                        || companyDimMapping.get(o2Code).getPriority() == null) {
                      return -1;
                    }

                    return companyDimMapping
                        .get(o1Code)
                        .getPriority()
                        .compareTo(companyDimMapping.get(o2Code).getPriority());
                  })
              .collect(Collectors.toList());
      data.setCompanyFlightPlans(sortedCompanyFlightPlans);

      // 机号交付时间排序
      for (FlightPlanCompanyGroup companyGroup : data.getCompanyFlightPlans()) {
        final List<FlightPlanAircraftNoGroup> sortedAircraftNoFlightPlans =
            companyGroup.getAircraftNoFlightPlans().stream()
                .sorted(
                    (o1, o2) -> {
                      if (StringUtils.isEmpty(o1.getAircraftNo())
                          || null == aircraftNoMapping.get(o1.getAircraftNo())) {
                        return 1;
                      }

                      if (StringUtils.isEmpty(o2.getAircraftNo())
                          || null == aircraftNoMapping.get(o2.getAircraftNo())) {
                        return -1;
                      }

                      final String o1Date = aircraftNoMapping.get(o1.getAircraftNo()).getSortDate();

                      if (StringUtils.isEmpty(o1Date)) {
                        return 1;
                      }

                      final String o2Date = aircraftNoMapping.get(o2.getAircraftNo()).getSortDate();

                      if (StringUtils.isEmpty(o2Date)) {
                        return -1;
                      }

                      final int i = o1Date.compareTo(o2Date);

                      if (i == 0) {
                        // 比较机号的字典序
                        final String o1AircraftNo = o1.getAircraftNo();
                        final String o2AircraftNo = o2.getAircraftNo();

                        if (StringUtils.isEmpty(o1AircraftNo)) {
                          return 1;
                        }

                        if (StringUtils.isEmpty(o2AircraftNo)) {
                          return -1;
                        }

                        return o1AircraftNo.compareTo(o2AircraftNo);
                      }

                      return i;
                    })
                .collect(Collectors.toList());
        companyGroup.setAircraftNoFlightPlans(sortedAircraftNoFlightPlans);

        for (FlightPlanAircraftNoGroup aircraftNoGroup : companyGroup.getAircraftNoFlightPlans()) {
          final List<FlightPlanItem> sortedFlightPlans =
              aircraftNoGroup.getFlightPlans().stream()
                  .sorted(
                      (o1, o2) -> {
                        if (isToday) {
                          // 计划开始时间和结束时间

                          if (StringUtils.isEmpty(o1.getOriginDepPlanTime())) {
                            return 1;
                          }

                          if (StringUtils.isEmpty(o2.getOriginDepPlanTime())) {
                            return -1;
                          }

                          final int i =
                              o1.getOriginDepPlanTime().compareTo(o2.getOriginDepPlanTime());

                          if (i == 0) {
                            if (StringUtils.isEmpty(o1.getOriginArrPlanTime())) {
                              return 1;
                            }

                            if (StringUtils.isEmpty(o2.getOriginArrPlanTime())) {
                              return -1;
                            }

                            return o1.getOriginArrPlanTime().compareTo(o2.getOriginArrPlanTime());
                          }

                          return i;

                        } else {
                          // 实际开始时间和结束时间

                          if (StringUtils.isEmpty(o1.getOriginDepActTime())) {
                            return 1;
                          }

                          if (StringUtils.isEmpty(o2.getOriginDepActTime())) {
                            return -1;
                          }

                          final int i =
                              o1.getOriginDepActTime().compareTo(o2.getOriginDepActTime());

                          if (i == 0) {
                            if (StringUtils.isEmpty(o1.getOriginArrActTime())) {
                              return 1;
                            }

                            if (StringUtils.isEmpty(o2.getOriginArrActTime())) {
                              return -1;
                            }

                            return o1.getOriginArrActTime().compareTo(o2.getOriginArrActTime());
                          }

                          return i;
                        }
                      })
                  .collect(Collectors.toList());
          aircraftNoGroup.setFlightPlans(sortedFlightPlans);
        }
      }
    }
  }

  private void fillNo(FlightPlanData data) {
    if (data == null) {
      return;
    }

    if (CollectionUtils.isEmpty(data.getCompanyFlightPlans())) {
      return;
    }

    AtomicInteger no = new AtomicInteger(0);

    data.getCompanyFlightPlans()
        .forEach(
            companyGroup -> {
              AtomicInteger noWithCompany = new AtomicInteger(0);
              if (CollectionUtils.isNotEmpty(companyGroup.getAircraftNoFlightPlans())) {
                companyGroup
                    .getAircraftNoFlightPlans()
                    .forEach(
                        aircraftNoGroup -> {
                          if (CollectionUtils.isNotEmpty(aircraftNoGroup.getFlightPlans())) {
                            aircraftNoGroup
                                .getFlightPlans()
                                .forEach(
                                    e -> {
                                      e.setNo(String.valueOf(no.incrementAndGet()));
                                      e.setNoWithCompany(
                                          String.valueOf(noWithCompany.incrementAndGet()));
                                    });
                          }
                        });
              }
            });
  }
}
