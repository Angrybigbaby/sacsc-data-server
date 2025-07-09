package com.xuelangyun.shangfei.sacsc.flight.email.smtp;

import com.xuelangyun.shangfei.sacsc.flight.email.EmailConstants;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author mochen.qy
 * @date 2023/5/9 11:37
 */
@Data
@ConfigurationProperties(prefix = EmailConstants.SMTP_PROPERTY_PREFIX)
public class SmtpEmailProperties {
  private String host;
  /** SMTP服务端口 */
  private Integer port = 25;
  /** 是否需要用户名密码验证 */
  private Boolean auth = true;
  /** 用户名 */
  private String user;
  /** 密码 */
  private String pass;
  /** 发送方，遵循RFC-822标准 */
  private String from;

  /** 是否打开调试模式，调试模式会显示与邮件服务器通信过程，默认不开启 */
  private boolean debug = false;
  /** 对于超长参数是否切分为多份，默认为false（国内邮箱附件不支持切分的附件名） */
  private boolean splitlongparameters = false;
  /** 对于文件名是否使用{@link #charset}编码，默认为 {@code true} */
  private boolean encodefilename = true;

  /** 使用 STARTTLS安全连接，STARTTLS是对纯文本通信协议的扩展。它将纯文本连接升级为加密连接（TLS或SSL）， 而不是使用一个单独的加密通信端口。 */
  private Boolean starttlsEnable = false;
  /** 使用 SSL安全连接 */
  private Boolean sslEnable;

  /** SSL协议，多个协议用空格分隔 */
  private String sslProtocols;

  /** 指定实现javax.net.SocketFactory接口的类的名称,这个类将被用于创建SMTP的套接字 */
  private String socketFactoryClass = "javax.net.ssl.SSLSocketFactory";
  /** 如果设置为true,未能创建一个套接字使用指定的套接字工厂类将导致使用java.net.Socket创建的套接字类, 默认值为true */
  private boolean socketFactoryFallback;
  /** 指定的端口连接到在使用指定的套接字工厂。如果没有设置,将使用默认端口 */
  private int socketFactoryPort = 465;

  /** SMTP超时时长，单位毫秒，缺省值不超时 */
  private long timeout;
  /** Socket连接超时值，单位毫秒，缺省值不超时 */
  private long connectionTimeout;
}
