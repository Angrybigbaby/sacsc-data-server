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
 *     <p>预测维修-APU运行的最大排气温度的阈值
 */
@Table(name = "cs_pm_apu_tmp_thd")
@Data
public class CsPmApuTmpThd {
  /** id */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** APU运行温度的上限值℃ */
  @Column(name = "apu_tmp_up")
  private Double apuTmpUp;

  /** APU运行温度的下限值℃ */
  @Column(name = "apu_tmp_down")
  private Double apuTmpDown;

  /** APU运行时间点阶段(1=起飞前,2=落地后APU达到99.5%转速,3=落地后APU达到99.5%转速且关闭引气阀后) */
  @Column(name = "apu_time_type")
  private Integer apuTimeType;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
