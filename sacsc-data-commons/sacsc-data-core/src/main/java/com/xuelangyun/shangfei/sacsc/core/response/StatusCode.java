package com.xuelangyun.shangfei.sacsc.core.response;

/** @Auther: zigui.zdf @Date: 2018/10/10 11:12 @Description:接口返回状态码 */
public class StatusCode {

  // 失败
  public static final String ERROR = "0";

  /** 成功 */
  public static final String SUCCESS = "1";

  /** 失败 */
  public static final String FAILED = "2";

  /** 未登录 */
  public static final String NO_LOGIN = "3";

  /** 未认证 */
  public static final String NO_AUTH = "4";

  public static final Short NO = 0;

  public static final Short YES = 1;
}
