package com.xuelangyun.shangfei.sacsc.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "flight_status_summary")
public class FlightStatusSummary {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "flight_id")
  private String flightId;

  /** 航班号 */
  @Column(name = "flight_number")
  private String flightNumber;

  /** 航班状态(5种) */
  @Column(name = "flight_status")
  private String flightStatus;

  /** 时间点 */
  @Column(name = "flight_time")
  @JsonFormat(pattern = "HH:mm")
  private Date flightTime;

  /** 飞行高度(FT) */
  @Column(name = "flight_height")
  private Double flightHeight;

  /** 燃油量kg */
  @Column(name = "fuel_quantity")
  private Double fuelQuantity;

  /** 经度 */
  private String longitude;

  /** 纬度 */
  private String latitude;

  /** 飞行速度(kt) */
  @Column(name = "flight_speed")
  private Double flightSpeed;

  /** 燃油流量(kg/h) */
  @Column(name = "fuel_flow")
  private Double fuelFlow;

  /** 告警信息:高度偏差 */
  @Column(name = "hight_deviation")
  private String hightDeviation;

  /** 告警信息:航迹偏差 */
  @Column(name = "track_deviation")
  private String trackDeviation;

  /** 告警信息:油量偏差 */
  @Column(name = "oil_deviation")
  private String oilDeviation;

  /** 告警信息:飞行计划偏差 */
  @Column(name = "flight_deviation")
  private String flightDeviation;

  /** 实景监控图片/视频路径 */
  @Column(name = "supervisory_url")
  private String supervisoryUrl;

  // 当前飞行的百分比
  @Transient private Double flightPer;

  // 起飞机场
  @Transient private String takeoffAirport;

  // 着落机场
  @Transient private String arriveAirport;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
