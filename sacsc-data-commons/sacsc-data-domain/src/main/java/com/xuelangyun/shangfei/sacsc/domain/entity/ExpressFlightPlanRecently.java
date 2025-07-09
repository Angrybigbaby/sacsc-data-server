package com.xuelangyun.shangfei.sacsc.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "express_flight_plan_recently")
public class ExpressFlightPlanRecently {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 日期 */
  @Column(name = "flight_date")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date flightDate;

  /** 航班号 */
  @Column(name = "flight_number")
  private String flightNumber;

  /** 起飞机场 */
  @Column(name = "takeoff_airport")
  private String takeoffAirport;

  /** 降落机场 */
  @Column(name = "arrive_airport")
  private String arriveAirport;

  /** 计划起飞时刻 */
  @Column(name = "plan_takeoff_time")
  @JsonFormat(pattern = "HH:mm:ss")
  private Date planTakeoffTime;

  /** 计划降落时刻 */
  @Column(name = "plan_arrive_time")
  @JsonFormat(pattern = "HH:mm:ss")
  private Date planArriveTime;

  /** 计划风险 */
  @Column(name = "plan_risk")
  private String planRisk;

  /** 执飞 */
  private String flying;

  /** 机号 */
  @Column(name = "tail_number")
  private String tailNumber;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;

  /** 起飞机场四字码 */
  @Column(name = "dep_code")
  private String depCode;

  /** 降落机场四字码 */
  @Column(name = "arr_code")
  private String arrCode;
}
