package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cs_run_troubles_shooting")
public class CsRunTroublesShooting {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 飞机注册号 */
  @Column(name = "tail_number")
  private String tailNumber;

  /** 飞机MSN */
  private String msn;

  /** 故障名称 */
  @Column(name = "fly_status")
  private String flyStatus;

  /** CAS */
  private String cas;

  /** CAS的警告等级 */
  private String type;

  /** CMS */
  private String cms;

  /** CMS警告等级 */
  private Integer priority;

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
   * 获取飞机注册号
   *
   * @return tail_number - 飞机注册号
   */
  public String getTailNumber() {
    return tailNumber;
  }

  /**
   * 设置飞机注册号
   *
   * @param tailNumber 飞机注册号
   */
  public void setTailNumber(String tailNumber) {
    this.tailNumber = tailNumber;
  }

  /**
   * 获取飞机MSN
   *
   * @return msn - 飞机MSN
   */
  public String getMsn() {
    return msn;
  }

  /**
   * 设置飞机MSN
   *
   * @param msn 飞机MSN
   */
  public void setMsn(String msn) {
    this.msn = msn;
  }

  /**
   * 获取故障名称
   *
   * @return fly_status - 故障名称
   */
  public String getFlyStatus() {
    return flyStatus;
  }

  /**
   * 设置故障名称
   *
   * @param flyStatus 故障名称
   */
  public void setFlyStatus(String flyStatus) {
    this.flyStatus = flyStatus;
  }

  /**
   * 获取CAS
   *
   * @return cas - CAS
   */
  public String getCas() {
    return cas;
  }

  /**
   * 设置CAS
   *
   * @param cas CAS
   */
  public void setCas(String cas) {
    this.cas = cas;
  }

  /**
   * 获取CAS的警告等级
   *
   * @return type - CAS的警告等级
   */
  public String getType() {
    return type;
  }

  /**
   * 设置CAS的警告等级
   *
   * @param type CAS的警告等级
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * 获取CMS
   *
   * @return cms - CMS
   */
  public String getCms() {
    return cms;
  }

  /**
   * 设置CMS
   *
   * @param cms CMS
   */
  public void setCms(String cms) {
    this.cms = cms;
  }

  /**
   * 获取CMS警告等级
   *
   * @return priority - CMS警告等级
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * 设置CMS警告等级
   *
   * @param priority CMS警告等级
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
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
