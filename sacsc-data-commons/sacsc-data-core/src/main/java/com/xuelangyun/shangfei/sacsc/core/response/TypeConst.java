package com.xuelangyun.shangfei.sacsc.core.response;

public interface TypeConst {

  // 动画模型1:1=运行支持
  Short MODEL1 = 1;

  // 动画模型2: 2=订单交易
  Short MODEL2 = 2;

  // 运行支持主屏,小机构类型1=MRO,2=客服基地,3=航司,4=通航机场
  Short MRO = 1;

  // 2=客服基地
  Short CUSSERVICE = 2;

  // 3=航司
  Short AIRCOM = 3;

  // 4=通航机场
  Short AIRPORT = 4;

  // 地上飞机分类1=停场
  Short PARKING = 1;

  // 地上飞机分类2=定检
  Short INSPECTION = 2;

  // 地上飞机分类3=其他
  Short OTHER = 3;

  // 状态1=执行完成,2=正在执行,3=执行失败
  Short SUCCESS = 1;

  // 2=正在执行
  Short ING = 2;

  // 3=执行失败
  Short ERROR = 3;

  /** 商飞快线-地图建筑种类 1=机场,2=AOC,3=客服中心,4=虹桥办公区* */
  Integer EXAIRPORT = 1;

  Integer DISPLAY = 1;
  Integer UNDISPLAY = 0;

  Integer NOTAKEOFF = 1;

  Integer TAKEOFF = 2;

  Integer ARRIVE = 3;
}
