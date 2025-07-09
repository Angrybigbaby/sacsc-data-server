package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cs_api_record_info")
public class CsApiRecordInfo {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 接口名称 */
  @Column(name = "api_name")
  private String apiName;

  /** 参数记录 */
  @Column(name = "api_param")
  private String apiParam;

  /** 1=执行完成,2=正在执行,3=执行失败 */
  @Column(name = "res_status")
  private Short resStatus;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "update_time")
  private Date updateTime;

  /** 返回信息 */
  @Column(name = "res_info")
  private String resInfo;

  /** @return id */
  public Long getId() {
    return id;
  }

  /** @param id */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * 获取接口名称
   *
   * @return api_name - 接口名称
   */
  public String getApiName() {
    return apiName;
  }

  /**
   * 设置接口名称
   *
   * @param apiName 接口名称
   */
  public void setApiName(String apiName) {
    this.apiName = apiName;
  }

  /**
   * 获取参数记录
   *
   * @return api_param - 参数记录
   */
  public String getApiParam() {
    return apiParam;
  }

  /**
   * 设置参数记录
   *
   * @param apiParam 参数记录
   */
  public void setApiParam(String apiParam) {
    this.apiParam = apiParam;
  }

  /**
   * 获取1=执行完成,2=正在执行,3=执行失败
   *
   * @return res_status - 1=执行完成,2=正在执行,3=执行失败
   */
  public Short getResStatus() {
    return resStatus;
  }

  /**
   * 设置1=执行完成,2=正在执行,3=执行失败
   *
   * @param resStatus 1=执行完成,2=正在执行,3=执行失败
   */
  public void setResStatus(Short resStatus) {
    this.resStatus = resStatus;
  }

  /** @return create_time */
  public Date getCreateTime() {
    return createTime;
  }

  /** @param createTime */
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  /** @return update_time */
  public Date getUpdateTime() {
    return updateTime;
  }

  /** @param updateTime */
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  /**
   * 获取返回信息
   *
   * @return res_info - 返回信息
   */
  public String getResInfo() {
    return resInfo;
  }

  /**
   * 设置返回信息
   *
   * @param resInfo 返回信息
   */
  public void setResInfo(String resInfo) {
    this.resInfo = resInfo;
  }
}
