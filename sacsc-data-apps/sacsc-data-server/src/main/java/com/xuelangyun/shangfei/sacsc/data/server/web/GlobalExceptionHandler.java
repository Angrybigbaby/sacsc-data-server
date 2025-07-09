package com.xuelangyun.shangfei.sacsc.data.server.web;

import com.google.common.collect.Lists;
import com.xuelangyun.shangfei.sacsc.core.exception.BusinessException;
import com.xuelangyun.shangfei.sacsc.core.response.RestResponseEntity;
import com.xuelangyun.shangfei.sacsc.core.response.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/** @Auther: zigui.zdf @Date: 2018/10/10 11:12 @Description:统一异常处理 */
@ControllerAdvice
@Component
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler
  @ResponseBody
  public RestResponseEntity handle(Exception exception) {
    RestResponseEntity result = new RestResponseEntity();

    if (exception instanceof BadSqlGrammarException) {
      result.setStatus(StatusCode.FAILED);
      result.setMsg("SQL异常");
    } else if (exception instanceof BusinessException) {
      result.setStatus(StatusCode.FAILED);
      //            result.setStatus(((BusinessException) exception).getCode());
      result.setMsg(exception.getMessage());

    } else if (exception instanceof MethodArgumentNotValidException) {
      MethodArgumentNotValidException e = (MethodArgumentNotValidException) exception;
      List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
      List<String> codes = Lists.newArrayList();
      String msg = "";
      if (CollectionUtils.isNotEmpty(fieldErrors)) {
        Iterator var15 = fieldErrors.iterator();
        while (var15.hasNext()) {
          FieldError fe = (FieldError) var15.next();
          codes.add(fe.getDefaultMessage());
        }
        Collections.sort(codes);
        msg = codes.get(0);
      }
      result.setStatus(StatusCode.FAILED);
      result.setMsg(msg);
    } else if (exception instanceof BindException) {
      BindException e = (BindException) exception;
      List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
      List<String> codes = Lists.newArrayList();
      String msg = "";
      if (CollectionUtils.isNotEmpty(fieldErrors)) {
        Iterator var15 = fieldErrors.iterator();
        while (var15.hasNext()) {
          FieldError fe = (FieldError) var15.next();
          codes.add(fe.getDefaultMessage());
        }
        Collections.sort(codes);
        msg = codes.get(0);
      }
      result.setStatus(StatusCode.FAILED);
      result.setMsg(msg);
    } else if (exception instanceof MaxUploadSizeExceededException) {
      result.setStatus(StatusCode.FAILED);
      result.setMsg("文件过大");
    } else if (exception instanceof IllegalArgumentException) {
      result.setStatus(StatusCode.FAILED);
      result.setMsg("参数非法");
    } else if (exception instanceof MissingServletRequestParameterException) {
      MissingServletRequestParameterException missingServletRequestParameterException =
          (MissingServletRequestParameterException) exception;
      result.setStatus(StatusCode.FAILED);
      result.setMsg(
          String.format("参数:%s必填", missingServletRequestParameterException.getParameterName()));
    } else {
      result.setStatus(StatusCode.FAILED);
      result.setMsg("系统异常");
    }

    log.error("", exception);

    return result;
  }
}
