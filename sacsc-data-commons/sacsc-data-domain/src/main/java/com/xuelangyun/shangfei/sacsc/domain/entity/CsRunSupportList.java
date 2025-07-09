package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cs_run_support_list")
public class CsRunSupportList {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 编码 */
  @Column(name = "sl_code")
  private String slCode;

  /** 标题 */
  @Column(name = "sl_itle")
  private String slItle;

  /** 创建时间 */
  @Column(name = "cr_time")
  private Date crTime;

  /** 要求答复时间 */
  @Column(name = "reply_time")
  private Date replyTime;

  /** 状态 */
  @Column(name = "sl_status")
  private String slStatus;

  /** 接收岗位 */
  @Column(name = "receive_station")
  private String receiveStation;

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
   * 获取编码
   *
   * @return sl_code - 编码
   */
  public String getSlCode() {
    return slCode;
  }

  /**
   * 设置编码
   *
   * @param slCode 编码
   */
  public void setSlCode(String slCode) {
    this.slCode = slCode;
  }

  /**
   * 获取标题
   *
   * @return sl_itle - 标题
   */
  public String getSlItle() {
    return slItle;
  }

  /**
   * 设置标题
   *
   * @param slItle 标题
   */
  public void setSlItle(String slItle) {
    this.slItle = slItle;
  }

  /**
   * 获取创建时间
   *
   * @return cr_time - 创建时间
   */
  public Date getCrTime() {
    return crTime;
  }

  /**
   * 设置创建时间
   *
   * @param crTime 创建时间
   */
  public void setCrTime(Date crTime) {
    this.crTime = crTime;
  }

  /**
   * 获取要求答复时间
   *
   * @return reply_time - 要求答复时间
   */
  public Date getReplyTime() {
    return replyTime;
  }

  /**
   * 设置要求答复时间
   *
   * @param replyTime 要求答复时间
   */
  public void setReplyTime(Date replyTime) {
    this.replyTime = replyTime;
  }

  /**
   * 获取状态
   *
   * @return sl_status - 状态
   */
  public String getSlStatus() {
    return slStatus;
  }

  /**
   * 设置状态
   *
   * @param slStatus 状态
   */
  public void setSlStatus(String slStatus) {
    this.slStatus = slStatus;
  }

  /**
   * 获取接收岗位
   *
   * @return receive_station - 接收岗位
   */
  public String getReceiveStation() {
    return receiveStation;
  }

  /**
   * 设置接收岗位
   *
   * @param receiveStation 接收岗位
   */
  public void setReceiveStation(String receiveStation) {
    this.receiveStation = receiveStation;
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
