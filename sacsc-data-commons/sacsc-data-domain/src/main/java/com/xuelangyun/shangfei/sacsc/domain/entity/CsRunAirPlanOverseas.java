package com.xuelangyun.shangfei.sacsc.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2023/3/6 13:30
 */
@Data
@Table(name = "cs_run_air_plan_overseas")
public class CsRunAirPlanOverseas {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 航班号 */
  @Column(name = "flight_two_no")
  private String flightTwoNo;

  /** 注册号 */
  @Column(name = "reg_number")
  private String regNumber;

  /** 航空公司 */
  @Column(name = "airline_company")
  private String airlineCompany;

  /** 起飞机场 */
  @Column(name = "dep_port")
  private String depPort;

  /** 起飞机场四字码 */
  @Column(name = "dep_code")
  private String depCode;

  /** 到达机场 */
  @Column(name = "arr_port")
  private String arrPort;

  /** 目的地机场四字码 */
  @Column(name = "arr_code")
  private String arrCode;

  /** 计划起飞时间 */
  @Column(name = "dep_plan_time")
  @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
  private Date depPlanTime;

  /** 计划到达时间 */
  @Column(name = "arr_plan_time")
  @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
  private Date arrPlanTime;

  /** 预计到达时间 */
  @Column(name = "arr_ready_time")
  @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
  private Date arrReadyTime;

  /** 机型 */
  @Column(name = "aircraft_type")
  private String aircraftType;

  @Column(name = "create_time")
  private Date createTime;

  @Transient private String companyLogo;
  @Transient private String companyIcon;
  @Transient private String code;
}
