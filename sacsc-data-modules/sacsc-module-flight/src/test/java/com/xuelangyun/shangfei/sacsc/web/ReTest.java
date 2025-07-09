package com.xuelangyun.shangfei.sacsc.web;

import cn.hutool.core.util.ReUtil;
import java.util.regex.MatchResult;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author zijian.qjd
 * @since 2023/7/7 14:49
 */
public class ReTest {

  @Test
  public void flightNoTest() {
    final String flightNo = "EU2501";
    final MatchResult matchResult = ReUtil.lastIndexOf("[a-zA-Z]", flightNo);
    if (null != matchResult) {
      System.out.println(StringUtils.substring(flightNo, matchResult.end()));
      System.out.println(StringUtils.substring(flightNo, 0, matchResult.end()));
    }
  }
}
