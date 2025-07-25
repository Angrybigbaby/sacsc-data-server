package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2020/8/26
 */
@Table(name = "cs_pm_engine_shake_replace_point")
@Data
public class CsPmEngineShakeReplacePoint {
  /** id */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 换件点 */
  @Column(name = "replace_time")
  private Date replaceTime;

  /** 飞机尾号 */
  @Column(name = "tailnumber")
  private String tailnumber;

  /** 发动机 */
  @Column(name = "engine_no")
  private Integer engineNo;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
