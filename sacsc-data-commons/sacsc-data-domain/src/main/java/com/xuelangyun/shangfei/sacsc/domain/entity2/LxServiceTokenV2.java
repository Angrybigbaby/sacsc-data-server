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
 * @since 2024/6/24
 */
@Data
@Table(name = "tb_lx_service_token_v2")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LxServiceTokenV2 {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "app_id")
  private String appId;

  @Column(name = "access_token")
  private String accessToken;

  /** 有效期（7200秒） */
  @Column(name = "expires_in")
  private Integer expiresIn;

  /** 在 beforeDate 之前有效 */
  @Column(name = "before_date")
  private Date beforeDate;

  /** 创建时间. */
  @Column(name = "create_time")
  private Date createTime;

  /** 更新时间. */
  @Column(name = "last_modified_time")
  private Date lastModifiedTime;
}
