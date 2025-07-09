package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author zijian.qjd
 * @since 2023/6/15 15:36
 */
@Table(name = "ads_mbl_aircraft_delivery_info")
@Data
public class AdsMblAircraftDeliveryInfo {

  /** 飞机序列号+注册号 */
  @Column(name = "plane_reg_serial")
  private String planeRegSerial;

  /** 交付日期（yyyy-mm-dd） */
  @Column(name = "sort_date")
  private String sortDate;

  /** 纬度：airline、year */
  @Column(name = "dimension_type")
  private String dimensionType;

  /** 机型 */
  @Column(name = "aircraft_model")
  private String aircraftModel;

  /** 航司 */
  @Column(name = "airline_standard_name")
  private String airlineStandardName;

  @Transient private String aircraftNoWithHyphen;
  @Transient private String aircraftNoWithoutHyphen;
  @Transient private String msn;
  @Transient private String aircraftNo;
}
