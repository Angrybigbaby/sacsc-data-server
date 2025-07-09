package com.xuelangyun.shangfei.sacsc.domain.entity2;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2021/12/20 13:47
 */
@Data
@Table(name = "tb_permission_app")
public class PermissionApp {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  /** app名称 */
  @Column(name = "name")
  private String name;

  /** 唯一标志 */
  @Column(name = "unique_id")
  private String uniqueId;

  /** description */
  @Column(name = "remark")
  private String remark;

  /** 机型 */
  @Column(name = "model")
  private String model;

  /** app icon相对路径 */
  @Column(name = "icon")
  @Deprecated
  private String icon;

  /** app相对路径 */
  @Column(name = "url")
  @Deprecated
  private String url;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "update_time")
  private Date updateTime;
}
