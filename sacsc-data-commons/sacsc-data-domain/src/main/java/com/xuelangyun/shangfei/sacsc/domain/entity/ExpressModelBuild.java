package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "express_model_build")
public class ExpressModelBuild {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 模型类型1=商飞快线 */
  @Column(name = "model_type")
  private Integer modelType;

  /** 风速(m/s) */
  @Column(name = "airport_name")
  private String airportName;

  /** x */
  private String x;

  /** y */
  private String y;

  /** z */
  private String z;

  @Transient private String pos;

  public String getPos() {
    return String.join(",", getX(), getY(), getZ());
  }

  @Column(name = "create_time")
  private Date createTime;
}
