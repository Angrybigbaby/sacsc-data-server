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
 *     <p>燃油经济-空中燃油消耗率情况
 */
@Table(name = "cs_fuel_consume_rate_month")
@Data
public class CsFuelConsumeRateMonth {
  /** id */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 年月份 */
  @Column(name = "stat_date")
  private String statDate;

  /** 空中燃油消耗率（千克/小时） */
  @Column(name = "fuel_rate_inair")
  private Double fuelRateInair;

  /** 空中燃油消耗量（千克） */
  @Column(name = "fuel_inair")
  private Double fuelInair;

  /** 空中飞行时间（小时） */
  @Column(name = "time_in_air")
  private Double timeInAir;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
