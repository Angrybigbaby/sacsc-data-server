package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "cs_run_variflight_flight_status")
public class CsRunVariflightFlightStatus {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  /** 状态描述 */
  @Column(name = "flight_desc")
  private String flightDesc;

  /** 飞机状态 */
  @Column(name = "code")
  private Integer code;

  /** 0-可用 1-不可用 */
  @Column(name = "status")
  private Short status;

  /** 状态颜色 */
  @Column(name = "status_color")
  private String statusColor;

  @Column(name = "create_time")
  private Date createTime;
}
