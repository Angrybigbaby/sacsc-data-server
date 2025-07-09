package com.xuelangyun.shangfei.sacsc.data.server.web.controller;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.RateLimiter;
import com.xuelangyun.shangfei.sacsc.core.exception.BusinessException;
import com.xuelangyun.shangfei.sacsc.core.response.RestResponseEntity;
import com.xuelangyun.shangfei.sacsc.core.response.StatusCode;
import com.xuelangyun.shangfei.sacsc.data.server.web.response.FlyingInfo;
import com.xuelangyun.shangfei.sacsc.datasource.mapper.*;
import com.xuelangyun.shangfei.sacsc.domain.entity.CsRunFlightCas;
import com.xuelangyun.shangfei.sacsc.domain.entity.CsRunFlightCms;
import com.xuelangyun.shangfei.sacsc.domain.entity.CsRunFlightHistoryFault;
import com.xuelangyun.shangfei.sacsc.domain.entity.CsRunFlyingInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author zijian.qjd
 * @since 2024/11/21
 */
@RestController
@RequestMapping("/data/api")
public class DataApiController {

  RateLimiter getFlyingInfoLimiter = RateLimiter.create(1);

  @Autowired private CsRunFlyingInfoMapper csRunFlyingInfoMapper;
  @Autowired private CsRunFlightCmsMapper csRunFlightCmsMapper;
  @Autowired private CsRunFlightCasMapper csRunFlightCasMapper;
  @Autowired private CsRunFlightHistoryFaultMapper csRunFlightHistoryFaultMapper;

  @Autowired private AdsMblAircraftDeliveryInfoMapper deliveryInfoMapper;

  @GetMapping("/getFlyingInfo")
  public RestResponseEntity<FlyingInfo> getFlyingInfo() {

    final boolean b = getFlyingInfoLimiter.tryAcquire();
    if (!b) {
      throw new BusinessException(StatusCode.ERROR, "请稍后再试");
    }

    FlyingInfo res = new FlyingInfo();

    final Date date = csRunFlyingInfoMapper.selectMaxCreateTime();
    if (date != null) {
      final List<CsRunFlyingInfo> flyingPlanes = getFlyingPlanes(date);
      res.setCsRunFlyingInfos(flyingPlanes);

      CsRunFlightCas query2 = new CsRunFlightCas();
      query2.setCreateTime(date);
      final List<CsRunFlightCas> csRunFlightCas = csRunFlightCasMapper.select(query2);
      res.setCsRunFlightCas(csRunFlightCas);

      CsRunFlightCms query3 = new CsRunFlightCms();
      query3.setCreateTime(date);
      final List<CsRunFlightCms> csRunFlightCms = csRunFlightCmsMapper.select(query3);
      res.setCsRunFlightCms(csRunFlightCms);

      CsRunFlightHistoryFault query4 = new CsRunFlightHistoryFault();
      query4.setCreateTime(date);
      final List<CsRunFlightHistoryFault> csRunFlightHistoryFaults =
          csRunFlightHistoryFaultMapper.select(query4);
      csRunFlightHistoryFaults.forEach(e -> e.setOriginTime(e.getTime()));
      res.setCsRunFlightHistoryFaults(csRunFlightHistoryFaults);
    }

    return new RestResponseEntity<>(res);
  }

  private List<CsRunFlyingInfo> getFlyingPlanes(Date date) {

    if (date == null) {
      return Lists.newArrayList();
    }

    List<CsRunFlyingInfo> c909FlyingInfos =
        csRunFlyingInfoMapper.selectWithDeliverInfo("航司涂装", "C909" + "%", date);

    List<CsRunFlyingInfo> c919FlyingInfos =
        csRunFlyingInfoMapper.selectWithDeliverInfo("C919涂装", "C919" + "%", date);

    List<CsRunFlyingInfo> flyingInfos = Lists.newArrayList();

    if (CollectionUtils.isNotEmpty(c909FlyingInfos)) {
      flyingInfos.addAll(c909FlyingInfos);
    }

    if (CollectionUtils.isNotEmpty(c919FlyingInfos)) {
      flyingInfos.addAll(c919FlyingInfos);
    }

    return flyingInfos;
  }
}
