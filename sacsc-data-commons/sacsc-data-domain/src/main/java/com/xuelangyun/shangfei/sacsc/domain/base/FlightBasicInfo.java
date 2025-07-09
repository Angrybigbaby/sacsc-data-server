package com.xuelangyun.shangfei.sacsc.domain.base;

import lombok.Data;

/** Create by huaying.ll on 2020/9/5 */
@Data
public class FlightBasicInfo {

  /** 机尾号 */
  private String tailnumber;

  /** 航空公司 */
  private String company;

  /** 机型 */
  private String model;

  /** 机龄 */
  private Double age;
}
