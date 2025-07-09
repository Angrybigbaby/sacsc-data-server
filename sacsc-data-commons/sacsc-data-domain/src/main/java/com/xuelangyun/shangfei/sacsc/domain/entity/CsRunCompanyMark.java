package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2022/2/22 15:18
 */
@Data
@Table(name = "cs_run_company_mark")
public class CsRunCompanyMark {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  /** 航司名称 */
  @Column(name = "company")
  private String company;

  /** 三字码 */
  @Column(name = "code")
  private String code;

  /** 0 - 官方名称 1 - 非官方 */
  @Column(name = "official")
  private Short official;

  @Column(name = "create_time")
  private Date createTime;
}
