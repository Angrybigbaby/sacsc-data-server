package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "flywin_service_caac_lab_o")
public class FlywinServiceCaacLabO {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 航材挂签申请总数 */
  @Column(name = "total_amount")
  private Integer totalAmount;

  /** 航材挂签已审批数 */
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
   * 获取航材挂签申请总数
   *
   * @return total_amount - 航材挂签申请总数
   */
  public Integer getTotalAmount() {
    return totalAmount;
  }

  /**
   * 设置航材挂签申请总数
   *
   * @param totalAmount 航材挂签申请总数
   */
  public void setTotalAmount(Integer totalAmount) {
    this.totalAmount = totalAmount;
  }

  /**
   * 获取航材挂签已审批数
   *
   * @return complete_amount - 航材挂签已审批数
   */
  public Integer getCompleteAmount() {
    return completeAmount;
  }

  /**
   * 设置航材挂签已审批数
   *
   * @param completeAmount 航材挂签已审批数
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
