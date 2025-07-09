package com.xuelangyun.shangfei.sacsc.flight.enums;

/**
 * @author zijian.qjd
 * @since 2023/2/16 11:14
 */
public enum AircraftModel {
  ARJ21("ARJ21"),
  C919("C919"),
  ;

  private final String model;

  AircraftModel(final String model) {
    this.model = model;
  }

  public String getModel() {
    return model;
  }
}
