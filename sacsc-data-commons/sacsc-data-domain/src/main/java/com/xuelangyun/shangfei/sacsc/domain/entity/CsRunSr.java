package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cs_run_sr")
public class CsRunSr {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 近24小时的SR总数 */
  @Column(name = "sr_count")
  private Integer srCount;

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
   * 获取近24小时的SR总数
   *
   * @return sr_count - 近24小时的SR总数
   */
  public Integer getSrCount() {
    return srCount;
  }

  /**
   * 设置近24小时的SR总数
   *
   * @param srCount 近24小时的SR总数
   */
  public void setSrCount(Integer srCount) {
    this.srCount = srCount;
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
