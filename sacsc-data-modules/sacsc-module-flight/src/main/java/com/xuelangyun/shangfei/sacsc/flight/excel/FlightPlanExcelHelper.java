package com.xuelangyun.shangfei.sacsc.flight.excel;

import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.StyleSet;
import cn.hutool.poi.excel.style.StyleUtil;
import com.google.common.collect.Lists;
import com.xuelangyun.shangfei.sacsc.flight.vo.FlightPlanVO;
import com.xuelangyun.shangfei.sacsc.flight.vo.FlightPlanVO.FlightPlanAircraftNoGroup;
import com.xuelangyun.shangfei.sacsc.flight.vo.FlightPlanVO.FlightPlanCompanyGroup;
import com.xuelangyun.shangfei.sacsc.flight.vo.FlightPlanVO.FlightPlanData;
import com.xuelangyun.shangfei.sacsc.flight.vo.FlightPlanVO.FlightPlanItem;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/**
 * @author zijian.qjd
 * @since 2023/7/26 17:45
 */
public class FlightPlanExcelHelper {

  public static void setStyle(ExcelWriter writer) {
    final StyleSet styleSet = new StyleSet(writer.getWorkbook());
    writer.setStyleSet(styleSet);

    // 换行
    styleSet.setWrapText();

    //
    final CellStyle headCellStyle = styleSet.getHeadCellStyle();

    headCellStyle.setFillPattern(FillPatternType.LEAST_DOTS);

    final Font dataTitleFont = writer.createFont();
    dataTitleFont.setFontHeightInPoints((short) 12);
    dataTitleFont.setBold(true);
    dataTitleFont.setFontName("宋体");
    headCellStyle.setFont(dataTitleFont);

    //
    final CellStyle commonCellStyle = styleSet.getCellStyle();

    final Font commonFont = writer.createFont();
    commonFont.setFontHeightInPoints((short) 12);
    commonFont.setFontName("宋体");
    commonCellStyle.setFont(commonFont);
  }

  public static void setTodaySheetAlias(ExcelWriter writer) {
    writer.addHeaderAlias("no", "序号");
    writer.addHeaderAlias("aircraftNo", "机号");
    writer.addHeaderAlias("flightNo", "航班号");
    writer.addHeaderAlias("serviceType", "性质");
    writer.addHeaderAlias("depAirport", "起飞机场");
    writer.addHeaderAlias("depPlanTime", "计划起飞");
    writer.addHeaderAlias("arrAirport", "到达机场");
    writer.addHeaderAlias("arrPlanTime", "计划到达");
    writer.addHeaderAlias("company", "航空公司");
    writer.setOnlyAlias(true);
  }

  public static void setYesterdaySheetAlias(ExcelWriter writer) {
    writer.addHeaderAlias("no", "序号");
    writer.addHeaderAlias("aircraftNo", "机号");
    writer.addHeaderAlias("flightNo", "航班号");
    writer.addHeaderAlias("state", "状态");
    writer.addHeaderAlias("serviceType", "性质");
    writer.addHeaderAlias("depAirport", "起飞机场");
    writer.addHeaderAlias("depActTime", "起飞时间");
    writer.addHeaderAlias("arrAirport", "到达机场");
    writer.addHeaderAlias("arrActTime", "到达时间");
    writer.addHeaderAlias("company", "航空公司");
    writer.setOnlyAlias(true);
  }

  private static Font createModelTitleFont(ExcelWriter writer) {
    final Font modelTitleFont = writer.createFont();
    modelTitleFont.setFontHeightInPoints((short) 14);
    modelTitleFont.setBold(true);
    modelTitleFont.setFontName("宋体");
    return modelTitleFont;
  }

  private static Font createStatisticFont(ExcelWriter writer) {
    final Font statisticFont = writer.createFont();
    statisticFont.setFontHeightInPoints((short) 12);
    statisticFont.setColor(Font.COLOR_RED);
    statisticFont.setBold(true);
    statisticFont.setFontName("宋体");
    return statisticFont;
  }

