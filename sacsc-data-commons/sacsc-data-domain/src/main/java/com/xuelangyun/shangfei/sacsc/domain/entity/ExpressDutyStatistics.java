package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "express_duty_statistics")
public class ExpressDutyStatistics {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 机型 */
  private String model;

  /** 总飞行时间 千小时 */
  @Column(name = "total_flight_time")
  private Double totalFlightTime;

  /** 总轮档时间 千小时 */
  @Column(name = "total_rotation_time")
  private Double totalRotationTime;

  /** 总起落架次(千次) */
  @Column(name = "total_landing")
  private Double totalLanding;

  /** 机组值勤(千人次) */
  @Column(name = "crew_duty_person_time")
  private Double crewDutyPersonTime;

  /** 机组值勤(千小时) */
  @Column(name = "crew_duty_time")
  private Double crewDutyTime;

  /** 航务值勤(千人次) */
  @Column(name = "operation_duty_person_time")
  private Double operationDutyPersonTime;

  /** 航务值勤(千小时) */
  @Column(name = "operation_duty_time")
  private Double operationDutyTime;

  /** 机务值勤(千人次) */
  @Column(name = "mechanical_duty_person_time")
  private Double mechanicalDutyPersonTime;

  /** 机务值勤(千小时) */
  @Column(name = "mechanical_duty_time")
  private Double mechanicalDutyTime;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;

  public ExpressDutyStatistics() {};

  public ExpressDutyStatistics(
      Double totalFlightTime,
      Double totalRotationTime,
      Double totalLanding,
      Double crewDutyPersonTime,
      Double crewDutyTime,
      Double operationDutyPersonTime,
      Double operationDutyTime,
      Double mechanicalDutyPersonTime,
      Double mechanicalDutyTime) {
    this.totalFlightTime = totalFlightTime;
    this.totalRotationTime = totalRotationTime;
    this.totalLanding = totalLanding;
    this.crewDutyPersonTime = crewDutyPersonTime;
    this.crewDutyTime = crewDutyTime;
    this.operationDutyPersonTime = operationDutyPersonTime;
    this.operationDutyTime = operationDutyTime;
    this.mechanicalDutyPersonTime = mechanicalDutyPersonTime;
    this.mechanicalDutyTime = mechanicalDutyTime;
  }
}
