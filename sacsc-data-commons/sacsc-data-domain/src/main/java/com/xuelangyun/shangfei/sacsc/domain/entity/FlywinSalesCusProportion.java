package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "flywin_sales_cus_proportion")
public class FlywinSalesCusProportion {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 客户类别 */
  @Column(name = "cus_company")
  private String cusCompany;

  /** 占比(%) */
  private Double proportion;

  @Column(name = "create_time")
  private Date createTime;

  /** @return id */
  public Long getId() {
    return id;
  }

  /** @param id */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取客户类别
   *
   * @return cus_company - 客户类别
   */
  public String getCusCompany() {
    return cusCompany;
  }

  /**
   * 设置客户类别
   *
   * @param cusCompany 客户类别
   */
  public void setCusCompany(String cusCompany) {
    this.cusCompany = cusCompany;
  }

  /**
   * 获取占比(%)
   *
   * @return proportion - 占比(%)
   */
  public Double getProportion() {
    return proportion;
  }

  /**
   * 设置占比(%)
   *
   * @param proportion 占比(%)
   */
  public void setProportion(Double proportion) {
    this.proportion = proportion;
  }

  /** @return create_time */
  public Date getCreateTime() {
    return createTime;
  }

  /** @param createTime */
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
