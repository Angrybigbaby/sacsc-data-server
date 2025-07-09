package com.xuelangyun.shangfei.sacsc.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "flight_status_oil_height")
public class FlightStatusOilHeight {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "flight_id")
  private String flightId;

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

  @Column(name = "create_time")
  private Date createTime;
}
