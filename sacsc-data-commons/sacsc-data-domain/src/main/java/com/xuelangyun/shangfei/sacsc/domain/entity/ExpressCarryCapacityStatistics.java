package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "express_carry_capacity_statistics")
public class ExpressCarryCapacityStatistics {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 机型 */
  private String model;

  /** 通勤人次 */
  @Column(name = "commuter_person_time")
  private Long commuterPersonTime;

  /** 功能人次 */
  @Column(name = "function_person_time")
  private Long functionPersonTime;

  /** 飞机机组人次 */
  @Column(name = "flight_crew_person_time")
  private Long flightCrewPersonTime;

  /** 乘务机组人次 */
  @Column(name = "crew_person_time")
  private Long crewPersonTime;

  /** 其他人次 */
  @Column(name = "other_person_time")
  private Long otherPersonTime;

  /** 货物吨数 */
  @Column(name = "cargo_weight")
  private Double cargoWeight;

  /** 行李吨数 */
  @Column(name = "luggage_weight")
  private Double luggageWeight;

  /** 航材件数 */
  @Column(name = "aeromat_weight")
  private Long aeromatWeight;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
