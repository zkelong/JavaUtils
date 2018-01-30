package com.kelong.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
	////////////////////////////获取时间戳
	/**
	 * 获取时间戳--当前
	 * @return
	 */
	public static long getTimestamp() {
		long time = new Date().getTime();
		return time;
	}
	/**
	 * 获取时间戳
	 * @return
	 */
	public static long getTimestamp(Date date) {
		long time = date.getTime();
		return time;
	}
	
	////////////////////////////获取时间格式字符串
	/**
	 * 获取时间格式字符串--当前
	 * @param format 格式化格式字符串
	 * 		"yyyy-MM-dd HH:mm:ss:SSS" 				2015-08-28 18:28:30:999
	 * 		"yyyy-M-d"	 						2015-8-28
	 * 		"yyyy年M月d日" 						2018年1月10日
	 * 		"yyyy-MM-dd" 						2015-08-28
	 * 		"yyyy-M-d H:m:s" 					2015-8-28 18:8:30
	 * 		"MMM d, yyyy h:m:s aa"				一月 10, 2018 2:58:19 下午 / Aug 28, 2015 6:8:30 PM
	 * 		"EEE MMM d HH:mm:ss 'CST' yyyy" 	星期三 一月 10 15:00:15 CST 2018 / Fri Aug 28 18:08:30 CST 2015
	 * 	注: yyyy 可以替换为 yy; MM/dd/HH/mm/ss 可以替换为 M/d/H/m/s; SSS 表示毫秒
	 * @return String
	 */
	public static String getTimeFormat(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(new Date());
	}
	/**
	 * 获取时间格式字符串-时间戳为13位
	 * @param date 时间戳
	 * @param format 同上
	 * @return String
	 */
	public static String getTimeFormat(long date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(new Date(date));
	}
	/**
	 * 获取时间格式字符串
	 * @param date 时间戳
	 * @param format 同上
	 * @return String
	 */
	public static String getTimeFormat(Date date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}
	
	////////////////////////////将时间格式字符串转为 Date
	/**
	 * 将时间格式字符串转为 Date
	 * @param timeStr
	 * @param format 同getTimeFormat() format
	 * @return Date
	 * @throws Exception
	 */
	public static Date getDateByString(String timeStr, String format) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.parse(timeStr);
	}
	
	////////////////////////////获取月份天数
	/**
	 * 获取当前月份天数
	 * @return
	 */
	public static int getMonthDays() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 1); 	//将 Calendar.DATE 设置为 1
		c.roll(Calendar.DATE, -1);  //在给定的时间字段上添加或减去（上/下）单个时间单元
		return c.get(Calendar.DATE);
	}	
	/**
	 * 获取月份天数
	 * @param year 年份
	 * @param month 月份
	 * @return
	 */
	public static int getMonthDays(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, 1); //设置为年-月-1号
		c.roll(Calendar.DATE, -1);
		return c.get(Calendar.DATE);
	}	
	/**
	 * 获取月份天数
	 * @param date
	 * @return
	 */	
	public static int getMonthDays(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DATE, 1);
		c.roll(Calendar.DATE, -1);
		return c.get(Calendar.DATE);
	}
	
	////////////////////////////获取天/月/年的开始.结束时间
	//java 中只有值传递，此处传的是地址
	private static void setDayTime(Calendar c, boolean start) {
		c.set(Calendar.HOUR_OF_DAY, start ? 0 : 23);
        c.set(Calendar.MINUTE, start ? 0 : 59);
        c.set(Calendar.SECOND, start ? 0 : 59);
        c.set(Calendar.MILLISECOND, start ? 0 : 999);
	}
	///////天
	/**
	 * 获取当前一天的开始时间
	 * @return
	 */
	public static Date getDayStart() {
		Calendar c = Calendar.getInstance();
		setDayTime(c, true);
        return c.getTime();
	}
	/**
	 * 获取给定时间当天的开始时间
	 * @return
	 */
	public static Date getDayStart(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		setDayTime(c, true);
        return c.getTime();
	}
	/**
	 * 获取当天的结束时间点
	 * @return
	 */
	public static Date getDayEnd() {
		Calendar c = Calendar.getInstance();  
		setDayTime(c, false);
        return c.getTime();
	}
	/**
	 * 获取给定时间的结束时间点
	 * @return
	 */
	public static Date getDayEnd(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		setDayTime(c, false);
        return c.getTime();
	}
	//////周
	/**
	 * 获取当前周的开始时间
	 * @return
	 */
	public static Date getWeekStart() {
		Calendar c = Calendar.getInstance();
		setDayTime(c, true);
		c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);  //设置周一为开始
        return c.getTime();
	}
	/**
	 * 获取给定时间的周结束时间
	 * @return
	 */
	public static Date getWeekStart(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		setDayTime(c, true);
		c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return c.getTime();
	}
	/**
	 * 获取当前周的结束时间
	 * @return
	 */
	public static Date getWeekEnd() {
		Calendar c = Calendar.getInstance();
		setDayTime(c, false);
		c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); //周一的结束时间点
        c.add(Calendar.DAY_OF_WEEK, 6);
        return c.getTime();
	}
	/**
	 * 获取给定时间的周结束时间
	 * @return
	 */
	public static Date getWeekEnd(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		setDayTime(c, false);
		c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); //周一的结束时间点
        c.add(Calendar.DAY_OF_WEEK, 6);
        return c.getTime();
	}
	
	//////月
	/**
	 * 获取当前月开始时间
	 * @return
	 */
	public static Date getMonthStart() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		setDayTime(c, true);
        return c.getTime();
	}
	/**
	 * 获取当前月开始时间
	 * @return
	 */
	public static Date getMonthStart(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		setDayTime(c, true);
        return c.getTime();
	}
	/**
	 * 获取当前月结束时间
	 * @return
	 */
	public static Date getMonthEnd() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 0); //月末
		setDayTime(c, false);
        return c.getTime();
	}
	/**
	 * 获取给定时间的月结束时间
	 * @return
	 */
	public static Date getMonthEnd(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 0); //月末
		setDayTime(c, false);
        return c.getTime();
	}
	
	////////////////////////////季度
	/**
	 * 获取当前季度开始时间
	 * @return
	 */
	public static Date getQuaterStart() {
		Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        if (currentMonth >= 1 && currentMonth <= 3)
            c.set(Calendar.MONTH, 0);
        else if (currentMonth >= 4 && currentMonth <= 6)
            c.set(Calendar.MONTH, 3);
        else if (currentMonth >= 7 && currentMonth <= 9)
            c.set(Calendar.MONTH, 6);
        else if (currentMonth >= 10 && currentMonth <= 12)
            c.set(Calendar.MONTH, 9);
        c.set(Calendar.DATE, 1);
        setDayTime(c, true);
        return c.getTime();
	}
	/**
	 * 获取给定时间的季度开始时间
	 * @return
	 */
	public static Date getQuaterStart(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        if (currentMonth >= 1 && currentMonth <= 3)
            c.set(Calendar.MONTH, 0);
        else if (currentMonth >= 4 && currentMonth <= 6)
            c.set(Calendar.MONTH, 3);
        else if (currentMonth >= 7 && currentMonth <= 9)
            c.set(Calendar.MONTH, 6);
        else if (currentMonth >= 10 && currentMonth <= 12)
            c.set(Calendar.MONTH, 9);
        c.set(Calendar.DATE, 1);
        setDayTime(c, true);
        return c.getTime();
	}
	/**
	 * 获取当前季度结束时间
	 * @return
	 */
	public static Date getQuaterEnd() {
		Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        if (currentMonth >= 1 && currentMonth <= 3)
            c.set(Calendar.MONTH, 3);
        else if (currentMonth >= 4 && currentMonth <= 6)
            c.set(Calendar.MONTH, 6);
        else if (currentMonth >= 7 && currentMonth <= 9)
            c.set(Calendar.MONTH, 9);
        else if (currentMonth >= 10 && currentMonth <= 12)
        	c.set(Calendar.MONTH, 12);
		c.set(Calendar.DAY_OF_MONTH, 0); //月末
        setDayTime(c, false);
        return c.getTime();
	}
	/**
	 * 获取给定时间的季度结束时间
	 * @return
	 */
	public static Date getQuaterEnd(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int currentMonth = c.get(Calendar.MONTH) + 1;
        if (currentMonth >= 1 && currentMonth <= 3)
            c.set(Calendar.MONTH, 3);
        else if (currentMonth >= 4 && currentMonth <= 6)
            c.set(Calendar.MONTH, 6);
        else if (currentMonth >= 7 && currentMonth <= 9)
            c.set(Calendar.MONTH, 9);
        else if (currentMonth >= 10 && currentMonth <= 12)
        	c.set(Calendar.MONTH, 12);
		c.set(Calendar.DAY_OF_MONTH, 0); //月末
        setDayTime(c, false);
        return c.getTime();
	}
	
	////////////////////////////半年
	/**
	 * 获取当前半年开始时间
	 * @return
	 */
	public static Date getHalfYearStart() {
		Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH);
        if (currentMonth < 6)
            c.set(Calendar.MONTH, 0);
        else
        	c.set(Calendar.MONTH, 6);
        c.set(Calendar.DATE, 1);
        setDayTime(c, true);
        return c.getTime();
	}
	/**
	 * 获取给定时间的半年开始时间
	 * @return
	 */
	public static Date getHalfYearStart(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int currentMonth = c.get(Calendar.MONTH);
        if (currentMonth < 6)
            c.set(Calendar.MONTH, 0);
        else
        	c.set(Calendar.MONTH, 6);
        c.set(Calendar.DATE, 1);
        setDayTime(c, true);
        return c.getTime();
	}
	/**
	 * 获取当前半年结束时间
	 * @return
	 */
	public static Date getHalfYearEnd() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH);
        if (currentMonth < 6)
            c.set(Calendar.MONTH, 6);
        else
        	c.set(Calendar.MONTH, 12);
		c.set(Calendar.DAY_OF_MONTH, 0); //月末
        setDayTime(c, false);
        return c.getTime();
	}
	/**
	 * 获取给定时间的半年结束时间
	 * @return
	 */
	public static Date getHalfYearEnd(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int currentMonth = c.get(Calendar.MONTH);
        if (currentMonth < 6)
            c.set(Calendar.MONTH, 6);
        else
        	c.set(Calendar.MONTH, 12);
		c.set(Calendar.DAY_OF_MONTH, 0); //月末
        setDayTime(c, false);
        return c.getTime();
	}
	////////////////////////////年
	/**
	 * 获取当前年开始时间
	 * @return
	 */
	public static Date getYearStart() {
		Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, 0);
        c.set(Calendar.DATE, 1);
        setDayTime(c, true);
        return c.getTime();
	}
	/**
	 * 获取给定时间的年开始时间
	 * @return
	 */
	public static Date getYearStart(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
    	c.set(Calendar.MONTH, 0);
        c.set(Calendar.DATE, 1);
        setDayTime(c, true);
        return c.getTime();
	}
	/**
	 * 获取当前年结束时间
	 * @return
	 */
	public static Date getYearEnd() {
		Calendar c = Calendar.getInstance();
    	c.set(Calendar.MONTH, 12);
		c.set(Calendar.DAY_OF_MONTH, 0); //月末
        setDayTime(c, false);
        return c.getTime();
	}
	/**
	 * 获取给定时间的年结束时间
	 * @return
	 */
	public static Date getYearEnd(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
    	c.set(Calendar.MONTH, 12);
		c.set(Calendar.DAY_OF_MONTH, 0); //月末
        setDayTime(c, false);
        return c.getTime();
	}

	////////////////////时间比较
	/**
	 * 时间最大值
	 * @param dates
	 * @return
	 */
	public static Date getMaxTime(Date... dates) {
		return AlgorithmUtil.getMax(dates);
	}
	/**
	 * 时间最小值
	 * @param dates
	 * @return
	 */
	public static Date getMinTime(Date... dates) {
		return AlgorithmUtil.getMin(dates);
	}
	/**
	 * 时间差-相差毫秒数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getTimeMilliSecondDiff(Date date1, Date date2) {
		return date1.getTime() - date2.getTime();
	}
	/**
	 * 时间差-相差秒数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getTimeSecondDiff(Date date1, Date date2) {
		return (date1.getTime() - date2.getTime())/1000;
	}
	/**
	 * 时间差-相差分钟数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getTimeMinuteDiff(Date date1, Date date2) {
		return (date1.getTime() - date2.getTime()) / (1000*60);
	}
	/**
	 * 时间差-相差小时数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getTimeHourDiff(Date date1, Date date2) {
		return (date1.getTime() - date2.getTime()) / (1000*60*60);
	}
	/**
	 * 时间差-相差天数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getTimeDayDiff(Date date1, Date date2) {
		return (int)(date1.getTime() - date2.getTime()) / (1000*60*60*24);
	}
	/**
	 * 时间差-相差周数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getTimeWeekDiff(Date date1, Date date2) {
		return getTimeDayDiff(date1, date2)/7;
	}
	/**
	 * 时间差-相差月数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getTimeMonthDiff(Date date1, Date date2) {
		Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance(); 
        c1.setTime(date1);
        c2.setTime(date2);

        return c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH) + 12 * (c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR));
	}
	/**
	 * 时间差-相差年数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getTimeYearDiff(Date date1, Date date2) {
		Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance(); 
        c1.setTime(date1);
        c2.setTime(date2);

        return c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
	}	
}