  private static void writeData(ExcelWriter writer, ExcelWriteContext context) {

    final Font modelTitleFont = context.getModelTitleFont();
    final Font statisticFont = context.getStatisticFont();
    final int startIndex = context.getStartIndex();
    final String row0Content = context.getRow0Content();
    final FlightPlanData planData = context.getPlanData();
    final boolean isToday = context.isToday();

    final CellStyle row0Style = StyleUtil.createHeadCellStyle(writer.getWorkbook());
    row0Style.setFont(modelTitleFont);
    row0Style.setFillPattern(FillPatternType.LEAST_DOTS);
    writer.merge(startIndex, startIndex, 0, isToday ? 8 : 9, row0Content, row0Style);

    final CellStyle row1Style = StyleUtil.createHeadCellStyle(writer.getWorkbook());
    row1Style.setFont(statisticFont);
    row1Style.setFillPattern(FillPatternType.LEAST_DOTS);
    writer.merge(startIndex + 1, startIndex + 1, 0, 2, "执飞飞机总数：", row1Style);
    writer.merge(startIndex + 1, startIndex + 1, 3, 4, planData.getFlyPlaneNum(), row1Style);
    writer.merge(startIndex + 1, startIndex + 1, 5, isToday ? 6 : 7, "执飞航段总数：", row1Style);
    writer.merge(startIndex + 1, startIndex + 1, isToday ? 7 : 8, isToday ? 8 : 9, planData.getFlyLegNum(), row1Style);

    // data

    final List<FlightPlanItem> data = Lists.newArrayList();

    final List<FlightPlanCompanyGroup> companyFlightPlans =
        planData.getCompanyFlightPlans().stream()
            .filter(e -> CollectionUtils.isNotEmpty(e.getAircraftNoFlightPlans()))
            .collect(Collectors.toList());
    AtomicInteger companyMergeIndex = new AtomicInteger(startIndex + 3);
    AtomicInteger aircraftNoMergeIndex = new AtomicInteger(startIndex + 3);
    for (FlightPlanCompanyGroup companyGroup : companyFlightPlans) {
      final List<FlightPlanAircraftNoGroup> aircraftNoFlightPlans =
          companyGroup.getAircraftNoFlightPlans();

      for (FlightPlanAircraftNoGroup aircraftNoGroup : aircraftNoFlightPlans) {
        final List<FlightPlanItem> flightPlans = aircraftNoGroup.getFlightPlans();
        flightPlans.forEach(
            e -> {
              e.setAircraftNo(
                  String.format(
                      "%s\n(%s)", aircraftNoGroup.getAircraftNo(), aircraftNoGroup.getMsn()));
              e.setCompany(
                  String.format(
                      "%s\n(%s架)", companyGroup.getCompany(), companyGroup.getFlyPlaneNum()));
            });
        data.addAll(flightPlans);
        final int planSize = flightPlans.size();

        if (planSize == 1) {
          aircraftNoMergeIndex.incrementAndGet();
          continue;
        }

        writer.merge(
            aircraftNoMergeIndex.get(),
            aircraftNoMergeIndex.addAndGet(planSize) - 1,
            1,
            1,
            String.format("%s\n(%s)", aircraftNoGroup.getAircraftNo(), aircraftNoGroup.getMsn()),
            false);
      }

      if (CollectionUtils.isNotEmpty(aircraftNoFlightPlans)
          && aircraftNoFlightPlans.size() == 1
          && CollectionUtils.isNotEmpty(aircraftNoFlightPlans.get(0).getFlightPlans())
          && aircraftNoFlightPlans.get(0).getFlightPlans().size() == 1) {
        companyMergeIndex.incrementAndGet();
        continue;
      }

      writer.merge(
          companyMergeIndex.get(),
          aircraftNoMergeIndex.get() - 1,
          isToday ? 8 : 9,
          isToday ? 8 : 9,
          String.format("%s\n(%s架)", companyGroup.getCompany(), aircraftNoFlightPlans.size()),
          false);
      companyMergeIndex.set(aircraftNoMergeIndex.get());
    }
    writer.setCurrentRow(startIndex + 2);
    writer.write(data, true);
  }

  public static void writeFlightPlan(ExcelWriter writer, FlightPlanVO flightPlan, boolean isToday) {
    if (flightPlan != null) {
      final FlightPlanData arj21 = flightPlan.getArj21();
      final FlightPlanData c919 = flightPlan.getC919();

      final Font modelTitleFont = createModelTitleFont(writer);
      final Font statisticFont = createStatisticFont(writer);

      if (arj21 != null) {

        final String arj21Row =
            "C909机队航班时刻表("
                + flightPlan.getFlightYear()
                + "/"
                + flightPlan.getFlightMonth()
                + "/"
                + flightPlan.getFlightDay()
                + ")";

        writeData(
            writer,
            ExcelWriteContext.builder()
                .startIndex(0)
                .row0Content(arj21Row)
                .modelTitleFont(modelTitleFont)
                .statisticFont(statisticFont)
                .planData(arj21)
                .today(isToday)
                .build());
      }

      final int noteStartRow = writer.getRowCount();
      writer.setCurrentRow(noteStartRow);
      final String noteText = "注：翎亚航空航班时刻已转换为北京时间。";
      writer.writeRow(Lists.newArrayList("", noteText));

      final CellStyle noteStyle = writer.getOrCreateCellStyle(noteStartRow, 1);
      StyleUtil.setAlign(noteStyle, HorizontalAlignment.LEFT, VerticalAlignment.CENTER);

      writer.merge(noteStartRow, noteStartRow, 1, isToday ? 7 : 8, noteText, noteStyle);

      if (c919 != null) {
        final String c919Row =
            "C919机队航班时刻表("
                + flightPlan.getFlightYear()
                + "/"
                + flightPlan.getFlightMonth()
                + "/"
                + flightPlan.getFlightDay()
                + ")";

        writeData(
            writer,
            ExcelWriteContext.builder()
                .startIndex(writer.getRowCount())
                .row0Content(c919Row)
                .modelTitleFont(modelTitleFont)
                .statisticFont(statisticFont)
                .planData(c919)
                .today(isToday)
                .build());
      }
    }
  }
}
