package com.xuelangyun.shangfei.sacsc.domain.enums;

/**
 * @author zijian.qjd
 * @since 2021/12/20 14:52
 */
public enum PermissionType {
  /** app */
  APP(0),
  /** msg */
  MSG(1),
  ;

  private final Integer type;

  PermissionType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }
}
