package com.xuelangyun.shangfei.sacsc.domain.entity2;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zijian.qjd
 * @since 2022/2/28 9:58
 */
@Table(name = "tb_msg_record")
@Data
public class MsgRecord {

  /** 蓝信返回的msgId */
  @Id private String id;

  /** 推送的消息 */
  @Column(name = "msg")
  private String msg;

  /** 0已撤回 1已发送 */
  @Column(name = "status")
  private Integer status;

  /** 撤回说明 - 如果这个字段不为空且status不为已撤回表示撤回有问题 */
  @Column(name = "recall_msg")
  private String recallMsg;

  @Column(name = "create_time")
  private Date createTime;
}
