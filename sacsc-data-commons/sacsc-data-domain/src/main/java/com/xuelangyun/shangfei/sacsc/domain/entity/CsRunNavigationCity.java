package com.xuelangyun.shangfei.sacsc.domain.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "cs_run_navigation_city")
public class CsRunNavigationCity {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 通航城市 */
  @Column(name = "fly_city")
  private String flyCity;

  /** 机型,ARJ,C919等 */
  @Column(name = "fly_model")
  private String flyModel;

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
   * 获取通航城市
   *
   * @return fly_city - 通航城市
   */
  public String getFlyCity() {
    return flyCity;
  }

  /**
   * 设置通航城市
   *
   * @param flyCity 通航城市
   */
  public void setFlyCity(String flyCity) {
    this.flyCity = flyCity;
  }

  /**
   * 获取机型,ARJ,C919等
   *
   * @return fly_model - 机型,ARJ,C919等
   */
  public String getFlyModel() {
    return flyModel;
  }

  /**
   * 设置机型,ARJ,C919等
   *
   * @param flyModel 机型,ARJ,C919等
   */
  public void setFlyModel(String flyModel) {
    this.flyModel = flyModel;
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
