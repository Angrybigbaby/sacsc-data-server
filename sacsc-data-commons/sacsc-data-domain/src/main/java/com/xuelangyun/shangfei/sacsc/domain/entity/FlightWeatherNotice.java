package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "flight_weather_notice")
public class FlightWeatherNotice {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "flight_id")
  private String flightId;

  /** 航班号 */
  @Column(name = "flight_number")
  private String flightNumber;

  /** 机场 */
  @Column(name = "airport_code")
  private String airportCode;

  /** 收报时间 */
  @Column(name = "flight_time")
  private Date flightTime;

  /** 气象（轮切） */
  @Column(name = "weather_info")
  private String weatherInfo;

  /** 航行通告（轮切） */
  @Column(name = "flight_notice")
  private String flightNotice;

  @Column(name = "create_time")
  private Date createTime;
}
