package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cs_run_thhour_failure")
public class CsRunThhourFailure {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 日期:年-月 */
  @Column(name = "stat_date")
  private String statDate;

  /** 故障千时率(%) */
  @Column(name = "hour_failure_rate")
  private Double hourFailureRate;

  /** 12月平均值 */
  @Column(name = "l12_hour_failure_rate")
  private Double l12HourFailureRate;

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
   * 获取故障千时率(%)
   *
   * @return hour_failure_rate - 故障千时率(%)
   */
  public Double getHourFailureRate() {
    return hourFailureRate;
  }

  /**
   * 设置故障千时率(%)
   *
   * @param hourFailureRate 故障千时率(%)
   */
  public void setHourFailureRate(Double hourFailureRate) {
    this.hourFailureRate = hourFailureRate;
  }

  /**
   * 获取12月平均值
   *
   * @return l12_hour_failure_rate - 12月平均值
   */
  public Double getL12HourFailureRate() {
    return l12HourFailureRate;
  }

  /**
   * 设置12月平均值
   *
   * @param l12HourFailureRate 12月平均值
   */
  public void setL12HourFailureRate(Double l12HourFailureRate) {
    this.l12HourFailureRate = l12HourFailureRate;
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
