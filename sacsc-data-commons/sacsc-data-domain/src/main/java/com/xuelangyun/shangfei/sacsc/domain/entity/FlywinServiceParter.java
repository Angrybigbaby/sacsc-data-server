package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "flywin_service_parter")
public class FlywinServiceParter {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 伙伴类型名称 */
  @Column(name = "parter_type")
  private String parterType;

  /** 公司名称 */
  @Column(name = "parter_name")
  private String parterName;

  @Column(name = "create_time")
  private Date createTime;

  @Transient private String parterLogo;
}
