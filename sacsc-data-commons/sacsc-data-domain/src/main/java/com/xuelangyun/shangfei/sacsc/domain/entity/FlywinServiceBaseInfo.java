package com.xuelangyun.shangfei.sacsc.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "flywin_service_base_info")
public class FlywinServiceBaseInfo {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 机型 */
  @Column(name = "fly_model")
  private String flyModel;

  /** 已交付飞机数量 */
  @Column(name = "delivered_plane_amount")
  private Integer deliveredPlaneAmount;

  /** 首架服役时间 */
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Column(name = "first_service_date")
  private Date firstServiceDate;

  /** 运行时长(小时) */
  @Column(name = "service_hours")
  private Double serviceHours;

  /** 载客人次 */
  private Integer passenger;

  /** 最大商载(KG) */
  @Column(name = "commercial_load_max")
  private Double commercialLoadMax;

  @Column(name = "create_time")
  private Date createTime;

  @Transient private List payCusList;
}
