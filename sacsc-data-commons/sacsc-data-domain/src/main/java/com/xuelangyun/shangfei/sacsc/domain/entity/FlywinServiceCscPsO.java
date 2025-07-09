package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "flywin_service_csc_ps_o")
public class FlywinServiceCscPsO {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 订单总数 */
  @Column(name = "total_amount")
  private Integer totalAmount;

  /** 已完成订单数 */
  @Column(name = "complete_amount")
  private Integer completeAmount;

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
   * 获取订单总数
   *
   * @return total_amount - 订单总数
   */
  public Integer getTotalAmount() {
    return totalAmount;
  }

  /**
   * 设置订单总数
   *
   * @param totalAmount 订单总数
   */
  public void setTotalAmount(Integer totalAmount) {
    this.totalAmount = totalAmount;
  }

  /**
   * 获取已完成订单数
   *
   * @return complete_amount - 已完成订单数
   */
  public Integer getCompleteAmount() {
    return completeAmount;
  }

  /**
   * 设置已完成订单数
   *
   * @param completeAmount 已完成订单数
   */
  public void setCompleteAmount(Integer completeAmount) {
    this.completeAmount = completeAmount;
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
