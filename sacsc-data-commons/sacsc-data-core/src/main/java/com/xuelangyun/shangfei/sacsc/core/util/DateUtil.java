package com.xuelangyun.shangfei.sacsc.core.util;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/** @Auther: futang.tyf @Date: 2018/8/9 14:43 @Description: */
@Slf4j
public class DateUtil {

  public static Date timeZoneTransfer(
      Date date, String pattern, String nowTimeZone, String targetTimeZone, String targetPattern) {
    if (date == null) {
      return null;
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String format = simpleDateFormat.format(date);
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT" + nowTimeZone));
    try {
      date = simpleDateFormat.parse(format);
      simpleDateFormat = new SimpleDateFormat(targetPattern);
      simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT" + targetTimeZone));
      format = simpleDateFormat.format(date);
      date = simpleDateFormat.parse(format);
    } catch (ParseException e) {
      log.error("时间转换出错。", e);
      return null;
    }
    return date;
  }

  public static String getFormatDates(String det, String dateFormat) {
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    Date date = null;
    try {
      date = sdf.parse(det);
    } catch (ParseException e) {
      log.error("getFormatDates error: {}", Throwables.getStackTraceAsString(e));
    }
    return sdf.format(date);
  }

  public static String getFormatDates(Long det, String dateFormat) {
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    Date date = new Date(det);
    return sdf.format(date);
  }

  public static Long dateToLong(String strTime) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    Date date = null;
    try {
      date = sdf.parse(strTime);
    } catch (ParseException e) {
      sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      try {
        date = sdf.parse(strTime);
      } catch (ParseException e1) {
        log.error("时间转换错误", e1);
        return null;
      }
    }
    return date.getTime();
  }

