package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cs_run_mtbar")
public class CsRunMtbar {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** ATA6D */
  private String ata6d;

  /** 部件件号 */
  @Column(name = "part_no")
  private String partNo;

  /** 部件名称 */
  @Column(name = "part_name")
  private String partName;

  /** 当月非计划拆换次数 */
  @Column(name = "month_npsc")
  private Integer monthNpsc;

  /** 近12月非计划拆换次数 */
  @Column(name = "l12_month_npsc")
  private Integer l12MonthNpsc;

  /** 近12月MTBUR */
  @Column(name = "l12_month_mtbur")
  private Double l12MonthMtbur;

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
   * 获取ATA6D
   *
   * @return ata6d - ATA6D
   */
  public String getAta6d() {
    return ata6d;
  }

  /**
   * 设置ATA6D
   *
   * @param ata6d ATA6D
   */
  public void setAta6d(String ata6d) {
    this.ata6d = ata6d;
  }

  /**
   * 获取部件件号
   *
   * @return part_no - 部件件号
   */
  public String getPartNo() {
    return partNo;
  }

  /**
   * 设置部件件号
   *
   * @param partNo 部件件号
   */
  public void setPartNo(String partNo) {
    this.partNo = partNo;
  }

  /**
   * 获取部件名称
   *
   * @return part_name - 部件名称
   */
  public String getPartName() {
    return partName;
  }

  /**
   * 设置部件名称
   *
   * @param partName 部件名称
   */
  public void setPartName(String partName) {
    this.partName = partName;
  }

  /**
   * 获取当月非计划拆换次数
   *
   * @return month_npsc - 当月非计划拆换次数
   */
  public Integer getMonthNpsc() {
    return monthNpsc;
  }

  /**
   * 设置当月非计划拆换次数
   *
   * @param monthNpsc 当月非计划拆换次数
   */
  public void setMonthNpsc(Integer monthNpsc) {
    this.monthNpsc = monthNpsc;
  }

  /**
   * 获取近12月非计划拆换次数
   *
   * @return l12_month_npsc - 近12月非计划拆换次数
   */
  public Integer getL12MonthNpsc() {
    return l12MonthNpsc;
  }

  /**
   * 设置近12月非计划拆换次数
   *
   * @param l12MonthNpsc 近12月非计划拆换次数
   */
  public void setL12MonthNpsc(Integer l12MonthNpsc) {
    this.l12MonthNpsc = l12MonthNpsc;
  }

  /**
   * 获取近12月MTBUR
   *
   * @return l12_month_mtbur - 近12月MTBUR
   */
  public Double getL12MonthMtbur() {
    return l12MonthMtbur;
  }

  /**
   * 设置近12月MTBUR
   *
   * @param l12MonthMtbur 近12月MTBUR
   */
  public void setL12MonthMtbur(Double l12MonthMtbur) {
    this.l12MonthMtbur = l12MonthMtbur;
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
