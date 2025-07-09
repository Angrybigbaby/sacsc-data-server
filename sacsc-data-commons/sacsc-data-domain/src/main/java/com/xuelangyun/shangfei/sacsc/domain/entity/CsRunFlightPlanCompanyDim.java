package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zijian.qjd
 * @since 2023/6/28 9:44
 *     <p>航班计划专用纬度表
 */
@Data
@Table(name = "cs_run_flight_plan_company_dim")
public class CsRunFlightPlanCompanyDim {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 机型 */
  @Column(name = "model")
  private String model;

  /** 简称 */
  @Column(name = "abbreviation")
  private String abbreviation;

  /** 三字码 */
  @Column(name = "three_code")
  private String threeCode;

  /** 优先级 - 越小优先级越大 */
  @Column(name = "priority")
  private Integer priority;
}
