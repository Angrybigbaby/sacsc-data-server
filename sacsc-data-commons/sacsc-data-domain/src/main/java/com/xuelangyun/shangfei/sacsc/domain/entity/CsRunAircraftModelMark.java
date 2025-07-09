package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2023/2/15 9:43
 */
@Data
@Table(name = "cs_run_aircraft_model_mark")
public class CsRunAircraftModelMark {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  @Column(name = "aircraft_model")
  private String aircraftModel;

  @Column(name = "standard")
  private String standard;

  @Column(name = "create_time")
  private Date createTime;
}
