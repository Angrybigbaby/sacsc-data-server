package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author zijian.qjd
 * @since 2023/7/31 15:31
 */
@Data
@Table(name = "ods_airline_name_mapping_info")
public class OdsAirlineNameMappingInfo {

  @Column(name = "serial_no")
  private String serialNo;

  @Column(name = "standard_name")
  private String standardName;

  @Column(name = "original_name")
  private String originalName;
}
