package com.xuelangyun.shangfei.sacsc.domain.entity2;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2021/12/20 13:43
 */
@Data
@Table(name = "tb_role")
public class Role {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  /** 角色名称 - 唯一 */
  @Column(name = "role_name")
  private String roleName;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "update_time")
  private Date updateTime;
}
