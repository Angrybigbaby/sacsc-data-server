package com.xuelangyun.shangfei.sacsc.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "cs_run_flight_history_fault")
public class CsRunFlightHistoryFault {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 飞行阶段 */
  @Column(name = "flyPhase")
  private String flyphase;

  /** 故障信息 */
  private String description;

  /** 航段ID */
  private Long flightid;

  /** MSN */
  private String msn;

  /** 航段历史(null:灰色,notnull:蓝色) */
  private String history;

  /** 故障等级(1:高2:中3:低4:无) */
  private Integer priority;

  /** CAS告警信息类型(WARNING、CAUTION、STATUS、ADVISORY) */
  private String type;

  /** ATA */
  private String ata;

  /** 故障类型(CMS、CAS) */
  private String faulttype;

  /** 航段数 */
  private Double leg;

  /** 故障触发时间 */
  @JsonFormat(pattern = "MM-dd HH:mm")
  private Date time;

  /** 机尾号 */
  private String tailnumber;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "fault_id")
  private Long faultId;

  @Transient private List<Integer> his;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Transient
  private Date originTime;
}
