package com.kelong.utils;

import java.text.DateFormat;
import java.util.Date;

public class UtilsSimple {
	public static void test() {
//		testTimeUtil();
//		testAlgoithmUtil();
		testStringUtil();
	}

	// 时间处理
	public static void testTimeUtil() {
		// 获取时间戳
		long d = TimeUtil.getTimestamp();
		System.out.println("当前时间戳：" + d);
		// 通过时间戳获取时间
		Date date = new Date(d);
		// 格式化时间
		String dStr = TimeUtil.getTimeFormat(date, "yyyy-MM-dd HH:mm:ss");
		System.out.println("格式化时间：" + dStr);
		DateFormat df = DateFormat.getInstance();
		// 将时间格式字符串转为 Date
		try {
			date = TimeUtil.getDateByString(dStr, "yyyy-MM-dd HH:mm:ss");
			System.out.println("格式化字符串转时间：" + date.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取月份天数
		System.out.println("当前月份天数：" + TimeUtil.getMonthDays(new Date()));
		// 获取一天开始--1514826061000l: 2017-12-3
		System.out.println("天开始时间："
				+ TimeUtil.getTimeFormat(TimeUtil.getDayStart(),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		System.out.println("天开始时间："
				+ TimeUtil.getTimeFormat(
						TimeUtil.getDayStart(new Date(1512234061000l)),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		// 获取一天的结束时间
		System.out.println("天结束时间："
				+ TimeUtil.getTimeFormat(TimeUtil.getDayEnd(),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		System.out.println("天结束时间："
				+ TimeUtil.getTimeFormat(
						TimeUtil.getDayEnd(new Date(1512234061000l)),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		// 获取一周的开始时间
		System.out.println("周开始时间："
				+ TimeUtil.getTimeFormat(TimeUtil.getWeekStart(),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		System.out.println("周开始时间："
				+ TimeUtil.getTimeFormat(
						TimeUtil.getWeekStart(new Date(1512234061000l)),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		// 获取周结束时间
		System.out.println("周结束时间："
				+ TimeUtil.getTimeFormat(TimeUtil.getWeekEnd(),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		System.out.println("周结束时间："
				+ TimeUtil.getTimeFormat(
						TimeUtil.getWeekEnd(new Date(1512234061000l)),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		// 获取月开始时间
		System.out.println("月开始时间："
				+ TimeUtil.getTimeFormat(TimeUtil.getMonthStart(),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		System.out.println("月开始时间："
				+ TimeUtil.getTimeFormat(
						TimeUtil.getMonthStart(new Date(1512234061000l)),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		// 获取月结束时间
		System.out.println("月结束时间："
				+ TimeUtil.getTimeFormat(TimeUtil.getMonthEnd(),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		System.out.println("月结束时间："
				+ TimeUtil.getTimeFormat(
						TimeUtil.getMonthEnd(new Date(1512234061000l)),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		// 季度开始时间
		System.out.println("季度开始时间："
				+ TimeUtil.getTimeFormat(TimeUtil.getQuaterStart(),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		System.out.println("季度开始时间："
				+ TimeUtil.getTimeFormat(
						TimeUtil.getQuaterStart(new Date(1512234061000l)),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		// 季度结束时间
		System.out.println("季度结束时间："
				+ TimeUtil.getTimeFormat(TimeUtil.getQuaterEnd(),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		System.out.println("季度结束时间："
				+ TimeUtil.getTimeFormat(
						TimeUtil.getQuaterEnd(new Date(1512234061000l)),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		// 半年开始时间
		System.out.println("半年开始时间："
				+ TimeUtil.getTimeFormat(TimeUtil.getHalfYearStart(),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		System.out.println("半年开始时间："
				+ TimeUtil.getTimeFormat(
						TimeUtil.getHalfYearStart(new Date(1512234061000l)),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		// 半年结束时间
		System.out.println("半年结束时间："
				+ TimeUtil.getTimeFormat(TimeUtil.getHalfYearEnd(),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		System.out.println("半年结束时间："
				+ TimeUtil.getTimeFormat(
						TimeUtil.getHalfYearEnd(new Date(1512234061000l)),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		// 年开始时间
		System.out.println("年开始时间："
				+ TimeUtil.getTimeFormat(TimeUtil.getYearStart(),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		System.out.println("年开始时间："
				+ TimeUtil.getTimeFormat(
						TimeUtil.getYearStart(new Date(1512234061000l)),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		// 年结束时间
		System.out.println("年结束时间："
				+ TimeUtil.getTimeFormat(TimeUtil.getYearEnd(),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		System.out.println("年结束时间："
				+ TimeUtil.getTimeFormat(
						TimeUtil.getYearEnd(new Date(1512234061000l)),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		// ///时间比较
		Date[] dates = { new Date(1512234061000l), new Date(1512234041000l),
				new Date(1512234031000l), new Date(1512234066000l),
				new Date(1512234081000l) };
		// 最大值
		System.out.println("时间大的: "
				+ TimeUtil.getTimeFormat(TimeUtil.getMaxTime(dates),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		// 最小值
		System.out.println("时间小的: "
				+ TimeUtil.getTimeFormat(TimeUtil.getMinTime(dates),
						"yyyy-MM-dd HH:mm:ss:SSS"));
		// 相差毫秒数
		System.out.println("相差毫秒数: "
				+ TimeUtil.getTimeMilliSecondDiff(new Date(1512234061000l),
						new Date(1512234041000l)));
		// 相差秒数
		System.out.println("相差秒数: "
				+ TimeUtil.getTimeSecondDiff(new Date(1512234061000l),
						new Date(1512234041000l)));
		// 相差分钟数
		System.out.println("相差分钟数: "
				+ TimeUtil.getTimeMinuteDiff(new Date(1516901160000l),
						new Date(1516901340000l)));
		// 相差小时数
		System.out.println("相差小时数: "
				+ TimeUtil.getTimeHourDiff(new Date(1516976940000l), new Date(
						1516901340000l)));
		// 相差天数
		System.out.println("相差天数: "
				+ TimeUtil.getTimeDayDiff(new Date(1517901160000l), new Date(
						1516901340000l)));
		// 相差周数
		System.out.println("相差周数: "
				+ TimeUtil.getTimeWeekDiff(new Date(1517901160000l), new Date(
						1516901340000l)));
		// 相差月数
		System.out.println("相差月数: "
				+ TimeUtil.getTimeMonthDiff(new Date(1737820800000l), new Date(
						1516896000000l)));
		// 相差年数
		System.out.println("相差年数: "
				+ TimeUtil.getTimeYearDiff(new Date(1737820800000l), new Date(
						1516896000000l)));
		// 时间相差展示
		diffTimeShow();
	}

	/**
	 * 
	 */
	public static void diffTimeShow() {

	}
	//算法
	public static void testAlgoithmUtil() {
		System.out.println(AlgorithmUtil.stringToMd5("123456789"));
		System.out.println(AlgorithmUtil.fileToMD5("e:/test.png"));
	}
	//字符串处理
	public static void testStringUtil() {
		//分割成数组
		String s = "abcdefghijklmnopqrstuvwxyz";
		String[] array = s.split("k");
		for(int i = 0; i < array.length; ++i) {
			System.out.println(array[i]);
		}
		//去掉首尾空格
		String s1 = " asldg alsd ";
		System.out.println(s1.trim());
		System.out.println(s1.replace(" ", ""));
		String s2 = " slaf sas sd	asd";
//		System.out.println(s2.replace(" ", ""));
		System.out.println(s2.replaceAll("\\s*", ""));
	}
	
}
