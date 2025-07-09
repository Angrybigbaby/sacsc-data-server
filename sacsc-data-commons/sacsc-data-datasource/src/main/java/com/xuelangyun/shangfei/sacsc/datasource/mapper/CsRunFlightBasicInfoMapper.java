package com.xuelangyun.shangfei.sacsc.datasource.mapper;

import com.xuelangyun.shangfei.sacsc.datasource.base.BaseMapper;
import com.xuelangyun.shangfei.sacsc.domain.entity.CsRunFlightBasicInfo;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface CsRunFlightBasicInfoMapper extends BaseMapper<CsRunFlightBasicInfo> {

  @Select({"select distinct tail_number from cs_run_flight_health"})
  List<String> selectTnByDate(Date date);
}
