package com.za.common.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;

/**
 * 已测试
 * 
 * @author SP2.0
 */
public class HLDateTimeUtils {

    /**
     * DateTime转Date
     * 
     * @param dateTime
     * @return
     */
    public static Date toDate(DateTime dateTime) {
        return dateTime == null ? null : dateTime.toDate();
    }

    /**
     * DateTime转Calendar
     * 
     * @param dateTime
     * @return
     */
    public static Calendar toCalendar(DateTime dateTime) {
        return dateTime == null ? null : dateTime.toCalendar(Locale.getDefault());
    }

    /**
     * Calendar转DateTime
     * 
     * @param c
     * @return
     */
    public static DateTime toDateTime(Calendar cal) {
        return cal == null ? null : new DateTime(cal);
    }

    /**
     * Date转DateTime
     * 
     * @param date
     * @return
     */
    public static DateTime toDateTime(Date date) {
        return date == null ? null : new DateTime(date);
    }

    /**
     * 字符串转日期
     * 
     * @param time
     * @param format
     * @see DateFormatTemplate
     * @return
     */
    public static DateTime parse(String time, String format) {
        if (StringUtils.isBlank(time)) {
            return null;
        }
        return DateTime.parse(time, DateTimeFormat.forPattern(format));
    }

    /**
     * 字符串转日期(yyyy-MM-dd)
     * 
     * @param time
     * @return
     */
    public static DateTime parseDateDefault(String time) {
        return parse(time, DateFormatTemplate.DATE_FORMAT_DEFAULT);
    }

    /**
     * 字符串转日期(yyyy-MM-dd HH:mm:ss)
     * 
     * @param time
     * @return
     */
    public static DateTime parseDateTimeDefault(String time) {
        return parse(time, DateFormatTemplate.DATE_TIME_FORMAT_DEFAULT);
    }

    /**
     * 字符串转日期(yyyy-MM-dd'T'HH:mm:ss.SSSZ)
     * 
     * @param time
     * @return
     */
    public static DateTime parseDateTimeISO8601(String time) {
        return parse(time, DateFormatTemplate.DATE_TIME_FORMAT_ISO8601);
    }

    /**
     * 日期转字符串
     * 
     * @param dateTime
     * @param format
     * @return
     */
    public static String format(DateTime dateTime, String format) {
        if (dateTime == null) {
            return "";
        }
        return dateTime.toString(format);
    }

    /**
     * 日期转字符串(yyyy-MM-dd)
     * 
     * @param dateTime
     * @return
     */
    public static String formatDateDefault(DateTime dateTime) {
        return format(dateTime, DateFormatTemplate.DATE_FORMAT_DEFAULT);
    }

    /**
     * 日期转字符串(yyyy-MM-dd HH:mm:ss)
     * 
     * @param dateTime
     * @return
     */
    public static String formatDateTimeDefault(DateTime dateTime) {
        return format(dateTime, DateFormatTemplate.DATE_TIME_FORMAT_DEFAULT);
    }

    /**
     * 日期转字符串(yyyy-MM-dd'T'HH:mm:ss.SSSZ)
     * 
     * @param dateTime
     * @return
     */
    public static String formatDateTimeISO8601(DateTime dateTime) {
        return format(dateTime, DateFormatTemplate.DATE_TIME_FORMAT_ISO8601);
    }

    /**
     * 两个日期之间相差的年数 2015-01-01和2016-01-01 相差1年 2015-01-01和2015-12-31 相差0年
     * 
     * @param startTime
     * @param endTime
     * @return
     */
    public static int durationYear(DateTime startTime, DateTime endTime) {
        return durationByType(startTime, endTime, DateFieldType.YEAR);
    }

    /**
     * 两个日期之间相差的月数 2015-01-01和2015-01-31 相差0月 2015-01-01和2015-02-01 相差1月
     * 2015-01-01和2016-02-01 相差13月
     * 
     * @param startTime
     * @param endTime
     * @return
     */
    public static int durationMonth(DateTime startTime, DateTime endTime) {
        return durationByType(startTime, endTime, DateFieldType.MONTH);
    }

    /**
     * 两个日期之间相差的天数 2015-01-01和2015-01-01 相差0天 2015-01-01和2015-01-02 相差1天
     * 2015-01-01和2016-02-01 相差31天
     * 
     * @param startTime
     * @param endTime
     * @return
     */
    public static int durationDay(DateTime startTime, DateTime endTime) {
        return durationByType(startTime, endTime, DateFieldType.DAY);
    }

    /**
     * 两个日期之间相差的小时数 2015-01-01 01:02:03和2015-01-01 02:02:02 相差0小时 2015-01-01
     * 01:02:03和2015-01-01 02:02:03 相差1小时
     * 
     * @param startTime
     * @param endTime
     * @return
     */
    public static int durationHour(DateTime startTime, DateTime endTime) {
        return durationByType(startTime, endTime, DateFieldType.HOUR);
    }

    /**
     * 两个日期之间相差的分钟数 2015-01-01 01:02:03和2015-01-01 01:03:02 相差0分钟 2015-01-01
     * 01:02:03和2015-01-01 01:03:03 相差1分钟
     * 
     * @param startTime
     * @param endTime
     * @return
     */
    public static int durationMinute(DateTime startTime, DateTime endTime) {
        return durationByType(startTime, endTime, DateFieldType.MINUTE);
    }

