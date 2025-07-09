package com.xuelangyun.shangfei.sacsc.datasource.mapper;

import com.xuelangyun.shangfei.sacsc.datasource.base.BaseMapper;
import com.xuelangyun.shangfei.sacsc.domain.entity.CsRunVariflight;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CsRunVariflightMapper extends BaseMapper<CsRunVariflight> {
  List<CsRunVariflight> selectVariAndSchedule(@Param("airCompany") String airCompany);

  List<CsRunVariflight> selectVariAndScheduelByAirCompanyAndDate(
      @Param("airCompany") String airCompany,
      @Param("scheduleDate") Date scheduleDate,
      @Param("variflightDate") Date variflightDate);
}
