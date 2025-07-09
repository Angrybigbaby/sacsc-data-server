package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "cs_run_air_schedule")
public class CsRunAirSchedule {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 航班号 */
  @Column(name = "airline_no")
  private String airlineNo;

  /** 航空公司名称 */
  @Column(name = "air_company")
  private String airCompany;

  @Column(name = "create_time")
  private Date createTime;
}
