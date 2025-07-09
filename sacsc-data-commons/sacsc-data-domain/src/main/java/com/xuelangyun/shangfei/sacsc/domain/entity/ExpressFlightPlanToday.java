package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "express_flight_plan_today")
public class ExpressFlightPlanToday {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "flight_id")
  private String flightId;

  /** 航班号 */
  @Column(name = "flight_number")
  private String flightNumber;

  /** 航班日期 */
  @Column(name = "flight_date")
  private Date flightDate;

  /** 机号 */
  @Column(name = "tail_number")
  private String tailNumber;

  /** 起飞机场四字码 */
  @Column(name = "dep_code")
  private String depCode;

  /** 起飞机场 */
  @Column(name = "takeoff_airport")
  private String takeoffAirport;

  /** 到达机场四字码 */
  @Column(name = "arr_code")
  private String arrCode;

  /** 着陆机场 */
  @Column(name = "arrive_airport")
  private String arriveAirport;

  /** 计划起飞时刻 */
  @Column(name = "plan_takeoff_time")
  private Date planTakeoffTime;

  /** 预计起飞时刻 */
  @Column(name = "expected_takeoff_time")
  private Date expectedTakeoffTime;

  /** 实际起飞时刻 */
  @Column(name = "takeoff_time")
  private Date takeoffTime;

  /** 计划着陆时刻 */
  @Column(name = "plan_arrive_time")
  private Date planArriveTime;

  /** 实际降落时刻 */
  @Column(name = "arrive_time")
  private Date arriveTime;

  /** 预计降落时刻 */
  @Column(name = "expected_arrive_time")
  private Date expectedArriveTime;

  /** 当前状态 */
  private String status;

  /** 机型 */
  private String flying;

  /** 计划风险 */
  @Column(name = "plan_risk")
  private String planRisk;

  @Column(name = "create_time")
  private Date createTime;
}
