package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cs_run_dmc")
public class CsRunDmc {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 日期 */
  @Column(name = "stat_date")
  private String statDate;

  /** 机队累计DMC（全时段统计）USD/FH */
  @Column(name = "total_dmc")
  private Double totalDmc;

  /** 机队累计DMC（12月平均值）USD/FH */
  @Column(name = "months_dmc")
  private Double monthsDmc;

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
   * 获取日期
   *
   * @return stat_date - 日期
   */
  public String getStatDate() {
    return statDate;
  }

  /**
   * 设置日期
   *
   * @param statDate 日期
   */
  public void setStatDate(String statDate) {
    this.statDate = statDate;
  }

  /**
   * 获取机队累计DMC（全时段统计）USD/FH
   *
   * @return total_dmc - 机队累计DMC（全时段统计）USD/FH
   */
  public Double getTotalDmc() {
    return totalDmc;
  }

  /**
   * 设置机队累计DMC（全时段统计）USD/FH
   *
   * @param totalDmc 机队累计DMC（全时段统计）USD/FH
   */
  public void setTotalDmc(Double totalDmc) {
    this.totalDmc = totalDmc;
  }

  /**
   * 获取机队累计DMC（12月平均值）USD/FH
   *
   * @return months_dmc - 机队累计DMC（12月平均值）USD/FH
   */
  public Double getMonthsDmc() {
    return monthsDmc;
  }

  /**
   * 设置机队累计DMC（12月平均值）USD/FH
   *
   * @param monthsDmc 机队累计DMC（12月平均值）USD/FH
   */
  public void setMonthsDmc(Double monthsDmc) {
    this.monthsDmc = monthsDmc;
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
