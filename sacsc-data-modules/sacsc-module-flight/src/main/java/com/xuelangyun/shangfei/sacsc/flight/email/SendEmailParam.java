package com.xuelangyun.shangfei.sacsc.flight.email;

import lombok.Data;

/**
 * @author mochen.qy
 * @date 2023/5/9 10:32
 */
@Data
public class SendEmailParam {

  /** 邮件标题 */
  protected String title;

  /** 邮件内容 */
  protected String content;
}
