package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cs_run_air_company_basic_info")
public class CsRunAirCompanyBasicInfo {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 航空公司 */
  @Column(name = "air_company")
  private String airCompany;

  /** 航空公司主基地地址 */
  private String location;

  /** 经度 */
  private String longitude;

  /** 纬度 */
  private String latitude;

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
   * 获取航空公司
   *
   * @return air_company - 航空公司
   */
  public String getAirCompany() {
    return airCompany;
  }

  /**
   * 设置航空公司
   *
   * @param airCompany 航空公司
   */
  public void setAirCompany(String airCompany) {
    this.airCompany = airCompany;
  }

  /**
   * 获取航空公司主基地地址
   *
   * @return location - 航空公司主基地地址
   */
  public String getLocation() {
    return location;
  }

  /**
   * 设置航空公司主基地地址
   *
   * @param location 航空公司主基地地址
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

  /** @return create_time */
  public Date getCreateTime() {
    return createTime;
  }

  /** @param createTime */
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
