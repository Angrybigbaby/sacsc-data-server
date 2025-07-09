package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "flywin_service_caac_att_r")
public class FlywinServiceCaacAttR {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 局方关注问题总数 */
  @Column(name = "total_amount")
  private Integer totalAmount;

  /** 已关闭问题数 */
  @Column(name = "solve_amount")
  private Integer solveAmount;

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
   * 获取局方关注问题总数
   *
   * @return total_amount - 局方关注问题总数
   */
  public Integer getTotalAmount() {
    return totalAmount;
  }

  /**
   * 设置局方关注问题总数
   *
   * @param totalAmount 局方关注问题总数
   */
  public void setTotalAmount(Integer totalAmount) {
    this.totalAmount = totalAmount;
  }

  /**
   * 获取已关闭问题数
   *
   * @return solve_amount - 已关闭问题数
   */
  public Integer getSolveAmount() {
    return solveAmount;
  }

  /**
   * 设置已关闭问题数
   *
   * @param solveAmount 已关闭问题数
   */
  public void setSolveAmount(Integer solveAmount) {
    this.solveAmount = solveAmount;
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
