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
 *     <p>燃油经济_空中燃油消耗率排行
 */
@Table(name = "cs_fuel_consume_rate_rank")
@Data
public class CsFuelConsumeRateRank {
  /** id */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 排序 */
  @Column(name = "idx")
  private Integer idx;

  /** 机号 */
  @Column(name = "tailnumber")
  private String tailnumber;

  /** 空中燃油消耗率（千克/小时） */
  @Column(name = "fuel_rate_inair")
  private Double fuelRateInair;

  /** 航司 */
  @Column(name = "aviation")
  private String aviation;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
