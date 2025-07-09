package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2020/8/20
 *     <p>燃油经济-交付飞机空中燃油消耗情况
 */
@Table(name = "cs_fuel_consume_rate_airplane_month")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CsFuelConsumeRateAirplaneMonth {

  /** id */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 年-月 */
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

  /** 机型 */
  @Column(name = "fly_model")
  private String flyModel;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
