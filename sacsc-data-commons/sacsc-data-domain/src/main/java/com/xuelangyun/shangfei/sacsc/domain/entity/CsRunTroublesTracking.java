package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "cs_run_troubles_tracking")
public class CsRunTroublesTracking {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;
  /** 飞机型号 */
  @Column(name = "fly_model")
  private String flyModel;

  /** 故障名称 */
  @Column(name = "trouble_name")
  private String troubleName;

  /** 进度(百分比) */
  @Column(name = "progress_rate")
  private Double progressRate;

  @Column(name = "create_time")
  private Date createTime;
}
