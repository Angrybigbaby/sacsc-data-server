package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "cs_run_sr_overdue")
public class CsRunSrOverdue {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 编码 */
  @Column(name = "sr_code")
  private String srCode;

  /** 标题 */
  @Column(name = "sr_title")
  private String srTitle;

  /** 创建时间 */
  @Column(name = "cr_time")
  private Date crTime;

  /** 客户 */
  @Column(name = "cus_name")
  private String cusName;

  /** 优先级 */
  @Column(name = "sr_priority")
  private String srPriority;

  /** 飞机注册号 */
  @Column(name = "tail_number")
  private String tailNumber;

  /** 要求答复时间 */
  @Column(name = "reply_time")
  private Date replyTime;

  /** 状态 */
  @Column(name = "sr_status")
  private String srStatus;

  /** 责任人 */
  @Column(name = "sr_handler")
  private String srHandler;

  /** 1=超期,2=即将超期 */
  @Column(name = "overdue_type")
  private Short overdueType;

  @Column(name = "create_time")
  private Date createTime;
}
