package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "flywin_sales_parts_sales")
public class FlywinSalesPartsSales {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 日期:年-月 */
  @Column(name = "stat_date")
  private String statDate;

  /** 订单量(笔) */
  @Column(name = "order_quantity")
  private Integer orderQuantity;

  /** 金额(万元) */
  @Column(name = "order_amount")
  private Double orderAmount;

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
   * 获取订单量(笔)
   *
   * @return order_quantity - 订单量(笔)
   */
  public Integer getOrderQuantity() {
    return orderQuantity;
  }

  /**
   * 设置订单量(笔)
   *
   * @param orderQuantity 订单量(笔)
   */
  public void setOrderQuantity(Integer orderQuantity) {
    this.orderQuantity = orderQuantity;
  }

  /**
   * 获取金额(万元)
   *
   * @return order_amount - 金额(万元)
   */
  public Double getOrderAmount() {
    return orderAmount;
  }

  /**
   * 设置金额(万元)
   *
   * @param orderAmount 金额(万元)
   */
  public void setOrderAmount(Double orderAmount) {
    this.orderAmount = orderAmount;
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
