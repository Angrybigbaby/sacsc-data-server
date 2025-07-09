package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "flywin_service_mro_repa_o")
public class FlywinServiceMroRepaO {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 在修部附件数量 */
  @Column(name = "parts_amount")
  private Integer partsAmount;

  /** 在修飞机数量 */
  @Column(name = "plane_amount")
  private Integer planeAmount;

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
   * 获取在修部附件数量
   *
   * @return parts_amount - 在修部附件数量
   */
  public Integer getPartsAmount() {
    return partsAmount;
  }

  /**
   * 设置在修部附件数量
   *
   * @param partsAmount 在修部附件数量
   */
  public void setPartsAmount(Integer partsAmount) {
    this.partsAmount = partsAmount;
  }

  /**
   * 获取在修飞机数量
   *
   * @return plane_amount - 在修飞机数量
   */
  public Integer getPlaneAmount() {
    return planeAmount;
  }

  /**
   * 设置在修飞机数量
   *
   * @param planeAmount 在修飞机数量
   */
  public void setPlaneAmount(Integer planeAmount) {
    this.planeAmount = planeAmount;
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
