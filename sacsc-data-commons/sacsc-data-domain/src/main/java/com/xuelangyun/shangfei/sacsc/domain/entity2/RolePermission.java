package com.xuelangyun.shangfei.sacsc.domain.entity2;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2021/12/20 13:53
 */
@Data
@Table(name = "tb_role_permission")
public class RolePermission {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  /** 角色id - 与type、permission_id联合唯一 */
  @Column(name = "role_id")
  private Integer roleId;

  /** 0-app 1-msg ... - 与role_id、permission_id联合唯一 */
  @Column(name = "type")
  private Integer type;

  /** 权限id - - 与role_id、type联合唯一 */
  @Column(name = "permission_id")
  private Integer permissionId;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "update_time")
  private Date updateTime;
}
