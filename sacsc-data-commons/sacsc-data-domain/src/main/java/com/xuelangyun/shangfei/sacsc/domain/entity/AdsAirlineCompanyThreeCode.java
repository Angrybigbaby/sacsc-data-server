package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author zijian.qjd
 * @since 2023/7/25 10:25
 */
@Table(name = "ads_airline_company_three_code")
@Data
public class AdsAirlineCompanyThreeCode {

  /** 航管航司名称 */
  @Column(name = "airline_company")
  private String airlineCompany;

  /** 映射后航司名称 */
  @Column(name = "standard_name")
  private String standardName;

  /** 航司三字码 */
  @Column(name = "airline_three_code")
  private String airlineThreeCode;

  /** 交付表航司名称 */
  @Column(name = "airline_name")
  private String airlineName;
}
