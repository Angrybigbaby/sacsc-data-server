package com.xuelangyun.shangfei.sacsc.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xuelangyun.shangfei.sacsc.domain.base.FlightBasicInfo;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "cs_run_flight_basic_info")
public class CsRunFlightBasicInfo extends FlightBasicInfo {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 高度 */
  private String altitude;

  /** 离港机场纬度 */
  private String llat;

  /** 到港机场经度 */
  private String tlng;

  /** 起飞时间 */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date offtime;

  /** 离港机场经度 */
  private String llng;

  /** 预计到达时间(毫秒) */
  @Column(name = "ontimeTemp")
  private Double ontimetemp;

  /** OUT时间 out冲撞关键字了 */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Column(name = "outTime")
  private Date out;

  /** 机队 */
  private String fleetname;

  /** 预计到达时间 */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date eta;

  /** 当前油量 */
  private String posfob;

  /** 首飞时间 */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Column(name = "firstflyTime")
  private Date firstflytime;

  /** 当前时间 */
  @Column(name = "sysTime")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date systime;

  /** 到港机场纬度 */
  private String tlat;

  /** 当前纬度 */
  private String lat;

  /** 状态(1:OUT2:OFF3:POS4:O */
  private Integer stat;

  /** 当前经度 */
  private String lng;

  /** 空 */
  private String leginfos;

  /** 优先级(1:高2:中3:低4:无) */
  private Integer minstep;

  /** IN时间 */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date inn;

  /** 航段ID */
  private Long flightid;

  /** 到港机场四字码 */
  private String tfourcode;

  /** OFF时间 */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date off;

  /** 起飞时间(ms) */
  @Column(name = "offtimeTemp")
  private Double offtimetemp;

  /** ON时间 */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date onn;

  /** 航班号 */
  private String flightnum;

  /** 离港机场的四字码 */
  private String lfourcode;

  /** 航班进度 */
  private Double progress;

  /** 到港机场 */
  private String tairport;

  /** 离港机场 */
  private String lairport;

  /** 状态(OUT OFF POSONN INN) */
  private String status;

  /** 航班日期 */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date legdate;

  private String msn;

  @Column(name = "create_time")
  private Date createTime;
}
