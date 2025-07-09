package com.xuelangyun.shangfei.sacsc.domain.entity;

import com.xuelangyun.shangfei.sacsc.domain.base.FlightBasicInfo;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "cs_run_flight_ground_basic_info")
public class CsRunFlightGroundBasicInfo extends FlightBasicInfo {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "create_time")
  private Date createTime;

  /** 航班号 */
  @Transient private String flightnum;

  /** 到港机场 */
  @Transient private String tairport;

  /** 离港机场 */
  @Transient private String lairport;

  /** 起飞时间 */
  @Transient private Date offtime;

  /** 预计到达时间 */
  @Transient private Date eta;

  /** 航班进度 */
  @Transient private Double progress;
}
