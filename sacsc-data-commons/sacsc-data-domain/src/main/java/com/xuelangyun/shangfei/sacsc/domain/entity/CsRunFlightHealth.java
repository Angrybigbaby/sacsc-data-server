package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cs_run_flight_health")
public class CsRunFlightHealth {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 机型 */
  @Column(name = "tail_number")
  private String tailNumber;

  /** 指标名称 */
  @Column(name = "norm_name")
  private String normName;

  /** 系统权重 */
  @Column(name = "system_weigh")
  private Double systemWeigh;

  /** 系统评分 */
  @Column(name = "system_score")
  private Double systemScore;

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
   * 获取机型
   *
   * @return tail_number - 机型
   */
  public String getTailNumber() {
    return tailNumber;
  }

  /**
   * 设置机型
   *
   * @param tailNumber 机型
   */
  public void setTailNumber(String tailNumber) {
    this.tailNumber = tailNumber;
  }

  /**
   * 获取指标名称
   *
   * @return norm_name - 指标名称
   */
  public String getNormName() {
    return normName;
  }

  /**
   * 设置指标名称
   *
   * @param normName 指标名称
   */
  public void setNormName(String normName) {
    this.normName = normName;
  }

  /**
   * 获取系统权重
   *
   * @return system_weigh - 系统权重
   */
  public Double getSystemWeigh() {
    return systemWeigh;
  }

  /**
   * 设置系统权重
   *
   * @param systemWeigh 系统权重
   */
  public void setSystemWeigh(Double systemWeigh) {
    this.systemWeigh = systemWeigh;
  }

  /**
   * 获取系统评分
   *
   * @return system_score - 系统评分
   */
  public Double getSystemScore() {
    return systemScore;
  }

  /**
   * 设置系统评分
   *
   * @param systemScore 系统评分
   */
  public void setSystemScore(Double systemScore) {
    this.systemScore = systemScore;
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
