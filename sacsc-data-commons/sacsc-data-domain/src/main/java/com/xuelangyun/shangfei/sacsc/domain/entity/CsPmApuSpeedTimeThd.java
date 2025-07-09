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
 *     <p>预测维修-APU启动后达到指定转速的时间阈值
 */
@Table(name = "cs_pm_apu_speed_time_thd")
@Data
public class CsPmApuSpeedTimeThd {
  /** id */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 时间上限值秒 */
  @Column(name = "apu_time_up")
  private Double apuTimeUp;

  /** 时间下限值秒 */
  @Column(name = "apu_time_down")
  private Double apuTimeDown;

  /** 1=达到99.5%转速 */
  @Column(name = "apu_speed_type")
  private Short apuSpeedType;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
