package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "express_flight_plan_basic_info")
public class ExpressFlightPlanBasicInfo {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "flight_id")
  private String flightId;

  /** 航班号 */
  @Column(name = "flight_number")
  private String flightNumber;

  /** 起飞机场跑道号 */
  @Column(name = "takeoff_runway_number")
  private String takeoffRunwayNumber;

  /** 起飞机场停机位 */
  @Column(name = "takeoff_apron_number")
  private String takeoffApronNumber;

  /** 着陆机场跑道号 */
  @Column(name = "arrive_runway_number")
  private String arriveRunwayNumber;

  /** 着陆机场停机位 */
  @Column(name = "arrive_apron_number")
  private String arriveApronNumber;

  /** 机长 */
  @Column(name = "plane_captain")
  private String planeCaptain;

  /** 飞行机组(人数) */
  @Column(name = "flight_crew_amount")
  private Long flightCrewAmount;

  /** 乘务机组(人数) */
  @Column(name = "crew_amount")
  private Long crewAmount;

  /** 乘员(人数) */
  @Column(name = "passenger_amount")
  private Long passengerAmount;

  /** 起飞重量(kg) */
  @Column(name = "takeoff_weight")
  private Double takeoffWeight;

  /** 起飞油量(kg) */
  @Column(name = "takeoff_fuel_quantity")
  private Double takeoffFuelQuantity;

  /** 业载重量(kg) */
  @Column(name = "carry_weight")
  private Double carryWeight;

  /** 重心(%Mac) */
  @Column(name = "gravity_centre")
  private Double gravityCentre;

  /** VIP(人数) */
  @Column(name = "passenger_vip_amount")
  private Long passengerVipAmount;

  /** 机组人员图片地址 */
  @Column(name = "img_url")
  private String imgUrl;

  @Column(name = "create_time")
  private Date createTime;
}
