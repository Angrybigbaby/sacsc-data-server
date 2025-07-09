package com.xuelangyun.shangfei.sacsc.datasource.mapper;

import com.xuelangyun.shangfei.sacsc.datasource.base.BaseMapper;
import com.xuelangyun.shangfei.sacsc.domain.entity.CsPmAirInfo;
import com.xuelangyun.shangfei.sacsc.domain.vo.PmAirPortVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

/**
 * @author zijian.qjd
 * @since 2020/8/25
 */
public interface CsPmAirInfoMapper extends BaseMapper<CsPmAirInfo> {

  /**
   * 获取所有的架次名称
   *
   * @return -
   */
  @Select("select distinct tailnumber from cs_pm_air_info where create_time = #{date}")
  List<String> selectTailnumbers(@Param("date") Date date);

  /**
   * 获取tailnumber对应的flightid列表
   *
   * @param tailnumber -
   * @return -
   */
  @Select(
      "select flightid from cs_pm_air_info where create_time = #{date} and tailnumber = #{tailnumber} ")
  List<String> selectFlightIdsByTailnumber(
      @Param("tailnumber") String tailnumber, @Param("date") Date date);

  @Select(
      "select tailnumber,flightid from cs_pm_air_info where create_time = #{date} group by tailnumber,flightid")
  @Results({
    @Result(column = "tailnumber", property = "tailnumber", jdbcType = JdbcType.VARCHAR),
    @Result(column = "flightid", property = "flightid", jdbcType = JdbcType.VARCHAR)
  })
  List<CsPmAirInfo> selectTnAndFlightIdByDate(@Param("date") Date date);

  @Select(
      "select distinct operator from cs_pm_air_info where create_time = (select max(create_time) from cs_pm_air_info)")
  List<String> selectOperator();

  @Select(
      "select distinct tailnumber from cs_pm_air_info where create_time = (select max(create_time) from cs_pm_air_info) and operator = #{airCompany}")
  List<String> selectTns(@Param("airCompany") String airCompany);

  @Select({
    "select concat(airport_dep,'-',airport_arr) from cs_pm_air_info ",
    "where create_time = (select max(create_time) from cs_pm_air_info)",
    "and operator = #{airCompany} and tailnumber = #{tailNumber}",
    "group by airport_dep,airport_arr"
  })
  List<String> getPmAirPort(String airCompany, String tailNumber);

  PmAirPortVo getPmFlightTime(
      @Param("airCompany") String airCompany,
      @Param("tailNumber") String tailNumber,
      @Param("airportDep") String airportDep,
      @Param("airportArr") String airportArr);

  List<String> selectFlightIds(
      @Param("airCompany") String airCompany,
      @Param("tailNumber") String tailNumber,
      @Param("airportDep") String airportDep,
      @Param("airportArr") String airportArr,
      @Param("startTime") Date startTime,
      @Param("endTime") Date endTime);
}