    /**
     * 两个日期之间相差的秒数 2015-01-01 01:02:03和2015-01-01 01:02:03 相差0秒 2015-01-01
     * 01:02:03和2015-01-01 01:02:04 相差1秒
     * 
     * @param startTime
     * @param endTime
     * @return
     */
    public static int durationSecond(DateTime startTime, DateTime endTime) {
        return durationByType(startTime, endTime, DateFieldType.SECOND);
    }

    /**
     * 根据fieldtype获得两个日期之间的相差数值
     * 
     * @param startTime
     * @param endTime
     * @param fieldType
     * @return
     */
    public static int durationByType(DateTime startTime, DateTime endTime, DateFieldType fieldType) {
        Period period = null;
        if (DateFieldType.YEAR.equals(fieldType)) {
            period = new Period(startTime, endTime, PeriodType.years());
            return period.getYears();
        } else if (DateFieldType.MONTH.equals(fieldType)) {
            period = new Period(startTime, endTime, PeriodType.months());
            return period.getMonths();
        } else if (DateFieldType.DAY.equals(fieldType)) {
            period = new Period(startTime, endTime, PeriodType.days());
            return period.getDays();
        } else if (DateFieldType.HOUR.equals(fieldType)) {
            period = new Period(startTime, endTime, PeriodType.hours());
            return period.getHours();
        } else if (DateFieldType.MINUTE.equals(fieldType)) {
            period = new Period(startTime, endTime, PeriodType.minutes());
            return period.getMinutes();
        } else if (DateFieldType.SECOND.equals(fieldType)) {
            period = new Period(startTime, endTime, PeriodType.seconds());
            return period.getSeconds();
        }
        return 0;
    }

    /**
     * 日期加秒
     * 
     * @param dateTime
     * @param num
     * @return
     */
    public static DateTime addSeconds(DateTime dateTime, int num) {
        return plusNumToTime(dateTime, num, DateFieldType.SECOND);
    }

    /**
     * 日期加分
     * 
     * @param dateTime
     * @param num
     * @return
     */
    public static DateTime addMinutes(DateTime dateTime, int num) {
        return plusNumToTime(dateTime, num, DateFieldType.MINUTE);
    }

    /**
     * 日期加小时
     * 
     * @param dateTime
     * @param num
     * @return
     */
    public static DateTime addHours(DateTime dateTime, int num) {
        return plusNumToTime(dateTime, num, DateFieldType.HOUR);
    }

    /**
     * 日期加天
     * 
     * @param dateTime
     * @param num
     * @return
     */
    public static DateTime addDays(DateTime dateTime, int num) {
        return plusNumToTime(dateTime, num, DateFieldType.DAY);
    }

    /**
     * 日期加月
     * 
     * @param dateTime
     * @param num
     * @return
     */
    public static DateTime addMonths(DateTime dateTime, int num) {
        return plusNumToTime(dateTime, num, DateFieldType.MONTH);
    }

    /**
     * 日期加年
     * 
     * @param dateTime
     * @param num
     * @return
     */
    public static DateTime addYears(DateTime dateTime, int num) {
        return plusNumToTime(dateTime, num, DateFieldType.YEAR);
    }

    /**
     * 根据num和fieldType操作原时间
     * 
     * @param dateTime
     * @param num
     * @param fieldType
     * @return
     */
    public static DateTime plusNumToTime(DateTime dateTime, int num, DateFieldType fieldType) {
        if (dateTime == null) {
            return null;
        }
        if (DateFieldType.YEAR.equals(fieldType)) {
            return dateTime.plusYears(num);
        } else if (DateFieldType.MONTH.equals(fieldType)) {
            return dateTime.plusMonths(num);
        } else if (DateFieldType.DAY.equals(fieldType)) {
            return dateTime.plusDays(num);
        } else if (DateFieldType.HOUR.equals(fieldType)) {
            return dateTime.plusHours(num);
        } else if (DateFieldType.MINUTE.equals(fieldType)) {
            return dateTime.plusMinutes(num);
        } else if (DateFieldType.SECOND.equals(fieldType)) {
            return dateTime.plusSeconds(num);
        }
        return dateTime;
    }

    public static DateTime minusNumToTime(DateTime dateTime, int num, DateFieldType fieldType) {
        if (dateTime == null) {
            return null;
        }
        if (DateFieldType.YEAR.equals(fieldType)) {
            return dateTime.minusYears(num);
        } else if (DateFieldType.MONTH.equals(fieldType)) {
            return dateTime.minusMonths(num);
        } else if (DateFieldType.DAY.equals(fieldType)) {
            return dateTime.minusDays(num);
        } else if (DateFieldType.HOUR.equals(fieldType)) {
            return dateTime.minusHours(num);
        } else if (DateFieldType.MINUTE.equals(fieldType)) {
            return dateTime.minusMinutes(num);
        } else if (DateFieldType.SECOND.equals(fieldType)) {
            return dateTime.minusSeconds(num);
        }
        return dateTime;
    }
}

enum DateFieldType {

    YEAR,
    MONTH,
    DAY,
    HOUR,
    MINUTE,
    SECOND;
}
