package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author zijian.qjd
 * @since 2022/3/1 16:33
 */
@Table(name = "ads_mbl_service_request_sr")
@Data
public class AdsMblServiceRequestSr {

  /** 日期 */
  @Column(name = "date_date")
  private String dateDate;

  /** 服务请求类型{当日新增,超时处理} */
  @Column(name = "service_request_type")
  private String serviceRequestType;

  /** 序号 */
  @Column(name = "serial_no")
  private String serialNo;

  /** SR编号 */
  @Column(name = "sr_no")
  private String srNo;

  /** 问题描述(标题) */
  @Column(name = "problem_description")
  private String problemDescription;

  /** 备注 */
  @Column(name = "remark")
  private String remark;

  /** 状态 */
  @Column(name = "status")
  private String status;

  /** 优先级 */
  @Column(name = "priority")
  private String priority;

  /** 客户名称 */
  @Column(name = "airline_name")
  private String airlineName;

  /** 联系人 */
  @Column(name = "contact_person")
  private String contactPerson;

  /** 要求答复时间 */
  @Column(name = "request_response_time")
  private String requestResponseTime;

  /** 当前处理人 */
  @Column(name = "current_disposor")
  private String currentDisposor;

  /** 更新截止时间 */
  @Column(name = "update_deadline")
  private String updateDeadline;

  /** 系统时间 */
  @Column(name = "system_time")
  private String systemTime;

  /**
   * 0 - 正常
   *
   * <p>1 - 即将超期
   *
   * <p>2 - 超期
   */
  @Transient private Integer overdue = 0;
}
