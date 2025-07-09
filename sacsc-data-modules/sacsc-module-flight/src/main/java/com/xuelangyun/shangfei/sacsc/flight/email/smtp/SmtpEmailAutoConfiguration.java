package com.xuelangyun.shangfei.sacsc.flight.email.smtp;

import com.xuelangyun.shangfei.sacsc.flight.email.EmailConstants;
import com.xuelangyun.shangfei.sacsc.flight.email.EmailSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mochen.qy
 * @date 2023/5/9 11:37
 */
@Configuration
@EnableConfigurationProperties({SmtpEmailProperties.class})
@ConditionalOnProperty(prefix = EmailConstants.SMTP_PROPERTY_PREFIX, name = "host")
public class SmtpEmailAutoConfiguration {

  @Bean(initMethod = "initMailAccount")
  public EmailSender<SmtpSendMailParam> smtpEmailSender(SmtpEmailProperties smtpEmailProperties) {
    return new SmtpEmailSender(smtpEmailProperties);
  }
}
