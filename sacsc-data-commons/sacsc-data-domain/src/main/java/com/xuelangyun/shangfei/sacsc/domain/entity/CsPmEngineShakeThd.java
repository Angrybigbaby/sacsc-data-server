package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "cs_pm_engine_shake_thd")
public class CsPmEngineShakeThd {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 左低（1）/右低（2） 左高（3）/右高（4） */
  @Column(name = "engine_no")
  private Integer engineNo;

  /** 发动机转子振动值上限 */
  @Column(name = "shake_max_up")
  private Double shakeMaxUp;

  /** 发动机转子振动值下限 */
  @Column(name = "shake_max_down")
  private Double shakeMaxDown;

  @Column(name = "create_time")
  private Date createTime;
}
