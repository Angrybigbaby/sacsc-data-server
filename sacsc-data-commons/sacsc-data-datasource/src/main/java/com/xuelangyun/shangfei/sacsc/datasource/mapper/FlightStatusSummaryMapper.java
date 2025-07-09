package com.xuelangyun.shangfei.sacsc.datasource.mapper;

import com.xuelangyun.shangfei.sacsc.datasource.base.BaseMapper;
import com.xuelangyun.shangfei.sacsc.domain.entity.FlightStatusSummary;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface FlightStatusSummaryMapper extends BaseMapper<FlightStatusSummary> {
  /**
   * 获取航班号列表
   *
   * @return -
   */
  @Select("select distinct flight_number from flight_status_summary where create_time = #{date}")
  List<String> selectFlightNumbers(@Param("date") Date date);
}
