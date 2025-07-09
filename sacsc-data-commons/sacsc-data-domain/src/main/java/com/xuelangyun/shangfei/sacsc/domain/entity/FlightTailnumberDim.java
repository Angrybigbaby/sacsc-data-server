package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zijian.qjd
 * @since 2025/4/19
 */
@Data
@Table(name = "flight_tailnumber_dim")
public class FlightTailnumberDim {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  @Column(name = "tailnumber")
  private String tailnumber;

  @Column(name = "standard_company_three_code")
  private String standardCompanyThreeCode;

  @Column(name = "standard_company")
  private String standardCompany;
}
