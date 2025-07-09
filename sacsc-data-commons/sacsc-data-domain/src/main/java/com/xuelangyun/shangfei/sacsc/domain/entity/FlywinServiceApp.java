package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "flywin_service_app")
public class FlywinServiceApp {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** APP类型 */
  @Column(name = "app_type")
  private String appType;

  /** APP名称 */
  @Column(name = "app_name")
  private String appName;

  @Column(name = "app_desc")
  private String appDesc;

  @Column(name = "create_time")
  private Date createTime;

  @Transient private String appLogo;
}
