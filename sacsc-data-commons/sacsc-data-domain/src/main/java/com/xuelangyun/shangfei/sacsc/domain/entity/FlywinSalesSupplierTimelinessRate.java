package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "flywin_sales_supplier_timeliness_rate")
public class FlywinSalesSupplierTimelinessRate {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 日期:年-月 */
  @Column(name = "stat_date")
  private String statDate;

  /** A+及时率 */
  @Column(name = "more_a_rate")
  private Double moreARate;

  /** A */
  @Column(name = "a_rate")
  private Double aRate;

  /** B+ */
  @Column(name = "more_b_rate")
  private Double moreBRate;

  /** B */
  @Column(name = "b_rate")
  private Double bRate;

  /** C */
  @Column(name = "c_rate")
  private Double cRate;

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
   * 获取日期:年-月
   *
   * @return stat_date - 日期:年-月
   */
  public String getStatDate() {
    return statDate;
  }

  /**
   * 设置日期:年-月
   *
   * @param statDate 日期:年-月
   */
  public void setStatDate(String statDate) {
    this.statDate = statDate;
  }

  /**
   * 获取A+及时率
   *
   * @return more_a_rate - A+及时率
   */
  public Double getMoreARate() {
    return moreARate;
  }

  /**
   * 设置A+及时率
   *
   * @param moreARate A+及时率
   */
  public void setMoreARate(Double moreARate) {
    this.moreARate = moreARate;
  }

  /**
   * 获取A
   *
   * @return a_rate - A
   */
  public Double getaRate() {
    return aRate;
  }

  /**
   * 设置A
   *
   * @param aRate A
   */
  public void setaRate(Double aRate) {
    this.aRate = aRate;
  }

  /**
   * 获取B+
   *
   * @return more_b_rate - B+
   */
  public Double getMoreBRate() {
    return moreBRate;
  }

  /**
   * 设置B+
   *
   * @param moreBRate B+
   */
  public void setMoreBRate(Double moreBRate) {
    this.moreBRate = moreBRate;
  }

  /**
   * 获取B
   *
   * @return b_rate - B
   */
  public Double getbRate() {
    return bRate;
  }

  /**
   * 设置B
   *
   * @param bRate B
   */
  public void setbRate(Double bRate) {
    this.bRate = bRate;
  }

  /**
   * 获取C
   *
   * @return c_rate - C
   */
  public Double getcRate() {
    return cRate;
  }

  /**
   * 设置C
   *
   * @param cRate C
   */
  public void setcRate(Double cRate) {
    this.cRate = cRate;
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
