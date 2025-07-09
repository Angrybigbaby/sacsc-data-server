package com.xuelangyun.shangfei.sacsc.flight.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zijian.qjd
 * @version 1.0
 * @description FlightStatus
 * @since 2021/6/7
 */
@Slf4j
public enum FlightStatusV2 {
  /** 计划 */
  SCHEDULE(0, "计划"),
  /** 起飞 */
  TAKE_OFF(1, "起飞"),
  /** 到达 */
  ARRIVE(2, "到达"),
  /** 取消 */
  CANCEL(3, "取消"),
  /** 延误 */
  DELAY(4, "延误"),
  /** 失联 */
  MISSING(1000, "失联"),
  /** 备降 */
  DIVERSION(1001, "备降"),
  /** 返航 */
  BACK(1002, "返航"),
  ;

  private final Integer code;
  private final String comment;

  FlightStatusV2(Integer code, String comment) {
    this.code = code;
    this.comment = comment;
  }

  public Integer getCode() {
    return this.code;
  }

  public String getComment() {
    return this.comment;
  }

  public static final Map<String, Integer> STATUS_MAPPING =
      Arrays.stream(FlightStatusV2.values())
          .collect(
              Collectors.toMap(
                  FlightStatusV2::getComment, FlightStatusV2::getCode, (e1, e2) -> e1));
}
