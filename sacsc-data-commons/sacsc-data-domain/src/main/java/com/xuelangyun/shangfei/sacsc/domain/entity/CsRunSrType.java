package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cs_run_sr_type")
public class CsRunSrType {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** SR数量 */
  @Column(name = "sr_count")
  private Integer srCount;

  /** 类型/航司名称 */
  private String name;

  /** 1=类型,2=航司 */
  private Short type;

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
   * 获取SR数量
   *
   * @return sr_count - SR数量
   */
  public Integer getSrCount() {
    return srCount;
  }

  /**
   * 设置SR数量
   *
   * @param srCount SR数量
   */
  public void setSrCount(Integer srCount) {
    this.srCount = srCount;
  }

  /**
   * 获取类型/航司名称
   *
   * @return name - 类型/航司名称
   */
  public String getName() {
    return name;
  }

  /**
   * 设置类型/航司名称
   *
   * @param name 类型/航司名称
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 获取1=类型,2=航司
   *
   * @return type - 1=类型,2=航司
   */
  public Short getType() {
    return type;
  }

  /**
   * 设置1=类型,2=航司
   *
   * @param type 1=类型,2=航司
   */
  public void setType(Short type) {
    this.type = type;
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
