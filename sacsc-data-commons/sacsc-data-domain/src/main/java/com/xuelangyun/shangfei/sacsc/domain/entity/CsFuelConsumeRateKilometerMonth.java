package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2020/8/20
 *     <p>燃油经济-空中燃油消耗率情况百公里消耗
 */
@Data
@Table(name = "cs_fuel_consume_rate_kilometer_month")
public class CsFuelConsumeRateKilometerMonth {
  /** id */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 年-月 */
  @Column(name = "stat_date")
  private String statDate;

  /** 百公里油耗（千克） */
  @Column(name = "fuel_dist")
  private Double fuelDist;

  /** 飞行巡航高度（英尺） */
  @Column(name = "p6_mean_alt")
  private Double p6MeanAlt;

  /** 飞行距离（千米） */
  @Column(name = "flightdist")
  private Double flightdist;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
