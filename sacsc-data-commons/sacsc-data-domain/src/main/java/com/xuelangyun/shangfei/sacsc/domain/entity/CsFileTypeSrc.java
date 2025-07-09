package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "cs_file_type_src")
public class CsFileTypeSrc {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 关联表cs_file_manage的id */
  @Column(name = "type_id")
  private Long typeId;

  @Column(name = "src_desc")
  private String srcDesc;

  /** 文件路径 */
  @Column(name = "file_url")
  private String fileUrl;

  /** 是否有效0=无效,1=有效 */
  @Column(name = "is_valid")
  private Short isValid = 1;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "update_time")
  private Date updateTime;
}
