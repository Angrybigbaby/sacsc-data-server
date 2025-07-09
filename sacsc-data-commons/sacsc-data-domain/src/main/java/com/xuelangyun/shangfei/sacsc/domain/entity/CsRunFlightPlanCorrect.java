package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2023/5/31 16:07
 */
@Data
@Table(name = "cs_run_flight_plan_correct")
public class CsRunFlightPlanCorrect {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 航班号 */
  @Column(name = "flight_no")
  private String flightNo;

  /**
   * 航班服务类型（J-定期客运航班，S-定期客运短程往返航班，G-定期客运增班航班，C-包机客运航班，B-定期客运短程往返增班航班，U-定期客运陆地（如火车）运输，Q-客货混舱航班，R-客货混舱增班航班，F-定期货运航班（散货或预装设备），A-货运（货物或邮包）增班航班，V-货运（货物或邮包）陆地运输，M-邮包航班，P-调机航班）
   */
  @Column(name = "service_type")
  private String serviceType;

  /** 航班属性（0:国内-国内;1国内-国际;2国内-地区;3:地区-国际;4:国际-国际;5:地区-地区） */
  @Column(name = "flight_property")
  private String flightProperty;

  /** 出发机场名 */
  @Column(name = "dep_airport")
  private String depAirport;

  /** 到达机场名 */
  @Column(name = "arr_airport")
  private String arrAirport;

  /** 出发地所属国家英文名 */
  @Column(name = "dep_country_name")
  private String depCountryName;

  /** 目的地所属国家英文名 */
  @Column(name = "arr_country_name")
  private String arrCountryName;

  /** 出发地所属城市名 */
  @Column(name = "dep_city_name")
  private String depCityName;

  /** 目的地所属城市名 */
  @Column(name = "arr_city_name")
  private String arrCityName;

  /** 计划起飞时间（yyyy-mm-dd hh:mm:ss格式） */
  @Column(name = "dep_plan_time")
  private String depPlanTime;

  /** 计划到达时间（yyyy-mm-dd hh:mm:ss格式） */
  @Column(name = "arr_plan_time")
  private String arrPlanTime;

  /** 官方预计起飞时间（yyyy-mm-dd hh:mm:ss格式） */
  @Column(name = "dep_ready_time")
  private String depReadyTime;

  /** 官方预计到达时间（yyyy-mm-dd hh:mm:ss格式） */
  @Column(name = "arr_ready_time")
  private String arrReadyTime;

  /** 实际推出时间（yyyy-mm-dd hh:mm:ss格式） */
  @Column(name = "out_gate_time")
  private String outGateTime;

  /** 实际推入时间（yyyy-mm-dd hh:mm:ss格式） */
  @Column(name = "in_gate_time")
  private String inGateTime;

  /** 实际起飞时间（yyyy-mm-dd hh:mm:ss格式） */
  @Column(name = "dep_act_time")
  private String depActTime;

  /** 实际到达时间（yyyy-mm-dd hh:mm:ss格式） */
  @Column(name = "arr_act_time")
  private String arrActTime;

  /** 航班状态（计划，起飞，到达，延误，取消，备降，返航，失联，失事） */
  @Column(name = "flight_state")
  private String flightState;

  /** 是否共享（0:不共享;1:共享） */
  @Column(name = "share_flag")
  private String shareFlag;

  /** 执飞/承运航班号（当查询航班为共享航班时此字段有值） */
  @Column(name = "main_flight_no")
  private String mainFlightNo;

  /** 是否经停（0：不经停；其他数字：代表经停次数） */
  @Column(name = "stop_flag")
  private String stopFlag;

  /** 经停地机场三字码（多个经停地用|分割，如：TSN|CAN） */
  @Column(name = "stop_airport_code")
  private String stopAirportCode;

  /** 出发地机场所在时区 */
  @Column(name = "dep_timezone")
  private String depTimezone;

  /** 目的地机场所在时区 */
  @Column(name = "arr_timezone")
  private String arrTimezone;

  /** 航空公司名 */
  @Column(name = "airline_company")
  private String airlineCompany;

  /** 补班航班号 */
  @Column(name = "fill_flight_no")
  private String fillFlightNo;

  /** 航班取消时间 */
  @Column(name = "flight_cancel_time")
  private String flightCancelTime;

  /** 飞机编号 */
  @Column(name = "aircraft_no")
  private String aircraftNo;

  /** 机型 */
  @Column(name = "aircraft_type")
  private String aircraftType;

  /** 飞行距离/里程 */
  @Column(name = "distance")
  private String distance;

  /** 航司三字码 */
  @Column(name = "airline_three_code")
  private String airlineThreeCode;

  /** 出发机场四字码 */
  @Column(name = "dep_four_code")
  private String depFourCode;

  /** 到达机场四字码 */
  @Column(name = "arr_four_code")
  private String arrFourCode;

  /** 计划飞行时长 */
  @Column(name = "plan_fly_time")
  private String planFlyTime;

  /** 是否跨天 */
  @Column(name = "across_day")
  private String acrossDay;

  @Column(name = "create_time")
  private Date createTime;

  /** 航班计划日期 */
  @Column(name = "flight_date")
  private String flightDate;
}
