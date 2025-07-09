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
 *     <p>燃油经济-统计数据
 */
@Table(name = "cs_fuel_consume_statistics")
@Data
public class CsFuelConsumeStatistics {
  /** id */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 航空公司数 */
  @Column(name = "listed_companies_total")
  private Integer listedCompaniesTotal;

  /** 飞机数 */
  @Column(name = "listed_aircrafts_total")
  private Integer listedAircraftsTotal;

  /** 起落次数 */
  @Column(name = "flights")
  private Integer flights;

  /** 空地时间（小时） */
  @Column(name = "fuel_inair_total")
  private Double fuelInairTotal;

  /** 空中飞行时间（小时） */
  @Column(name = "fuel_inair_total")
  private Double fuelInairTime;

  /** 空中平均燃油消耗率（千克/小时） */
  @Column(name = "fuel_inair_ratio")
  private Double fuelInairRatio;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
