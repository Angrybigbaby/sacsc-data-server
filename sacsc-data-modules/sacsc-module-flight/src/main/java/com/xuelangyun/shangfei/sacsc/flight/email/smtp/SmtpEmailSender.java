package com.xuelangyun.shangfei.sacsc.flight.email.smtp;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailException;
import cn.hutool.extra.mail.MailUtil;
import com.xuelangyun.shangfei.sacsc.flight.email.EmailExceptionEnum;
import com.xuelangyun.shangfei.sacsc.flight.email.EmailSender;

/**
 * @author mochen.qy
 * @date 2023/5/9 10:26
 */
public class SmtpEmailSender implements EmailSender<SmtpSendMailParam> {

  private SmtpEmailProperties smtpEmailProperties;
  private MailAccount mailAccount;

  public SmtpEmailSender(SmtpEmailProperties smtpEmailProperties) {
    this.smtpEmailProperties = smtpEmailProperties;
  }

  @Override
  public void sendMail(SmtpSendMailParam sendMailParam) {
    // 校验发送邮件的参数
    assertSendMailParams(sendMailParam);

    // spring发送邮件
    MailUtil.send(
        mailAccount,
        sendMailParam.getTos(),
        sendMailParam.getCcsTos(),
        sendMailParam.getBccsTos(),
        sendMailParam.getTitle(),
        sendMailParam.getContent(),
        sendMailParam.getImageMap(),
        false,
        sendMailParam.getFiles());
  }

  /** 初始化邮件账户 */
  private void initMailAccount() {
    mailAccount = new MailAccount();
    mailAccount.setHost(smtpEmailProperties.getHost());
    mailAccount.setPort(smtpEmailProperties.getPort());
    mailAccount.setAuth(smtpEmailProperties.getAuth());
    mailAccount.setUser(smtpEmailProperties.getUser());
    mailAccount.setPass(smtpEmailProperties.getPass());
    mailAccount.setFrom(smtpEmailProperties.getFrom());
    mailAccount.setStarttlsEnable(smtpEmailProperties.getStarttlsEnable());
    mailAccount.setSslEnable(smtpEmailProperties.getSslEnable());
    mailAccount.setSocketFactoryPort(smtpEmailProperties.getSocketFactoryPort());
    mailAccount.setTimeout(smtpEmailProperties.getTimeout());
    mailAccount.setConnectionTimeout(smtpEmailProperties.getConnectionTimeout());
  }

  /** 校验发送邮件的请求参数 */
  private void assertSendMailParams(SmtpSendMailParam sendMailParam) {
    if (sendMailParam == null) {
      String format = StrUtil.format(EmailExceptionEnum.EMAIL_PARAM_EMPTY_ERROR.getUserTip(), "");
      throw new MailException(format);
    }

    if (ObjectUtil.isEmpty(sendMailParam.getTos())) {
      String format =
          StrUtil.format(EmailExceptionEnum.EMAIL_PARAM_EMPTY_ERROR.getUserTip(), "收件人邮箱");
      throw new MailException(format);
    }

    if (ObjectUtil.isEmpty(sendMailParam.getTitle())) {
      String format =
          StrUtil.format(EmailExceptionEnum.EMAIL_PARAM_EMPTY_ERROR.getUserTip(), "邮件标题");
      throw new MailException(format);
    }

    if (ObjectUtil.isEmpty(sendMailParam.getContent())) {
      String format =
          StrUtil.format(EmailExceptionEnum.EMAIL_PARAM_EMPTY_ERROR.getUserTip(), "邮件内容");
      throw new MailException(format);
    }
  }
}
