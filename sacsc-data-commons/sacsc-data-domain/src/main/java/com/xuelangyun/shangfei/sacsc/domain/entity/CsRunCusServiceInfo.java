package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cs_run_cus_service_info")
public class CsRunCusServiceInfo {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 客服基地名称 */
  private String name;

  /** 地址 */
  private String location;

  /** 经度 */
  private String longitude;

  /** 纬度 */
  private String latitude;

  /** 维修交付中心地址 */
  @Column(name = "repair_delivery_location")
  private String repairDeliveryLocation;

  @Column(name = "create_time")
  private Date createTime;

  /** @return id */
  public Long getId() {
    return id;
  }

  /** @param id */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取客服基地名称
   *
   * @return name - 客服基地名称
   */
  public String getName() {
    return name;
  }

  /**
   * 设置客服基地名称
   *
   * @param name 客服基地名称
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 获取地址
   *
   * @return location - 地址
   */
  public String getLocation() {
    return location;
  }

  /**
   * 设置地址
   *
   * @param location 地址
   */
  public void setLocation(String location) {
    this.location = location;
  }

  /**
   * 获取经度
   *
   * @return longitude - 经度
   */
  public String getLongitude() {
    return longitude;
  }

  /**
   * 设置经度
   *
   * @param longitude 经度
   */
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  /**
   * 获取纬度
   *
   * @return latitude - 纬度
   */
  public String getLatitude() {
    return latitude;
  }

  /**
   * 设置纬度
   *
   * @param latitude 纬度
   */
  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  /**
   * 获取维修交付中心地址
   *
   * @return repair_delivery_location - 维修交付中心地址
   */
  public String getRepairDeliveryLocation() {
    return repairDeliveryLocation;
  }

  /**
   * 设置维修交付中心地址
   *
   * @param repairDeliveryLocation 维修交付中心地址
   */
  public void setRepairDeliveryLocation(String repairDeliveryLocation) {
    this.repairDeliveryLocation = repairDeliveryLocation;
  }

  /** @return create_time */
  public Date getCreateTime() {
    return createTime;
  }

  /** @param createTime */
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
