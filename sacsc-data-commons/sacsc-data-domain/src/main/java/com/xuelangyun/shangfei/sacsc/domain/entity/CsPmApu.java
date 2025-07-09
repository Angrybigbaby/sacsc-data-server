package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2020/8/23
 *     <p>预测维修-APU排气温度
 */
@Table(name = "cs_pm_apu")
@Data
public class CsPmApu {
  /** id */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 飞机ID */
  @Column(name = "flightid")
  private String flightid;

  /** 机尾号 */
  @Column(name = "tailnumber")
  private String tailnumber;

  /** 飞机起降时间中点 */
  @Column(name = "flighttime")
  private Date flighttime;

  /** APU启动后达到99.5%转速的时间 */
  @Column(name = "apu_start_time")
  private Double apuStartTime;

  /** APU启动后达到99.5%转速的时间拟合值 */
  @Column(name = "apu_start_time_trend")
  private Double apuStartTimeTrend;

  /** 飞机起飞前APU运行的最大排气温度 */
  @Column(name = "apu_egt_max_takeoff")
  private Double apuEgtMaxTakeoff;

  /** 飞机起飞前APU运行的最大排气温度拟合值 */
  @Column(name = "apu_egt_max_takeoff_trend")
  private Double apuEgtMaxTakeoffTrend;

  /** 飞机落地后APU达到99.5%转速的最大排气温度 */
  @Column(name = "apu_egt_max_landing_start")
  private Double apuEgtMaxLandingStart;

  /** 飞机落地后APU达到99.5%转速的最大排气温度拟合值 */
  @Column(name = "apu_egt_max_landing_start_trend")
  private Double apuEgtMaxLandingStartTrend;

  /** 飞机落地后APU达到99.5%转速，关闭引气阀后的最大排气温度 */
  @Column(name = "apu_egt_max_landing_auto")
  private Double apuEgtMaxLandingAuto;

  /** 飞机落地后APU达到99.5%转速，关闭引气阀后的最大排气温度拟合值 */
  @Column(name = "apu_egt_max_landing_auto_trend")
  private Double apuEgtMaxLandingAutoTrend;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
