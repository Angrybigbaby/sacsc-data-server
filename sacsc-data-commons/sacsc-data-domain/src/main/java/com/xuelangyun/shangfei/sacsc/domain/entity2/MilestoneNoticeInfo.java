package com.xuelangyun.shangfei.sacsc.domain.entity2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author zijian.qjd
 * @since 2021/11/30 17:45
 *     <p>发展里程碑事件通知信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ads_mbl_milestone_notice_info")
@IdClass(MilestoneNoticeInfoId.class)
public class MilestoneNoticeInfo {

  /** 提醒日期 */
  @Id
  @Column(name = "warning_date")
  private String warningDate;

  /** 通知标题 */
  @Column(name = "notice_title")
  private String noticeTitle;

  /** 通知内容 */
  @Column(name = "notice_content")
  private String noticeContent;

  /** 事件名称 */
  @Id
  @Column(name = "event_name")
  private String eventName;

  /** 事件日期 */
  @Column(name = "event_date")
  private String eventDate;

  /** 原始事件名称 */
  @Column(name = "original_event_name")
  private String originalEventName;

  /** 原始事件值 */
  @Column(name = "original_event_value")
  private String originalEventValue;

  /** 里程碑事件标志(0否1是) */
  @Column(name = "milestone_event_flag")
  private String milestoneEventFlag;

  /** 触发标志(0否1是) */
  @Column(name = "trigger_flag")
  private String triggerFlag;

  /** 系统时间(yyyy-mm-dd hh:mm:ss) */
  @Column(name = "system_time")
  private String systemTime;

  /** 0未发送 1已发送 */
  @Column(name = "msg_send_flag")
  private String msgSendFlag;
}
