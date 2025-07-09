package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "flywin_service_delivery_air_company")
public class FlywinServiceDeliveryAirCompany {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 机型 */
  @Column(name = "fly_model")
  private String flyModel;

  /** 已交付航司 */
  @Column(name = "air_company")
  private String airCompany;

  @Column(name = "create_time")
  private Date createTime;

  @Transient private String airCompanyLogo;

  @Transient private String airPlaneLogo;
}
