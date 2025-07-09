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
 * @since 2022/3/4 9:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_verify_code")
public class VerifyCode {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  @Column(name = "code")
  private String code;

  @Column(name = "create_time")
  private Date createTime;
}
