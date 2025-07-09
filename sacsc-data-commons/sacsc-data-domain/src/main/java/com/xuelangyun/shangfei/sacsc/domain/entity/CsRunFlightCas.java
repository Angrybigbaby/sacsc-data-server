package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "cs_run_flight_cas")
public class CsRunFlightCas {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "flight_id")
  private Long flightId;

  /** 故障信息 */
  private String description;

  /** 故障ID */
  @Column(name = "fault_id")
  private Long faultId;

  /** 故障触发时间 */
  private Date time;

  /** 故障等级(1:高2:中3:低4:无) */
  private Integer priority;

  /** 空 */
  private String type;

  /** ATA */
  private String ata;

  @Column(name = "create_time")
  private Date createTime;

  @Transient private Short faultStatus = 0;

  @Transient private String flightnum;

  @Transient private String tailnumber;

  @Transient private String lfourcode;

  @Transient private String tfourcode;
}
