package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "cs_run_flying_line_positions")
public class CsRunFlyingLinePositions {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 航段id */
  private Long flightid;

  /** 时间 */
  private Date time;

  /** 高度 */
  private String alt;

  /** 经度 */
  private String lng;

  /** 纬度 */
  private String lat;

  /** 油量 */
  private Double oil;

  @Column(name = "create_time")
  private Date createTime;
}
