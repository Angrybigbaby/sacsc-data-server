package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cs_run_new_failure_fh")
public class CsRunNewFailureFh {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 飞机注册号/机号 */
  @Column(name = "airplane_no")
  private String airplaneNo;

  /** 500FH内故障数 */
  @Column(name = "fivehundred_fh")
  private Integer fivehundredFh;

  /** FH */
  private Integer fh;

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
   * 获取飞机注册号/机号
   *
   * @return airplane_no - 飞机注册号/机号
   */
  public String getAirplaneNo() {
    return airplaneNo;
  }

  /**
   * 设置飞机注册号/机号
   *
   * @param airplaneNo 飞机注册号/机号
   */
  public void setAirplaneNo(String airplaneNo) {
    this.airplaneNo = airplaneNo;
  }

  /**
   * 获取500FH内故障数
   *
   * @return fivehundred_fh - 500FH内故障数
   */
  public Integer getFivehundredFh() {
    return fivehundredFh;
  }

  /**
   * 设置500FH内故障数
   *
   * @param fivehundredFh 500FH内故障数
   */
  public void setFivehundredFh(Integer fivehundredFh) {
    this.fivehundredFh = fivehundredFh;
  }

  /**
   * 获取FH
   *
   * @return fh - FH
   */
  public Integer getFh() {
    return fh;
  }

  /**
   * 设置FH
   *
   * @param fh FH
   */
  public void setFh(Integer fh) {
    this.fh = fh;
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
