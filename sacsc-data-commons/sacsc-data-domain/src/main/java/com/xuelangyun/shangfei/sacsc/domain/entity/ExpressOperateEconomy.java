package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "express_operate_economy")
public class ExpressOperateEconomy {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 机型 */
  private String model;

  /** 直接运行成本(元/公里) */
  private Double cost;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
