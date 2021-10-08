package com.song.springboot.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.10.8 12:02
 */
public class DateUtil {
    /**
     * 返回N天后的时间
     * @params : 2021-01-01 00:00:00,1
     * @returns :2021-01-02 00:00:00
     */
    public static Date todayAfterZero(Date date, int day) {
        return dateUtil(date, day, 0);
    }

    /**
     * 返回N+1天后，前一毫秒的时间
     * @params : 2021-01-01 00:00:00,0
     * @returns : 2021-01-01 23:59:59
     */
    public static Date todayAfterEnd(Date date, int day) {
        return dateUtil(date, day + 1, -1);
    }

    /**
     * TODO
     * @params :
     * @returns :
     */
    public static Date dateUtil(Date date, int Day, int millisecond) {
        final Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 0);//时
        calendar.set(Calendar.MINUTE, 0);//分
        calendar.set(Calendar.SECOND, 0);//秒
        calendar.set(Calendar.MILLISECOND, 0);//毫秒
        calendar.add(Calendar.DATE, Day);
        calendar.add(Calendar.MILLISECOND, millisecond);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss.SSS");//日期格式
        System.out.println(sformat.format(todayAfterZero(date, 100)));
        System.out.println(sformat.format(todayAfterEnd(date, 100)));
    }
}
