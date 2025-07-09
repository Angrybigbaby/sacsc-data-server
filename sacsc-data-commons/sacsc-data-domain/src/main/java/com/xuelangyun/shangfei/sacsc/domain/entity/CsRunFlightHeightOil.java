package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "cs_run_flight_height_oil")
public class CsRunFlightHeightOil {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "flight_id")
  private Long flightId;

  /** 时间 */
  private Date time;

  /** 高度 */
  private Double alt;

  /** 经度 */
  private String lng;

  /** 纬度 */
  private String lat;

  /** 油量 */
  private Double oil;

  @Column(name = "create_time")
  private Date createTime;
}
