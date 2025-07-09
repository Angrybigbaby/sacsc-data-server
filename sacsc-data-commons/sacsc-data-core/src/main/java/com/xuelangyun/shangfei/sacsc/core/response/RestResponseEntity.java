package com.xuelangyun.shangfei.sacsc.core.response;

import lombok.Data;

import java.io.Serializable;

/** @Auther: futang.tyf @Date: 2018/8/8 17:08 @Description: */
@Data
public class RestResponseEntity<T> implements Serializable {

  private String status = StatusCode.SUCCESS;

  private String msg = "请求成功";

  private T data = null;

  public RestResponseEntity() {}

  public RestResponseEntity(T data) {
    this.data = data;
  }

  public RestResponseEntity(String code, String message) {
    this.status = code;
    this.msg = message;
  }

  public RestResponseEntity(String code, String message, T data) {
    this.status = code;
    this.msg = message;
    this.data = data;
  }
}
