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
@Data
@Table(name = "cs_pm_starter")
public class CsPmStarter {
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

  /** 起动机活门打开时间 */
  @Column(name = "valve_ot_l")
  private Double valveOtL;

  /** 起动机活门打开时间拟合值 */
  @Column(name = "valve_ot_l_trend")
  private Double valveOtLTrend;

  /** 起动机活门关闭时间 */
  @Column(name = "valve_cl_l")
  private Double valveClL;

  /** 起动机活门关闭时间拟合值 */
  @Column(name = "valve_cl_l_trend")
  private Double valveClLTrend;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
