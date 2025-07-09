package com.xuelangyun.shangfei.sacsc.domain.entity2;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2023/10/26
 */
@Table(name = "tb_access_record")
@Data
public class AccessRecord {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "sf_user_id")
  private String sfUserId;

  @Column(name = "name")
  private String name;

  @Column(name = "serial_number")
  private String serialNumber;

  @Column(name = "path")
  private String path;

  @Column(name = "code")
  private String code;

  @Column(name = "company_code")
  private String companyCode;

  @Column(name = "company")
  private String company;

  @Column(name = "department_code")
  private String departmentCode;

  @Column(name = "department")
  private String department;

  @Column(name = "access_time")
  private Date accessTime;

  @Column(name = "access_timestamp")
  private Long accessTimestamp;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "update_time")
  private Date updateTime;
}
