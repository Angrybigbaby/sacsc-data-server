package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "cs_run_parked_plane")
public class CsRunParkedPlane {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 航空公司 */
  @Column(name = "air_company")
  private String airCompany;

  /** 机尾号 */
  @Column(name = "tail_number")
  private String tailNumber;

  /** 状态 */
  @Column(name = "fly_status")
  private String flyStatus;

  /** 经度 */
  private Double longitude;

  /** 纬度 */
  private Double latitude;

  /** 所处位置类别:1=MRO,2=客服基地,3=航司,4=通航机场 */
  @Column(name = "location_type")
  private Short locationType;

  /** 具体的通航机场,客服基地等 */
  @Column(name = "location_content")
  private String locationContent;

  @Column(name = "create_time")
  private Date createTime;

  private String msn;

  @Transient private Short parKType = 1;
}
