package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "express_flight_punctuality_rate")
public class ExpressFlightPunctualityRate {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 机型 */
  private String model;

  /** 航班正常率(百分比) */
  @Column(name = "flight_punctuality_rate")
  private Float flightPunctualityRate;

  /** 平均日利用率(小时/日) */
  @Column(name = "avg_daily_hours")
  private Float avgDailyHours;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
