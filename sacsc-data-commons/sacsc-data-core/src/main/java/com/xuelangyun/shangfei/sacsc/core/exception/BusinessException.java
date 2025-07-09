package com.xuelangyun.shangfei.sacsc.core.exception;

/** @Auther: futang.tyf @Date: 2018/8/8 17:40 @Description: */
public class BusinessException extends RuntimeException {

  private String code;
  private String message;

  public BusinessException(String code, String message) {
    super(message);
    this.code = code;
    this.message = message;
  }

  @Override
  public String getMessage() {
    String superMessage = super.getMessage();
    return null == superMessage ? message : superMessage;
  }

  public String getCode() {
    return this.code;
  }
}
