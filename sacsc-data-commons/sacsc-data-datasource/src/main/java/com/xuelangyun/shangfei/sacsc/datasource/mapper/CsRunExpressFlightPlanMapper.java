package com.xuelangyun.shangfei.sacsc.datasource.mapper;

import com.xuelangyun.shangfei.sacsc.datasource.base.BaseMapper;
import com.xuelangyun.shangfei.sacsc.domain.entity.CsRunExpressFlightPlan;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zijian.qjd
 * @since 2023/5/31 16:13
 */
public interface CsRunExpressFlightPlanMapper extends BaseMapper<CsRunExpressFlightPlan> {

  @Select(
      " select * from cs_run_express_flight_plan "
          + " where flight_date = #{flightDate} "
          + " and create_time = (select max(create_time) from cs_run_express_flight_plan where flight_date = #{flightDate}) ")
  List<CsRunExpressFlightPlan> selectWithDate(String flightDate);

  @Select(
      "<script>"
          + " select a.* "
          + " from cs_run_express_flight_plan a "
          + " join (select flight_date, max(create_time) as create_time from cs_run_express_flight_plan where flight_date in "
          + " <foreach item='flightDate' index='index' collection='flightDateList' open='(' separator=',' close=')'> "
          + " #{flightDate} "
          + " </foreach> "
          + " group by flight_date) b "
          + " on a.flight_date = b.flight_date and a.create_time = b.create_time "
          + "</script>")
  List<CsRunExpressFlightPlan> selectWithMultiFlightDate(
      @Param("flightDateList") List<String> flightDateList);

  @Select(
      " select a.* "
          + " from (select * from cs_run_express_flight_plan where flight_date >= #{startFlightDate} and flight_date < #{endFlightDate}) a "
          + " join (select flight_date, max(create_time) as create_time from cs_run_express_flight_plan where flight_date >= #{startFlightDate} and flight_date < #{endFlightDate} group by flight_date) b "
          + " on a.flight_date = b.flight_date and a.create_time = b.create_time ")
  List<CsRunExpressFlightPlan> selectWithRangeFlightDate(
      @Param("startFlightDate") String startFlightDate,
      @Param("endFlightDate") String endFlightDate);
}
