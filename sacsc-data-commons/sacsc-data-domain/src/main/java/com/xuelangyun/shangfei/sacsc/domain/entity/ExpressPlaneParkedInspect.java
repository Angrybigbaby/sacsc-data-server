package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "express_plane_parked_inspect")
public class ExpressPlaneParkedInspect {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 起止日期 */
  @Column(name = "start_end_date")
  private String startEndDate;

  /** 飞机注册号 */
  @Column(name = "tail_number")
  private String tailNumber;

  /** 飞机机型 */
  private String model;

  /** 停场定检地点 */
  private String location;

  /** 原因 */
  @Column(name = "parked_cause")
  private String parkedCause;

  /** 详细信息 */
  @Column(name = "parked_info")
  private String parkedInfo;

  @Column(name = "create_time")
  private Date createTime;

  @Transient private String info;

  @Column(name = "start_time")
  private String startTime;

  @Column(name = "end_time")
  private String endTime;
}
