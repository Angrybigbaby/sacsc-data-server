package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "express_profit_efficiency")
public class ExpressProfitEfficiency {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 机型 */
  @Column(name = "model")
  private String model;

  /** 航班号 */
  @Column(name = "flight_number")
  private String flightNumber;

  /** 航段 */
  @Column(name = "flight_phase")
  private String flightPhase;

  /** 收益(元) */
  @Column(name = "flight_income")
  private Double flightIncome;

  /** 改航成本(元) */
  @Column(name = "divert_cost")
  private Double divertCost;

  /** 取消成本(元) */
  @Column(name = "cancel_cost")
  private Double cancelCost;

  /** 航班利润(元) */
  @Column(name = "flight_profit")
  private Double flightProfit;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
