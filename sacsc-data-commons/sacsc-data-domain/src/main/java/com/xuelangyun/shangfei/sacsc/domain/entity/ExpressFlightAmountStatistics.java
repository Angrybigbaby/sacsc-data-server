package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "express_flight_amount_statistics")
public class ExpressFlightAmountStatistics {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 机型 */
  private String model;

  /** 国内数 */
  @Column(name = "civil_amount")
  private Long civilAmount;

  /** 国际数 */
  @Column(name = "international_amount")
  private Long internationalAmount;

  /** 实飞数 */
  @Column(name = "actual_flight_amount")
  private Long actualFlightAmount;

  /** 应飞数 */
  @Column(name = "plan_flight_amount")
  private Long planFlightAmount;

  /** 训练数 */
  @Column(name = "train_amount")
  private Long trainAmount;

  /** 通勤数 */
  @Column(name = "commuter_amount")
  private Long commuterAmount;

  /** 其他数 */
  @Column(name = "other_amount")
  private Long otherAmount;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
