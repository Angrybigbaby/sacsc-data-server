package com.xuelangyun.shangfei.sacsc.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "flywin_sales_purchase_order_info")
public class FlywinSalesPurchaseOrderInfo {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 订单号 */
  @Column(name = "order_no")
  private String orderNo;

  /** 供方名称 */
  @Column(name = "supplier_name")
  private String supplierName;

  /** 订单发放时间 */
  @Column(name = "order_date")
  @JsonFormat(pattern = "MM-dd")
  private Date orderDate;

  /** 订单分类 */
  @Column(name = "order_type")
  private String orderType;

  /** 订单状态 */
  @Column(name = "order_status")
  private String orderStatus;

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
   * 获取订单号
   *
   * @return order_no - 订单号
   */
  public String getOrderNo() {
    return orderNo;
  }

  /**
   * 设置订单号
   *
   * @param orderNo 订单号
   */
  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }

  /**
   * 获取供方名称
   *
   * @return supplier_name - 供方名称
   */
  public String getSupplierName() {
    return supplierName;
  }

  /**
   * 设置供方名称
   *
   * @param supplierName 供方名称
   */
  public void setSupplierName(String supplierName) {
    this.supplierName = supplierName;
  }

  /**
   * 获取订单发放时间
   *
   * @return order_date - 订单发放时间
   */
  public Date getOrderDate() {
    return orderDate;
  }

  /**
   * 设置订单发放时间
   *
   * @param orderDate 订单发放时间
   */
  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  /**
   * 获取订单分类
   *
   * @return order_type - 订单分类
   */
  public String getOrderType() {
    return orderType;
  }

  /**
   * 设置订单分类
   *
   * @param orderType 订单分类
   */
  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  /**
   * 获取订单状态
   *
   * @return order_status - 订单状态
   */
  public String getOrderStatus() {
    return orderStatus;
  }

  /**
   * 设置订单状态
   *
   * @param orderStatus 订单状态
   */
  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
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
