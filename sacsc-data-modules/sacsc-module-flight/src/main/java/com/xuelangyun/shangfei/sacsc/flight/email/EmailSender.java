package com.xuelangyun.shangfei.sacsc.flight.email;

/**
 * @author mochen.qy
 * @date 2023/5/8 11:30
 */
public interface EmailSender<T extends SendEmailParam> {

  /**
   * 发送普通邮件
   *
   * @param sendMailParam 发送邮件的参数
   */
  void sendMail(T sendMailParam);
}
