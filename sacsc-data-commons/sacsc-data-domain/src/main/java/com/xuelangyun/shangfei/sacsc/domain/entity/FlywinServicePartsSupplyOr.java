package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "flywin_service_parts_supply_or")
public class FlywinServicePartsSupplyOr {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 运行支持模式,1=运行支持,2=订单交易 */
  @Column(name = "model_type")
  private Short modelType;

  /** 订单数 */
  @Column(name = "day_total")
  private Integer dayTotal;

  /** 总金额(万元) */
  @Column(name = "month_sr")
  private Double monthSr;

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
   * 获取运行支持模式,1=运行支持,2=订单交易
   *
   * @return model_type - 运行支持模式,1=运行支持,2=订单交易
   */
  public Short getModelType() {
    return modelType;
  }

  /**
   * 设置运行支持模式,1=运行支持,2=订单交易
   *
   * @param modelType 运行支持模式,1=运行支持,2=订单交易
   */
  public void setModelType(Short modelType) {
    this.modelType = modelType;
  }

  /**
   * 获取订单数
   *
   * @return day_total - 订单数
   */
  public Integer getDayTotal() {
    return dayTotal;
  }

  /**
   * 设置订单数
   *
   * @param dayTotal 订单数
   */
  public void setDayTotal(Integer dayTotal) {
    this.dayTotal = dayTotal;
  }

  /**
   * 获取总金额(万元)
   *
   * @return month_sr - 总金额(万元)
   */
  public Double getMonthSr() {
    return monthSr;
  }

  /**
   * 设置总金额(万元)
   *
   * @param monthSr 总金额(万元)
   */
  public void setMonthSr(Double monthSr) {
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
