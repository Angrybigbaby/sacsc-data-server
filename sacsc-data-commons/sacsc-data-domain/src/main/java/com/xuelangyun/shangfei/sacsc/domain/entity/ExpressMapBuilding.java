package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "express_map_building")
public class ExpressMapBuilding {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 名称 */
  private String name;

  /** 建筑类型 */
  private Integer type;

  /** 人 */
  private String people;

  /** 机 */
  private String machine;

  /** 物 */
  private String datum;

  /** 法 */
  private String program;

  /** 环 */
  private String environment;

  @Column(name = "create_time")
  private Date createTime;

  // 默认不显示
  @Transient private Integer display = 0;

  @Column(name = "code")
  private String code;
}
