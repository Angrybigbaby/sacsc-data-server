package com.xuelangyun.shangfei.sacsc.flight.email;

import lombok.Getter;

/**
 * @author mochen.qy
 * @date 2023/5/9 11:32
 */
@Getter
public enum EmailExceptionEnum {
  /** 用户提示信息 */
  EMAIL_PARAM_EMPTY_ERROR("邮件发送失败，请检查参数配置，{}参数可能为空");

  /** 提示用户信息 */
  private final String userTip;

  EmailExceptionEnum(String userTip) {
    this.userTip = userTip;
  }
}
