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
 *     <p>燃油经济-不同飞行阶段燃油消耗量占比
 */
@Data
@Table(name = "cs_fuel_consume_rate_flight_phase")
public class CsFuelConsumeRateFlightPhase {
  /** id */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 编号 */
  @Column(name = "idx")
  private Integer idx;

  /** 飞行阶段 */
  @Column(name = "flight_phase")
  private String flightPhase;

  /** 燃油消耗量 */
  @Column(name = "fuel_consume")
  private Double fuelConsume;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
