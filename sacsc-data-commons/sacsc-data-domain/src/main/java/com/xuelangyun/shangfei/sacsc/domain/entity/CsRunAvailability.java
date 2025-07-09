package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cs_run_availability")
public class CsRunAvailability {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 日期:年月 */
  @Column(name = "stat_date")
  private String statDate;

  /** 可用率(%) */
  @Column(name = "availability_rate")
  private Double availabilityRate;

  /** 可用率(除去改装) */
  @Column(name = "excluded_availability_rate")
  private Double excludedAvailabilityRate;

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
   * 获取日期:年月
   *
   * @return stat_date - 日期:年月
   */
  public String getStatDate() {
    return statDate;
  }

  /**
   * 设置日期:年月
   *
   * @param statDate 日期:年月
   */
  public void setStatDate(String statDate) {
    this.statDate = statDate;
  }

  /**
   * 获取可用率(%)
   *
   * @return availability_rate - 可用率(%)
   */
  public Double getAvailabilityRate() {
    return availabilityRate;
  }

  /**
   * 设置可用率(%)
   *
   * @param availabilityRate 可用率(%)
   */
  public void setAvailabilityRate(Double availabilityRate) {
    this.availabilityRate = availabilityRate;
  }

  /**
   * 获取可用率(除去改装)
   *
   * @return excluded_availability_rate - 可用率(除去改装)
   */
  public Double getExcludedAvailabilityRate() {
    return excludedAvailabilityRate;
  }

  /**
   * 设置可用率(除去改装)
   *
   * @param excludedAvailabilityRate 可用率(除去改装)
   */
  public void setExcludedAvailabilityRate(Double excludedAvailabilityRate) {
    this.excludedAvailabilityRate = excludedAvailabilityRate;
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
