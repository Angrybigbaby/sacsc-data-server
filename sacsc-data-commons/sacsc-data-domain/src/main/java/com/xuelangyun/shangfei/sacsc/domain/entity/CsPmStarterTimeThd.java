package com.xuelangyun.shangfei.sacsc.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2020/8/23
 *     <p>预测维修-起动机活门打开关闭时间阈值
 */
@Table(name = "cs_pm_starter_time_thd")
@Data
public class CsPmStarterTimeThd {
  /** id */
  @Id
  @GeneratedValue(generator = "JDBC")
  private Long id;

  /** 打开时间上限值秒 */
  @Column(name = "open_time_up")
  private Double openTimeUp;

  /** 打开时间下限值秒 */
  @Column(name = "open_time_down")
  private Double openTimeDown;

  /** 关闭时间上限值秒 */
  @Column(name = "close_time_up")
  private Double closeTimeUp;

  /** 关闭时间下限值秒 */
  @Column(name = "close_time_down")
  private Double closeTimeDown;

  /** 创建时间 */
  @Column(name = "create_time")
  private Date createTime;
}
