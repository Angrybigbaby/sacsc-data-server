package com.xuelangyun.shangfei.sacsc.domain.entity2;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2021/12/20 14:22
 */
@Data
@Table(name = "tb_lx_auth_token")
public class LxAuthToken {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  /** 唯一 */
  @Column(name = "access_token")
  private String accessToken;

  /** access_token接口调用凭证超时时间，单位（秒） */
  @Column(name = "expire_in")
  private Integer expiresIn;

  /** 唯一 */
  @Column(name = "refresh_token")
  private String refreshToken;

  /** 用户唯一标识（手机号或userUniId）- 唯一 */
  @Column(name = "openid")
  private String openid;

  /** 用户授权的作用域 */
  @Column(name = "scope")
  private String scope;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "update_time")
  private Date updateTime;
}
