package com.github.weichun97.common.utils;

import org.springframework.lang.NonNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author chun
 * @date 2020/9/12
 * @description 日期操作类
 */
public class DateUtil extends cn.hutool.core.date.DateUtil {

    /**
     * @return 返回短时间格式 yyyy-MM-dd
     */
    public static String getNowNumberDate() {
        return formatDate(new Date(), "yyyyMMdd");
    }


    /**
     * 返回自定义日期格式化格式
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format) {

        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    public static Date lessHMS(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(date);
        Date parseDate = null;
        try {
            parseDate = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parseDate;
    }

    /**
     * 获取日期是星期几
     * 星期一 -> 1
     * 星期二 -> 2
     * 星期三 -> 3
     * 星期四 -> 4
     * 星期五 -> 5
     * 星期六 -> 6
     * 星期日 -> 7
     *
     * @param date 日期
     * @return 1到7
     */
    public static int transIntWeek(@NonNull Date date) {
        int i = cn.hutool.core.date.DateUtil.dayOfWeek(date);
        int res = (i - 1) % 7;
        return res == 0 ? 7 : res;
    }

    /**
     * 获取两个日期之间的全部日期集合
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<String> getDays(Date startDate, Date endDate) {
        // 返回的日期集合
        List<String> days = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(startDate);
        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(endDate);
        //结束日期加1天
        tempEnd.add(Calendar.DAY_OF_YEAR, 1);

        //2020-10-01 06:00:00 小于 020-10-01 09:00:00 这个方法还会执行
        while (tempStart.before(tempEnd)) {
            //这里校验开始日期的天数是否小于结束日期的天数
            if (tempStart.get(Calendar.DATE) < tempEnd.get(Calendar.DATE) || tempStart.get(Calendar.MONTH) < tempEnd.get(Calendar.MONTH)) {
                days.add(dateFormat.format(tempStart.getTime()));
            }
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }

        return days;
    }

    public static List<Date> getDays(Integer dayNumber) {
        // 返回的日期集合
        Date date = new Date();
        List<Date> days = new ArrayList<>();

        for (int i = 0; i < dayNumber; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.add(Calendar.DATE, (i + 1));
            days.add(cal.getTime());
        }


        return days;
    }

    /**
     * 日期增加天时分秒
     *
     * @param date     指定的日期
     * @param num      增加的大小 -num代表减
     * @param timeUnit 增加的时间单位
     * @return
     */
    public static Date dateAdd(Date date, int num, TimeUnit timeUnit) {
        // 返回的日期集合
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        switch (timeUnit) {
            case DAYS:
                cal.add(Calendar.DATE, num);
                break;
            case HOURS:
                cal.add(Calendar.HOUR_OF_DAY, num);
                break;
            case MINUTES:
                cal.add(Calendar.MINUTE, num);
                break;
            case SECONDS:
                cal.add(Calendar.SECOND, num);
                break;
            default:
                break;
        }
        return cal.getTime();
    }

    /**
     * 日期修改指定的时分秒天数
     *
     * @param date     指定的日期
     * @param num      增加的大小 -num代表减
     * @param timeUnit 增加的时间单位
     * @return
     */
    public static Date dateSet(Date date, int num, TimeUnit timeUnit) {
        // 返回的日期集合
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        switch (timeUnit) {
            case DAYS:
                cal.set(Calendar.DATE, num);
                break;
            case HOURS:
                cal.set(Calendar.HOUR_OF_DAY, num);
                break;
            case MINUTES:
                cal.set(Calendar.MINUTE, num);
                break;
            case SECONDS:
                cal.set(Calendar.SECOND, num);
                break;
            default:
                break;
        }
        return cal.getTime();
    }


}
