package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "express_fuel_flow_monitor")
public class ExpressFuelFlowMonitor {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 机型 */
  private String model;

  /** 燃油流量(kg/h) */
  @Column(name = "fuel_flow")
  private Long fuelFlow;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
