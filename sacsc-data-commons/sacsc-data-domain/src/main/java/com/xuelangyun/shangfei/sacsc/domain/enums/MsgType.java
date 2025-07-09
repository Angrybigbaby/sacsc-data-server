package com.xuelangyun.shangfei.sacsc.domain.enums;

/**
 * @author zijian.qjd
 * @since 2021/12/20 16:30
 */
public enum MsgType {
  /** 特殊事件 */
  SPECIAL(0),
  /** 每日概览 */
  OVERVIEW(1),
  /** 庆祝消息 */
  CELEBRATION(2),
  ;

  private final Integer type;

  MsgType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }
}
