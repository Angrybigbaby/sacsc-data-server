package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "cs_run_air_company")
public class CsRunAirCompany {
  /** 序号 */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 航司名称 */
  @Column(name = "air_company")
  private String airCompany;

  /** 架机数量 */
  @Column(name = "plane_number")
  private Integer planeNumber;

  /** 航线数 */
  @Column(name = "line_number")
  private Integer lineNumber;

  /** 通航城市数 */
  @Column(name = "city_number")
  private Integer cityNumber;

  @Column(name = "create_time")
  private Date createTime;

  @Transient private Double flightTime;

  @Transient private Integer landTime;

  @Transient private String airCompanyLogo;

  @Transient private String airPlaneLogo;
}
