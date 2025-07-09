package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "gant_tailnumber_msn")
public class GantTailnumberMSN {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  @Column(name = "msn")
  private String msn;

  @Column(name = "tailnumber")
  private String tailnumber;

  private Date createTime;
}
