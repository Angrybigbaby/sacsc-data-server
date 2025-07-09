package com.xuelangyun.shangfei.sacsc.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "cs_pm_engine_shake")
@Data
public class CsPmEngineShake {
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
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date flighttime;

  /** 起飞阶段1号发动机低压转子振动最大值 */
  @Column(name = "p3e1n1_max")
  private Double p3e1n1Max;

  /** 起飞阶段1号发动机低压转子振动最大值的拟合值 */
  @Column(name = "p3e1n1_max_trend")
  private Double p3e1n1MaxTrend;

  /** 起飞阶段1号发动机高压转子振动最大值 */
  @Column(name = "p3e1n2_max")
  private Double p3e1n2Max;

  /** 起飞阶段1号发动机高压转子振动最大值的拟合值 */
  @Column(name = "p3e1n2_max_trend")
  private Double p3e1n2MaxTrend;

  /** 起飞阶段2号发动机低压转子振动最大值 */
  @Column(name = "p3e2n1_max")
  private Double p3e2n1Max;

  /** 起飞阶段2号发动机低压转子振动最大值的拟合值 */
  @Column(name = "p3e2n1_max_trend")
  private Double p3e2n1MaxTrend;

  /** 起飞阶段2号发动机高压转子振动最大值 */
  @Column(name = "p3e2n2_max")
  private Double p3e2n2Max;

  /** 起飞阶段2号发动机高压转子振动最大值的拟合值 */
  @Column(name = "p3e2n2_max_trend")
  private Double p3e2n2MaxTrend;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