  /**
   * 得到当前的时间，时间格式yyyyMMddHHmmss
   *
   * @return
   */
  public static String getCurrentDatetime() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    return sdf.format(new Date());
  }

  /**
   * 得到当前的时间，时间格式yyyyMMdd
   *
   * @return
   */
  public static String getCurrentDate2() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    return sdf.format(new Date());
  }

  /**
   * 得到当前的时间，时间格式yyyy-MM-dd
   *
   * @return
   */
  public static String getCurrentDate() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.format(new Date());
  }

  /**
   * 得到当前的时间，时间格式yyyy-MM-dd
   *
   * @return
   */
  public static String getSystemCurrentDate() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return sdf.format(new Date());
  }

  /**
   * 得到当前的时间,自定义时间格式 y 年 M 月 d 日 H 时 m 分 s 秒
   *
   * @param dateFormat 输出显示的时间格式
   * @return
   */
  public static String getCurrentDate(String dateFormat) {
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    return sdf.format(new Date());
  }

  /**
   * 日期格式化，默认日期格式yyyy-MM-dd
   *
   * @param date
   * @return
   */
  public static String getFormatDate(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.format(date);
  }

  /**
   * 日期格式化，自定义输出日期格式
   *
   * @param date
   * @return
   */
  public static String getFormatDate(Date date, String dateFormat) {
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
    return sdf.format(date);
  }

  /**
   * 返回当前日期的 想个的某一时刻的时间，amount为正数 当前时间后的时间， 为负数 当前时间前的时间
   *
   * @param d ,某一个日期
   * @param field 日历字段 y 年 M 月 d 日 H 时 m 分 s 秒
   * @param amount 数量
   * @param format 日期格式
   * @return 一个日期
   */
  public static String getPreDate(Date d, String field, int amount, String format) {
    Date date = getPerDate(d, field, amount);
    if (date == null) {
      return null;
    }
    return getFormatDate(getPerDate(d, field, amount), format);
  }

  /**
   * 返回当前日期的 想个的某一时刻的时间，amount为正数 当前时间后的时间， 为负数 当前时间前的时间
   *
   * @param d ,某一个日期
   * @param field 日历字段 y 年 M 月 d 日 H 时 m 分 s 秒
   * @param amount 数量
   * @return 一个日期
   */
  public static Date getPerDate(Date d, String field, int amount) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(d);
    if (StringUtils.isNotBlank(field)) {
      if ("y".equals(field)) {
        calendar.add(Calendar.YEAR, amount);
      } else if ("M".equals(field)) {
        calendar.add(Calendar.MONTH, amount);
      } else if ("d".equals(field)) {
        calendar.add(Calendar.DAY_OF_MONTH, amount);
      } else if ("H".equals(field)) {
        calendar.add(Calendar.HOUR, amount);
      } else if ("m".equals(field)) {
        calendar.add(Calendar.MINUTE, amount);
      } else if ("s".equals(field)) {
        calendar.add(Calendar.SECOND, amount);
      }
    } else {
      return null;
    }
    return calendar.getTime();
  }

  /**
   * 某一个日期的前一个日期
   *
   * @param d ,某一个日期
   * @param field 日历字段 y 年 M 月 d 日
   * @param amount 数量
   * @return 一个日期
   */
  public static String getSevenPreDate(Date d, String field, int amount) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(d);
    if (StringUtils.isNotBlank(field)) {
      if ("y".equals(field)) {
        calendar.add(Calendar.YEAR, amount);
      } else if ("M".equals(field)) {
        calendar.add(Calendar.MONTH, amount);
      } else if ("d".equals(field)) {
        calendar.add(Calendar.DAY_OF_MONTH, amount);
      } else if ("H".equals(field)) {
        calendar.add(Calendar.HOUR, amount);
      } else if ("m".equals(field)) {
        calendar.add(Calendar.MINUTE, amount);
      }
    } else {
      return null;
    }
    return getFormatDate(calendar.getTime(), "yyyyMMdd");
  }

  /**
   * 某当前时间的前七天时间
   *
   * @return
   * @throws ParseException
   */
  public static String getSevenBeforeCurrent() throws ParseException {
    Date d = new Date();
    String preD = getSevenPreDate(d, "d", -6);
    Date preDate = new SimpleDateFormat("yyyyMMdd").parse(preD);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    return sdf.format(preDate);
  }

  /**
   * 将符合格式的时间字符串转换成Date
   *
   * @param str
   * @return Date
   */
  public static Date StrToDate(String str, String sformat) {
    SimpleDateFormat format = new SimpleDateFormat(sformat);
    Date date = null;
    try {
      date = format.parse(str);
    } catch (ParseException e) {
      log.error("StrToDate error: {}", Throwables.getStackTraceAsString(e));
    }
    return date;
  }

  /**
   * 将String型格式化,比如想要将2011-11-11格式化成2011年11月11日,就StringPattern("2011-11-11",
   * "yyyy-MM-dd","yyyy年MM月dd日").
   *
   * @param date String 想要格式化的日期
   * @param oldPattern String 想要格式化的日期的现有格式
   * @param newPattern String 想要格式化成什么格式
   * @return String
   */
  public static String StrToFormatDataStr(String date, String oldPattern, String newPattern) {
    if (StringUtils.isAnyEmpty(date, oldPattern, newPattern)) {
      return StringUtils.EMPTY;
    }
    try {
      SimpleDateFormat sdf1 = new SimpleDateFormat(oldPattern);
      SimpleDateFormat sdf2 = new SimpleDateFormat(newPattern);
      return sdf2.format(sdf1.parse(date));
    } catch (Exception e) {
      log.error("StrToFormatDataStr error: {}", Throwables.getStackTraceAsString(e));
      return StringUtils.EMPTY;
    }
  }

  /**
   * 两个日期相减
   *
   * @return int
   */
  public static int dateSub(Date date1, Date date2) {
    int days = 0;
    days = (int) Math.abs((date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000)) + 1;
    return days;
  }

  public static int dateSub2(Date date1, Date date2) {
    int days = 0;
    days = (int) ((date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000));
    return days;
  }

  public static BigDecimal dateSub2Hour(Date date1, Date date2) {
    return BigDecimal.valueOf((double) (date2.getTime() - date1.getTime()) / (1000 * 60 * 60))
        .setScale(1, RoundingMode.HALF_UP);
  }

  /**
   * 对传入的日期进行转换，对于形如"2013-5-10"的日期转换为"2013-05-10"
   *
   * @param paramDate 要进行格式转换的日期
   * @return 转换后的日期字符串
   */
  public static String formatDate(String paramDate) {
    String yearStr = paramDate.substring(0, paramDate.indexOf("-"));
    String monthStr = paramDate.substring(paramDate.indexOf("-") + 1, paramDate.lastIndexOf("-"));
    String dateStr = paramDate.substring(paramDate.lastIndexOf("-") + 1);
    int month = Integer.parseInt(monthStr);
    int date = Integer.parseInt(dateStr);
    if (month < 10) {
      monthStr = "0" + month;
    }
    if (date < 10) {
      dateStr = "0" + date;
    }
    String newDate = yearStr + "-" + monthStr + "-" + dateStr;
    return newDate;
  }

  /**
   * 转换时间显示格式
   *
   * @param time yyyyMMddHHmmss
   * @return String yyyy年MM月-日
   */
  public static String showZHtime(String time) throws ParseException {
    SimpleDateFormat dfs = new SimpleDateFormat("yyyyMMddHHmmss");
    Date date = dfs.parse(time);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int year;
    int month;
    int day;
    String dateBuf;
    year = calendar.get(Calendar.YEAR);
    month = calendar.get(Calendar.MONTH);
    day = calendar.get(Calendar.DAY_OF_MONTH);
    dateBuf =
        year
            + "年"
            + (month < 10 ? "0" + (month + 1) : (month + 1))
            + "月"
            + (day < 10 ? "0" + day : day)
            + "日";
    return dateBuf;
  }

  /**
   * 获取当前月第一天的日期
   *
   * @return
   */
  public static Date getMonthStart() {
    Calendar calendar = Calendar.getInstance();
    int month = calendar.get(Calendar.MONTH);
    return getMonthStart(month + 1);
  }

  /**
   * 获取当前月最后一天的日期
   *
   * @return
   */
  public static Date getMonthEnd() {
    Calendar calendar = Calendar.getInstance();
    int month = calendar.get(Calendar.MONTH);
    return getMonthEnd(month + 1);
  }

  /**
   * 获取当前月最后一天是几号
   *
   * @return
   */
  public static Integer getMonthEndDay() {
    Calendar calendar = Calendar.getInstance();
    return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
  }
  //
  //    public static void main(String[] args) {
  //
  //        System.out.print(getFormatDate(getMonthStart(),"yyyy-MM-dd HH:mm:ss.SSS"));
  //        System.out.print(" | ");
  //        System.out.print(getFormatDate(getMonthEnd(),"yyyy-MM-dd HH:mm:ss.SSS"));
  //        System.out.print(" | ");
  //        System.out.println(getMonthEndDay());
  //        for(int i= 1; i<=12 ; i++){
  //            System.out.print(getFormatDate(getMonthStart(i),"yyyy-MM-dd HH:mm:ss.SSS"));
  //            System.out.print(" | ");
  //            System.out.print(getFormatDate(getMonthEnd(i),"yyyy-MM-dd HH:mm:ss.SSS"));
  //            System.out.print(" | ");
  //            System.out.println(getMonthEndDay(i));
  //        }
  //
  //    }

  /**
   * 获取某个月第一天的日期
   *
   * @param month
   * @return
   */
  public static Date getMonthStart(int month) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, month - 1);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }

  /**
   * 获取某个月最后一天的日期
   *
   * @param month
   * @return
   */
  public static Date getMonthEnd(int month) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, month - 1);
    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 999);
    return calendar.getTime();
  }

  /**
   * 获取某个月最后一天是几号
   *
   * @param month
   * @return
   */
  public static Integer getMonthEndDay(int month) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, month - 1);
    return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
  }

  /**
   * 判断指定时间和当前时间差值是否超出指定时间范围
   *
   * @param timestamp 指定时间，毫秒
   * @param hours 时间范围，小时
   * @return
   */
  public static boolean isOutOfDate(long timestamp, int hours) {
    Date date = new Date();
    return date.getTime() - timestamp > hours * 60 * 60 * 1000;
  }

  /**
   * 今天开始时间
   *
   * @return
   */
  public static Date getTodayStart() {
    Calendar todayStart = Calendar.getInstance();
    todayStart.set(Calendar.HOUR_OF_DAY, 0);
    todayStart.set(Calendar.MINUTE, 0);
    todayStart.set(Calendar.SECOND, 0);
    todayStart.set(Calendar.MILLISECOND, 0);
    return todayStart.getTime();
  }
  /**
   * 今天开始时间
   *
   * @return
   */
  public static Date getTodayStart(Date date) {
    Calendar todayStart = Calendar.getInstance();
    todayStart.setTime(date);
    todayStart.set(Calendar.HOUR_OF_DAY, 0);
    todayStart.set(Calendar.MINUTE, 0);
    todayStart.set(Calendar.SECOND, 0);
    todayStart.set(Calendar.MILLISECOND, 0);
    return todayStart.getTime();
  }
  /**
   * 今天开始时间
   *
   * @return
   */
  public static Date getTodayEnd(Date date) {
    Calendar todayEnd = Calendar.getInstance();
    todayEnd.setTime(date);
    todayEnd.set(Calendar.HOUR_OF_DAY, 23);
    todayEnd.set(Calendar.MINUTE, 59);
    todayEnd.set(Calendar.SECOND, 59);
    todayEnd.set(Calendar.MILLISECOND, 999);
    return todayEnd.getTime();
  }
  /**
   * 今天开始时间
   *
   * @return
   */
  public static Date getTodayEnd() {
    Calendar todayEnd = Calendar.getInstance();
    todayEnd.set(Calendar.HOUR_OF_DAY, 23);
    todayEnd.set(Calendar.MINUTE, 59);
    todayEnd.set(Calendar.SECOND, 59);
    todayEnd.set(Calendar.MILLISECOND, 999);
    return todayEnd.getTime();
  }

  public static Long getTime(Date planTakeoffTime, int i) {
    long time = planTakeoffTime.getTime();
    return time / i;
  }

  /**
   * 获取当天零点的日期
   *
   * @return
   */
  public static Date getCurrentDate0() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    Date zero = calendar.getTime();
    return zero;
  }

  /**
   * 获取某天的指定时刻
   *
   * @param date -
   * @param hour -
   * @param minute -
   * @param second -
   * @return -
   */
  public static Date getAssignDate(Date date, Integer hour, Integer minute, Integer second) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, hour);
    calendar.set(Calendar.MINUTE, minute);
    calendar.set(Calendar.SECOND, second);
    return calendar.getTime();
  }

  /**
   * 根据指定的年月日时分秒返回时间
   *
   * @param year -
   * @param month - 注意是从0开始的
   * @param day -
   * @param hour -
   * @param minute -
   * @param second -
   * @return -
   */
  public static Date getAssignTime(
      Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer second) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month);
    calendar.set(Calendar.DAY_OF_MONTH, day);
    calendar.set(Calendar.HOUR_OF_DAY, hour);
    calendar.set(Calendar.MINUTE, minute);
    calendar.set(Calendar.SECOND, second);
    return calendar.getTime();
  }

  public static Date subDay(Date beginDate, Integer day) {
    SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Calendar date = Calendar.getInstance();
    date.setTime(beginDate);
    date.set(Calendar.DATE, date.get(Calendar.DATE) - day);
    try {
      return dft.parse(dft.format(date.getTime()));
    } catch (ParseException e) {
      log.error("计算前n天时间错误: {}", ExceptionUtils.getStackTrace(e));
    }
    return null;
  }

  public static Date addSeconds(final Date date, final int amount) {

    final Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(Calendar.SECOND, amount);
    return c.getTime();
  }


  public static Date addMinutes(final Date date, final int amount) {

    final Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(Calendar.MINUTE, amount);
    return c.getTime();
  }

  public static Date addYear(final Date date, final int amount) {
    final Calendar c = Calendar.getInstance();
    c.setTime(date);
    c.add(Calendar.YEAR, amount);
    return c.getTime();
  }

  public static void main(String[] args) {
    String date = "2022-06-25 00:00:00";
    int i =
        DateUtil.dateSub2(
            DateUtil.StrToDate(date, "yyyy-MM-dd"),
            DateUtil.StrToDate(DateUtil.getCurrentDate("yyyy-MM-dd"), "yyyy-MM-dd"));
    System.out.println(i);
  }
}
