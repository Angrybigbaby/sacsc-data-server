package com.xuelangyun.shangfei.sacsc.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "cs_fuel_consume_data_date")
public class CsFuelConsumeDataDate {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 数据截止日期 */
  @JsonFormat(pattern = "yyyy-MM-dd")
  @Column(name = "data_date")
  private Date dataDate;

  @Column(name = "create_time")
  private Date createTime;
}
