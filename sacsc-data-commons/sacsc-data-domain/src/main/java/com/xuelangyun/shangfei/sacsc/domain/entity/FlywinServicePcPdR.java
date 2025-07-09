package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "flywin_service_pc_pd_r")
public class FlywinServicePcPdR {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 年度生产计划 */
  @Column(name = "product_plan")
  private Integer productPlan;

  /** 在制架次 */
  @Column(name = "product_ing")
  private Integer productIng;

  /** 年度交付计划 */
  @Column(name = "delivery_plan")
  private Integer deliveryPlan;

  /** 年度已交付 */
  @Column(name = "delivery_complete")
  private Integer deliveryComplete;

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
   * 获取年度生产计划
   *
   * @return product_plan - 年度生产计划
   */
  public Integer getProductPlan() {
    return productPlan;
  }

  /**
   * 设置年度生产计划
   *
   * @param productPlan 年度生产计划
   */
  public void setProductPlan(Integer productPlan) {
    this.productPlan = productPlan;
  }

  /**
   * 获取在制架次
   *
   * @return product_ing - 在制架次
   */
  public Integer getProductIng() {
    return productIng;
  }

  /**
   * 设置在制架次
   *
   * @param productIng 在制架次
   */
  public void setProductIng(Integer productIng) {
    this.productIng = productIng;
  }

  /**
   * 获取年度交付计划
   *
   * @return delivery_plan - 年度交付计划
   */
  public Integer getDeliveryPlan() {
    return deliveryPlan;
  }

  /**
   * 设置年度交付计划
   *
   * @param deliveryPlan 年度交付计划
   */
  public void setDeliveryPlan(Integer deliveryPlan) {
    this.deliveryPlan = deliveryPlan;
  }

  /**
   * 获取年度已交付
   *
   * @return delivery_complete - 年度已交付
   */
  public Integer getDeliveryComplete() {
    return deliveryComplete;
  }

  /**
   * 设置年度已交付
   *
   * @param deliveryComplete 年度已交付
   */
  public void setDeliveryComplete(Integer deliveryComplete) {
    this.deliveryComplete = deliveryComplete;
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
