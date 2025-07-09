package com.xuelangyun.shangfei.sacsc.domain.entity2;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2021/12/20 13:45
 */
@Data
@Table(name = "tb_user_role")
public class UserRole {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  /** 用户id - 和角色id联合唯一 */
  @Column(name = "user_id")
  private Integer userId;

  /** 角色id - 和用户id联合唯一 */
  @Column(name = "role_id")
  private Integer roleId;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "update_time")
  private Date updateTime;
}
