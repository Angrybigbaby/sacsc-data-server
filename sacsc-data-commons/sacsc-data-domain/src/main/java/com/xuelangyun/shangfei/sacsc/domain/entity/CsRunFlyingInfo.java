package com.xuelangyun.shangfei.sacsc.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "cs_run_flying_info")
public class CsRunFlyingInfo {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 航段id */
  private Long flightid;

  /** 高度 */
  private String altitude;

  /** 离港机场经度 */
  private String llng;

  /** 离港机场纬度 */
  private String llat;

  /** 到港机场经度 */
  private String tlng;

  /** msn */
  private String msn;

  /** 到港机场纬度 */
  private String tlat;

  /** 起飞时间 */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date offtime;

  /** 预计到达时间(毫秒) */
  @Column(name = "ontimeTemp")
  private String ontimetemp;

  /** OUT时间 */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date outtime;

  /** 机队 */
  private String fleetname;

  /** 预计到达时间 */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date eta;

  /** 机尾号/飞机注册号/飞机机号 */
  private String tailnumber;

  /** 当前油量 */
  private String posfob;

  /** 首飞时间 */
  @Column(name = "firstflyTime")
  private String firstflytime;

  /** 当前时间 */
  @Column(name = "sysTime")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date systime;

  /** 航空公司 */
  private String company;

  /** 机型 */
  private String model;

  /** 当前经度 */
  private String lng;

  /** 当前纬度 */
  private String lat;

  /** 状态(1:OUT关仓 2:OFF起飞 3:POS在飞 4:ONN到达 5:INN开舱门) */
  private String stat;

  /** 空 */
  private String leginfos;

  /** 优先级1:高 2:中 3:低 4:无 */
  private Short minstep;

  /** IN时间 */
  private String inn;

  /** 航班日期 */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date legdate;

  /** 警告等级 */
  private String faultlevel;

  /** 到港机场四字码 */
  private String tfourcode;

  /** OFF时间 */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date off;

  /** 起飞时间(ms) */
  @Column(name = "offtimeTemp")
  private String offtimetemp;

  /** ON时间 */
  private String onn;

  /** 航班号 */
  private String flightnum;

  /** 离港机场的四字码 */
  private String lfourcode;

  /** 航班进度(空) */
  private String progress;

  /** 到港机场 */
  private String tairport;

  /** 离港机场 */
  private String lairport;

  /** 机龄(空) */
  private String age;

  /** 状态OUT OFF POS ONN INN */
  private String status;

  @Column(name = "create_time")
  private Date createTime;

  @Transient private List linePositions;

  @Transient private String airPlaneLogo;

  @Transient private String airCompanyLogo;

  @Transient private String airPlaneImage;

  @Transient private String airPlaneLandLogo;

  /** 告警信息类型(WARNING、CAUTION、STATUS、ADVISORY) */
  @Transient private String type;

  /** 故障等级(1:高2:中3:低4:无) */
  @Transient private Integer priority;

  @Transient private String cmsSerious;
  @Transient private String casSerious;

  @Transient private String fleetNo;
  @Transient private String deliveryTime;
}
