package com.xuelangyun.shangfei.sacsc.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Table(name = "cs_run_variflight")
public class CsRunVariflight {
  /** id */
  @Id private String id;

  /** 实际到达时间-秒数 */
  @Column(name = "actual_arrtime")
  private Long actualArrtime;

  /** 实际起飞时间-秒数 */
  @Column(name = "actual_deptime")
  private Long actualDeptime;

  /** 飞机注册号 */
  @Column(name = "aircraft_number")
  private String aircraftNumber;

  /** 飞机状态,状态 0计划 1起飞 2到达 3取消 4延误 999换机执行 */
  @Column(name = "flight_status")
  private Integer flightStatusCode;

  /** 到达地时区 */
  @Column(name = "dst_tinezone")
  private Integer dstTinezone;

  /** 预估到达时间 */
  @Column(name = "estimated_arrtime")
  private Long estimatedArrtime;

  /** 到达机场简称 */
  private String fdst;

  /** 到达机场名称 */
  @Column(name = "fdst_aptc_name")
  private String fdstAptCname;

  /** 航班号三字码 */
  private String fnum3;

  /** 航班号二字码 */
  private String fnum;

  /** 起飞机场简称 */
  private String forg;

  /** 起飞机场名称 */
  @Column(name = "forg_aptc_name")
  private String forgAptCname;

  /** 起飞时区 */
  @Column(name = "org_tinezone")
  private Integer orgTinezone;

  /** 计划起飞时间-秒 */
  @Column(name = "scheduled_deptime")
  private Long scheduledDeptime;

  /** 计划到达时间-秒 */
  @Column(name = "scheduled_arrtime")
  private Long scheduledArrtime;

  /** 机型 */
  @Column(name = "atype_name")
  private String atypeName;

  @Column(name = "create_time")
  private Date createTime;

  @Transient private String airCompany;

  @JsonFormat(pattern = "HH:mm")
  @Transient
  private Date actualArr;

  @JsonFormat(pattern = "HH:mm")
  @Transient
  private Date actualDep;

  @JsonFormat(pattern = "HH:mm")
  @Transient
  private Date scheduledDep;

  @JsonFormat(pattern = "HH:mm")
  @Transient
  private Date scheduledArr;

  @JsonFormat(pattern = "HH:mm")
  @Transient
  private Date estimatedArr;

  public Date getScheduledArr() {
    if (getScheduledArrtime() != null) {
      return new Date(getScheduledArrtime() * 1000);
    }
    return null;
  }

  public Date getScheduledDep() {
    if (getScheduledDeptime() != null) {
      return new Date(getScheduledDeptime() * 1000);
    }
    return null;
  }

  public Date getActualDep() {
    if (getActualDeptime() != null) {
      return new Date(getActualDeptime() * 1000);
    }
    return null;
  }

  public Date getActualArr() {
    if (getActualArrtime() != null) {
      return new Date(getActualArrtime() * 1000);
    }
    return null;
  }

  public Date getEstimatedArr() {
    if (getEstimatedArrtime() != null) {
      return new Date(getEstimatedArrtime() * 1000);
    }
    return null;
  }

  @Transient private String airCompanyLogo;
  @Transient private String airCompanyIcon;
}
