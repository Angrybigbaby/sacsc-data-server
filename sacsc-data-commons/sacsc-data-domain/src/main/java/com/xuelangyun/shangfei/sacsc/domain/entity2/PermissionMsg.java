package com.xuelangyun.shangfei.sacsc.domain.entity2;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2021/12/20 13:49
 */
@Data
@Table(name = "tb_permission_app")
public class PermissionMsg {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  /** 消息模块名称 */
  @Column(name = "name")
  private String name;

  /** 0-特殊事件 1-每日概览 2-庆祝消息 ... */
  @Column(name = "type")
  private Integer type;

  @Column(name = "create_time")
  private Date createTime;

  @Column(name = "update_time")
  private Date updateTime;
}
