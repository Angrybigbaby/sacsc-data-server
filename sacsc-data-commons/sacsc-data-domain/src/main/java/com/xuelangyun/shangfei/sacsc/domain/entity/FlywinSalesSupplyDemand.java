package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "flywin_sales_supply_demand")
public class FlywinSalesSupplyDemand {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 日期 */
  @Column(name = "stat_date")
  private String statDate;

  /** 询价件数 */
  @Column(name = "inquery_number")
  private Integer inqueryNumber;

  /** 下单件数 */
  @Column(name = "order_number")
  private Integer orderNumber;

  /** 库存件数 */
  @Column(name = "stock_number")
  private Integer stockNumber;

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
   * 获取询价件数
   *
   * @return inquery_number - 询价件数
   */
  public Integer getInqueryNumber() {
    return inqueryNumber;
  }

  /**
   * 设置询价件数
   *
   * @param inqueryNumber 询价件数
   */
  public void setInqueryNumber(Integer inqueryNumber) {
    this.inqueryNumber = inqueryNumber;
  }

  /**
   * 获取下单件数
   *
   * @return order_number - 下单件数
   */
  public Integer getOrderNumber() {
    return orderNumber;
  }

  /**
   * 设置下单件数
   *
   * @param orderNumber 下单件数
   */
  public void setOrderNumber(Integer orderNumber) {
    this.orderNumber = orderNumber;
  }

  /**
   * 获取库存件数
   *
   * @return stock_number - 库存件数
   */
  public Integer getStockNumber() {
    return stockNumber;
  }

  /**
   * 设置库存件数
   *
   * @param stockNumber 库存件数
   */
  public void setStockNumber(Integer stockNumber) {
    this.stockNumber = stockNumber;
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
