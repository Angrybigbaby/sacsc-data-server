package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2020/8/25
 */
@Table(name = "cs_pm_engine_start")
@Data
public class CsPmEngineStart {
  /** id */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 飞机尾号 */
  @Column(name = "tailnumber")
  private String tailnumber;

  /** 飞机ID */
  @Column(name = "flightid")
  private String flightid;

  /** 飞机起降时间中点 */
  @Column(name = "flighttime")
  private Date flighttime;

  /** 一号发动机高压转子转速达到（0%-22%）时间 */
  @Column(name = "le_0_22")
  private Double le022;

  /** 一号发动机高压转子转速达到（0%-22%）时间拟合值 */
  @Column(name = "le_0_22_trend")
  private Double le022Trend;

  /** 一号发动机高压转子转速达到（22%-53%）时间 */
  @Column(name = "le_22_53")
  private Double le2253;

  /** 一号发动机高压转子转速达到（22%-53%）时间拟合值 */
  @Column(name = "le_22_53_trend")
  private Double le2253Trend;

  /** 二号发动机高压转子转速达到（0%-22%）时间 */
  @Column(name = "re_0_22")
  private Double re022;

  /** 二号发动机高压转子转速达到（0%-22%）时间拟合值 */
  @Column(name = "re_0_22_trend")
  private Double re022Trend;

  /** 二号发动机高压转子转速达到（22%-53%）时间 */
  @Column(name = "re_22_53")
  private Double re2253;

  /** 二号发动机高压转子转速达到（22%-53%）时间拟合值 */
  @Column(name = "re_22_53_trend")
  private Double re2253Trend;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
