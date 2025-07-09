package com.xuelangyun.shangfei.sacsc.flight.email.smtp;

import com.xuelangyun.shangfei.sacsc.flight.email.SendEmailParam;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author mochen.qy
 * @date 2023/5/9 10:32
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SmtpSendMailParam extends SendEmailParam {

  /** 收件人列表 */
  private List<String> tos;

  /** 抄送人列表,可以为null或空 */
  private List<String> ccsTos;

  /** 密送人列表,可以为null或空 */
  private List<String> bccsTos;

  /** 附件列表 */
  private File[] files;

  /**
   * 图片与占位符，占位符格式为cid:${cid}
   *
   * <p>注意:只有发送html邮件，图片才可正常显示 如:测试图片1:<img src='cid:image01'>
   */
  private Map<String, InputStream> imageMap;
}
