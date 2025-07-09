package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "flywin_sales_purchase_order")
public class FlywinSalesPurchaseOrder {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 订单类别 */
  @Column(name = "order_type")
  private String orderType;

  /** 采购订单量 */
  @Column(name = "order_quantity")
  private Integer orderQuantity;

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
   * 获取订单类别
   *
   * @return order_type - 订单类别
   */
  public String getOrderType() {
    return orderType;
  }

  /**
   * 设置订单类别
   *
   * @param orderType 订单类别
   */
  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  /**
   * 获取采购订单量
   *
   * @return order_quantity - 采购订单量
   */
  public Integer getOrderQuantity() {
    return orderQuantity;
  }

  /**
   * 设置采购订单量
   *
   * @param orderQuantity 采购订单量
   */
  public void setOrderQuantity(Integer orderQuantity) {
    this.orderQuantity = orderQuantity;
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
