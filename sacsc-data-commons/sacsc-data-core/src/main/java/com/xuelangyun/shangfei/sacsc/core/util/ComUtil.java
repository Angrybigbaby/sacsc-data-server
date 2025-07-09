package com.xuelangyun.shangfei.sacsc.core.util;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/** Create by huaying.ll on 2020/8/22 */
@Slf4j
public class ComUtil {
  public static final Splitter SPLITTER = Splitter.on(",").omitEmptyStrings().trimResults();
  public static final Splitter SPLITTER1 = Splitter.on("-").omitEmptyStrings().trimResults();

  public static final Joiner JOINER = Joiner.on(",").skipNulls();

  private static ThreadLocal<DateFormat> threadLocal =
      new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
          return new SimpleDateFormat("yyyy-MM");
        }
      };

  public static int compareStrDate(String statDate, String statDate1) {
    // return LocalDate.from(sdf.parse(statDate)).compareTo(LocalDate.from(sdf.parse(statDate1)));
    // return LocalDate.parse(statDate, sdf).compareTo(LocalDate.parse(statDate1, sdf));
    try {
      return threadLocal.get().parse(statDate).compareTo(threadLocal.get().parse(statDate1));
    } catch (ParseException e) {
      log.error("compareStrDate error: {}", Throwables.getStackTraceAsString(e));
    }
    return 1;
  }

  public static double add(double v1, double v2) {
    BigDecimal b1 = new BigDecimal(Double.toString(v1));
    BigDecimal b2 = new BigDecimal(Double.toString(v2));
    return b1.add(b2).doubleValue();
  }
}
