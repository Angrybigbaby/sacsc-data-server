package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zijian.qjd
 * @since 2023/7/27 10:09
 */
@Data
@Table(name = "cs_run_flight_plan_email_to")
public class CsRunFlightPlanEmailTo {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "account")
  private String account;

  @Column(name = "email")
  private String email;

  /** 是否有效0=无效,1=有效 */
  @Column(name = "is_valid")
  private Short isValid = 1;
}
