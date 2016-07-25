package com.softright.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateSystem{
	/*********
	 * date1.compareTo(date2) == 0相同，
-1 date1<date2
1 data1>date2
	 */
  public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E 当年中的第D天   当年中第w个星期  当月中第W个星期  a k时  时区：z");
  private static Calendar cal = Calendar.getInstance();

  public static String getDate_WZ()
  {
    return format.format(new Date());
  }

  public static String getDate_sj()
  {
    return "[" + format.format(new Date()).substring(0, 19) + "]:";
  }

  public static String getDate()
  {
    return format.format(new Date()).substring(0, 19);
  }

  public static String getDate_YMD()
  {
    return format.format(new Date()).substring(0, 10);
  }

  public static String dateToString_YMD(Date date)
  {
    return format.format(date).substring(0, 10);
  }

  public static String dateToString(Date date)
  {
    return format.format(date).substring(0, 19);
  }

  public static Date stringToDate(String stringdate)
  {
    SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date da = null;
    try {
      da = spf.parse(stringdate);
    }
    catch (ParseException e) {
      e.printStackTrace();
    }
    return da;
  }

  public static Date stringToDate_YMD(String stringdate_ymd)
  {
    SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
    Date da = null;
    try {
      da = spf.parse(stringdate_ymd);
    }
    catch (ParseException e) {
      e.printStackTrace();
    }
    return da;
  }

  public static Date dateToDate_YMD(Date date_ymd)
  {
    SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd");
    Date da = null;
    try {
      da = spf.parse(dateToString(date_ymd));
    }
    catch (ParseException e) {
      e.printStackTrace();
    }
    return da;
  }

  public static int getDateDifference_INT(Date start, Date end)
  {
    long between = (end.getTime() - start.getTime()) / 1000L;
    return Integer.parseInt(String.valueOf(between));
  }

  public static String getDateDifference_String(Date start, Date end)
  {
    long between = (end.getTime() - start.getTime()) / 1000L;
    long day1 = between / 86400L;
    long hour1 = between % 86400L / 3600L;
    long minute1 = between % 3600L / 60L;
    long second1 = between % 60L / 60L;
    return day1 + "天" + hour1 + "小时" + minute1 + "分" + second1 + "秒";
  }

  public static String getDateDifference_String(String start, String end)
  {
    String datestr = "";
    try {
      Date startDate = format.parse(start);
      Date endDate = format.parse(end);
      long between = (endDate.getTime() - startDate.getTime()) / 1000L;
      long day1 = between / 86400L;
      long hour1 = between % 86400L / 3600L;
      long minute1 = between % 3600L / 60L;
      long second1 = between % 60L / 60L;
      datestr = day1 + "天" + hour1 + "小时" + minute1 + "分" + second1 + "秒";
    }
    catch (ParseException e) {
      throw new RuntimeException("时间计算错误:", e);
    }
    Date endDate;
    Date startDate;
    return datestr;
  }

  public static boolean getPIsW(Date newdate)
  {
    boolean fag = false;
    int year = Integer.parseInt(format.format(newdate).substring(0, 4));
    if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
      fag = true;
    }
    return fag;
  }

  public static boolean getPIsW(Integer year)
  {
    getVYear(year);
    boolean fag = false;
    if ((year.intValue() % 400 == 0) || ((year.intValue() % 4 == 0) && (year.intValue() % 100 != 0))) {
      fag = true;
    }
    return fag;
  }

  public static boolean getPIsW()
  {
    return getPIsW(new Date());
  }

  public static Integer getYear()
  {
    return Integer.valueOf(cal.get(1));
  }

  public static Integer getMonth()
  {
    return Integer.valueOf(cal.get(2) + 1);
  }

  public static Integer getDay()
  {
    return Integer.valueOf(cal.getActualMaximum(5));
  }

  public static Integer getDay(Integer month)
  {
    getVMonth(month);
    cal.set(getYear().intValue(), month.intValue(), 0);
    return Integer.valueOf(cal.getActualMaximum(5));
  }

  public static Integer getDay(Integer year, Integer month)
  {
    getVYear(year);
    getVMonth(month);
    cal.set(year.intValue(), month.intValue(), 0);
    return Integer.valueOf(cal.getActualMaximum(5));
  }

  public static Integer getDayCurrent()
  {
    return Integer.valueOf(Integer.parseInt(format.format(new Date()).substring(8, 10)));
  }

  public static String getWeek()
  {
    return format.format(new Date()).substring(20, 23);
  }

  public static String getWeek(Integer year, Integer month, Integer day)
  {
    getVYear(year);
    getVMonth(month);
    Integer _day = getDay(year, month);
    if (_day.intValue() < day.intValue()) {
      throw new RuntimeException("天数输入不合法:" + day);
    }

    cal.set(year.intValue(), month.intValue() - 1, day.intValue());
    return format.format(cal.getTime()).substring(20, 23);
  }

  public static void getVYear(Integer year)
  {
    if ((year == null) || (year.intValue() <= 0) || (year.toString().length() > 4) || (year.toString().length() < 4))
      throw new RuntimeException("年份输入不合法:" + year);
  }

  public static void getVMonth(Integer month)
  {
    if ((month == null) || (month.intValue() <= 0) || (month.intValue() > 12))
      throw new RuntimeException("月份输入不合法:" + month);
  }

  public static void getVDay(Integer day)
  {
    if ((day == null) || (day.intValue() <= 0) || (day.intValue() > 31))
      throw new RuntimeException("天数输入不合法:" + day);
  }
}