package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zijian.qjd
 * @since 2025/4/9
 */
@Data
@Table(name = "caphm_tailnumber_dim")
public class CaphmTailnumberDim {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  @Column(name = "caphm_tailnumber")
  private String caphmTailnumber;

  @Column(name = "standard_tailnumber")
  private String standardTailnumber;
}
