package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "flight_data_analyse")
public class FlightDataAnalyse {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "flight_id")
  private String flightId;

  /** 航班号 */
  @Column(name = "flight_number")
  private String flightNumber;

  /** MEL */
  private String mel;

  /** CDL */
  private String cdl;

  /** 特殊运行 */
  @Column(name = "special_flight")
  private String specialFlight;

  /** 签派通告 */
  @Column(name = "dispatch_notice")
  private String dispatchNotice;

  /** 故障保留项 */
  @Column(name = "fault_reservation")
  private String faultReservation;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
