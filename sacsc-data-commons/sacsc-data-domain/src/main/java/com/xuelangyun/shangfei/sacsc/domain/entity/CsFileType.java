package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "cs_file_type")
public class CsFileType {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 备注描述 */
  @Column(name = "type_desc")
  private String typeDesc;

  /** 是否有效0=无效,1=有效 */
  @Column(name = "is_valid")
  private Short isValid = 1;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "update_time")
  private Date updateTime;

  @Transient private List<CsFileTypeSrc> srcList;
}
