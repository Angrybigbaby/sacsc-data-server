package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "flywin_service_csc_ps_r")
public class FlywinServiceCscPsR {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 当日故障总数 */
  @Column(name = "day_total")
  private Integer dayTotal;

  /** 当月SR总数 */
  @Column(name = "month_sr")
  private Integer monthSr;

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
   * 获取当日故障总数
   *
   * @return day_total - 当日故障总数
   */
  public Integer getDayTotal() {
    return dayTotal;
  }

  /**
   * 设置当日故障总数
   *
   * @param dayTotal 当日故障总数
   */
  public void setDayTotal(Integer dayTotal) {
    this.dayTotal = dayTotal;
  }

  /**
   * 获取 当月SR总数
   *
   * @return month_sr - 当月SR总数
   */
  public Integer getMonthSr() {
    return monthSr;
  }

  /**
   * 设置 当月SR总数
   *
   * @param monthSr 当月SR总数
   */
  public void setMonthSr(Integer monthSr) {
    this.monthSr = monthSr;
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
