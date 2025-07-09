package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "cs_run_air_company_base")
public class CsRunAirCompanyBase {
  /** 序号 */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 航司名称 */
  @Column(name = "air_company")
  private String airCompany;

  /** 飞行时间（小时） */
  @Column(name = "flight_time")
  private Double flightTime;

  /** 飞行起落(次数) */
  @Column(name = "land_time")
  private Integer landTime;

  @Column(name = "create_time")
  private Date createTime;
}
