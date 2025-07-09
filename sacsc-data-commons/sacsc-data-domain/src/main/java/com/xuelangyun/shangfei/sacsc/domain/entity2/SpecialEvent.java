package com.xuelangyun.shangfei.sacsc.domain.entity2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2021-11-08 15:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "special_event")
public class SpecialEvent {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "comp_regis_no")
  private String compRegisNo;

  @Column(name = "flt_no")
  private String fltNo;

  @Column(name = "depart")
  private String depart;

  @Column(name = "arrival")
  private String arrival;

  @Column(name = "event")
  private String event;

  @Column(name = "event_id")
  private String eventId;

  @Column(name = "event_no")
  private String eventNo;

  @Column(name = "flight_phase")
  private String flightPhase;

  @Column(name = "continue_time")
  private String continueTime;

  @Column(name = "occure")
  private String occure;

  @Column(name = "msg")
  private String msg;

  @Column(name = "create_time")
  private Date createTime;
}
