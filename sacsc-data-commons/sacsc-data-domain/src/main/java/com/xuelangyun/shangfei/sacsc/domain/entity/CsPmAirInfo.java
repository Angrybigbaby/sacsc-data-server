package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2020/8/25
 */
@Table(name = "cs_pm_air_info")
@Data
public class CsPmAirInfo {
  /** id */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 飞机尾号 */
  @Column(name = "tailnumber")
  private String tailnumber;

  /** 飞机ID */
  @Column(name = "flightid")
  private String flightid;

  /** 航空公司 */
  @Column(name = "operator")
  private String operator;

  /** 飞机起降时间中点 */
  @Column(name = "flighttime")
  private Date flighttime;

  /** 起飞机场 */
  @Column(name = "airport_dep")
  private String airportDep;

  /** 降落机场 */
  @Column(name = "airport_arr")
  private String airportArr;

  /** 巡航大气静温 */
  @Column(name = "p6_mean_sat")
  private Double p6MeanSat;

  /** 巡航风速 */
  @Column(name = "p6_mean_wind")
  private Double p6MeanWind;

  /** 起飞重量 */
  @Column(name = "weight_tko")
  private Double weightTko;

  /** 百公里油耗 */
  @Column(name = "fuel_rate_per100km")
  private Double fuelRatePer100km;

  /** 空中油耗总计 */
  @Column(name = "landing_fuel")
  private Double landingFuel;

  /** 空中油耗率 */
  @Column(name = "p3t9_fuel_rate_trend")
  private Double p3t9FuelRateTrend;

  /** 起飞推力 */
  @Column(name = "rate")
  private Double rate;

  /** 飞机型号 */
  @Column(name = "fly_model")
  private String flyModel;

  /** 发动机型号 */
  @Column(name = "engine_model")
  private String engineModel;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
