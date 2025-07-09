package com.xuelangyun.shangfei.sacsc.domain.entity2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Table(name = "tb_lx_auth_token_v2")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LxAuthTokenV2 {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  /** 唯一 */
  @Column(name = "user_token")
  private String userToken;

  /** 有效期（7200秒） */
  @Column(name = "expire_in")
  private Integer expiresIn;

  /** 唯一 - 人员 OpenId */
  @Column(name = "staff_id")
  private String staffId;

  @Column(name = "scope")
  private String scope;

  @Column(name = "state")
  private String state;

  /** 在 beforeDate 之前有效 */
  @Column(name = "before_date")
  private Date beforeDate;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "update_time")
  private Date updateTime;
}
