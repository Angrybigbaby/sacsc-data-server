package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2020/8/28
 */
@Table(name = "cs_pm_engine_start_alert")
@Data
public class CsPmEngineStartAlert {
  /** id */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  /** 报警信息 */
  @Column(name = "alert")
  private String alert;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
