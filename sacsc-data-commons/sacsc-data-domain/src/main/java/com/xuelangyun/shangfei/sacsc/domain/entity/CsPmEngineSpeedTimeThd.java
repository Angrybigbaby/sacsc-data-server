package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "cs_pm_engine_speed_time_thd")
public class CsPmEngineSpeedTimeThd {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 发动机号数:1=左22,2=右22,3=左53,4=右53 */
  @Column(name = "engine_no")
  private Integer engineNo;

  /** 发动机高压转子转速时间上限 */
  @Column(name = "engine_up")
  private Double engineUp;

  /** 发动机高压转子转速时间下限 */
  @Column(name = "engine_down")
  private Double engineDown;

  @Column(name = "create_time")
  private Date createTime;
}
