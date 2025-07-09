package com.xuelangyun.shangfei.sacsc.datasource.mapper;

import com.xuelangyun.shangfei.sacsc.datasource.base.BaseMapper;
import com.xuelangyun.shangfei.sacsc.domain.entity.CsRunFlightPlan;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zijian.qjd
 * @since 2023/5/31 16:13
 */
public interface CsRunFlightPlanMapper extends BaseMapper<CsRunFlightPlan> {

  @Select(
      " select * from cs_run_flight_plan where "
          + " flight_date = #{flightDate} "
          + " and create_time = (select max(create_time) from cs_run_flight_plan where flight_date = #{flightDate}) "
          + " and flight_state <> '取消' "
          + " and stop_flag <> 1 ")
  List<CsRunFlightPlan> selectWithoutStopAndCancel(String flightDate);

  @Select(
      " select * from cs_run_flight_plan where "
          + " flight_date = #{flightDate} "
          + " and create_time = (select max(create_time) from cs_run_flight_plan where flight_date = #{flightDate}) "
          + " and flight_state <> '取消' ")
  List<CsRunFlightPlan> selectWithoutCancel(String flightDate);
}
