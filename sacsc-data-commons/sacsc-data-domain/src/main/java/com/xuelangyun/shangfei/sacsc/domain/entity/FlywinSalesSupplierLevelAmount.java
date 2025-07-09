package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "flywin_sales_supplier_level_amount")
public class FlywinSalesSupplierLevelAmount {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 供应商类别 */
  @Column(name = "supplier_type")
  private String supplierType;

  /** A+ */
  @Column(name = "more_a_amount")
  private Integer moreAAmount;

  /** A */
  @Column(name = "a_amount")
  private Integer aAmount;

  /** B+ */
  @Column(name = "more_b_amount")
  private Integer moreBAmount;

  /** B */
  @Column(name = "b_amount")
  private Integer bAmount;

  /** C */
  @Column(name = "c_amount")
  private Integer cAmount;

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
   * 获取供应商类别
   *
   * @return supplier_type - 供应商类别
   */
  public String getSupplierType() {
    return supplierType;
  }

  /**
   * 设置供应商类别
   *
   * @param supplierType 供应商类别
   */
  public void setSupplierType(String supplierType) {
    this.supplierType = supplierType;
  }

  /**
   * 获取A+
   *
   * @return more_a_amount - A+
   */
  public Integer getMoreAAmount() {
    return moreAAmount;
  }

  /**
   * 设置A+
   *
   * @param moreAAmount A+
   */
  public void setMoreAAmount(Integer moreAAmount) {
    this.moreAAmount = moreAAmount;
  }

  /**
   * 获取A
   *
   * @return a_amount - A
   */
  public Integer getaAmount() {
    return aAmount;
  }

  /**
   * 设置A
   *
   * @param aAmount A
   */
  public void setaAmount(Integer aAmount) {
    this.aAmount = aAmount;
  }

  /**
   * 获取B+
   *
   * @return more_b_amount - B+
   */
  public Integer getMoreBAmount() {
    return moreBAmount;
  }

  /**
   * 设置B+
   *
   * @param moreBAmount B+
   */
  public void setMoreBAmount(Integer moreBAmount) {
    this.moreBAmount = moreBAmount;
  }

  /**
   * 获取B
   *
   * @return b_amount - B
   */
  public Integer getbAmount() {
    return bAmount;
  }

  /**
   * 设置B
   *
   * @param bAmount B
   */
  public void setbAmount(Integer bAmount) {
    this.bAmount = bAmount;
  }

  /**
   * 获取C
   *
   * @return c_amount - C
   */
  public Integer getcAmount() {
    return cAmount;
  }

  /**
   * 设置C
   *
   * @param cAmount C
   */
  public void setcAmount(Integer cAmount) {
    this.cAmount = cAmount;
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
