package com.xuelangyun.shangfei.sacsc.domain.entity2;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2021/12/20 13:40
 */
@Data
@Table(name = "tb_user")
public class User {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  /** 姓名 */
  @Column(name = "username")
  private String username;

  /** 工号- 唯一 */
  @Column(name = "user_number")
  private String userNumber;

  /** 手机号 - 唯一 */
  @Column(name = "user_tel")
  private String userTel;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "update_time")
  private Date updateTime;
}
