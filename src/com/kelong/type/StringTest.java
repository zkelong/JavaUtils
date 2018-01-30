package com.kelong.type;

import java.util.Date;
import java.util.Locale;

public class StringTest {
	public static void test() {
		testStringMethod();
	}
	
	//创建字符串
	public static void newString() {
		String s1 = new String();
		System.out.println(s1.length());
		System.out.println(s1);
		//////////////
		char[] sa = {'l', 'o', 'v', 'e'};
		String s2 = new String(sa);
		System.out.println(s2.length());
		System.out.println(s2);
		///////////
		String s3 = new String("love");
		System.out.println(s3);
		//////////
		String s4 = "yes";
		System.out.println(s4);
		System.out.println();
	}
	
	//字符串+操作
	public static void stringOperate() {
		String s1 = "str1";
		String s2 = new String("str2");
		String s3 = s1 + s2;
		System.out.println(s3);
		/////////
		System.out.println(s1 + 0.0123);
		System.out.println();
	}
	
	//字符串比较
	public static void StringCompelete() {
		String s1 = "ll";
		String s2 = "ll";
		String s3 = "LL";
		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));
		System.out.println(s1.equalsIgnoreCase(s3));
		System.out.println();		
	}
	
	//字符串大小写转换
	public static void StringChange() {
		String s1 = new String("aa");
		s1.toUpperCase();
		System.out.println(s1);
		System.out.println(s1.toUpperCase());
		System.out.println(s1.toLowerCase());
		System.out.println();
	}
	
	//字符串是否是数字
	public static boolean StringIsNumber(String st) {
		char[] cArray = st.toCharArray();
		for(char c : cArray) {
			if(!Character.isDigit(c))
				return false;
		}
		return true;
	}
	
	//字符串转换为数字
	public static int StringToNumber(String s) {
		int rt = 0;
		try {
			 rt = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			throw e;
		}
		return rt;
	}
	//字符串格式化
	public static void StringFormatData() {
		Date today = new Date();
		String a = String.format(Locale.US, "%tb", today);
		System.out.println(a);
		////////
		String b = String.format(Locale.US, "%tB", today);
		System.out.println(b);
		///////////
		String c = String.format("%ta", today);
		System.out.println(c);
		//////////
		String d = String.format("%tA", today);
		System.out.println(d);
		////////
		String e = String.format("%tY", today);
		System.out.println(e);
		/////
		String f = String.format("%ty", today);
		System.out.println(f);
		/////////
		String g = String.format("%tm", today);
		System.out.println(g);
		/////////
		String h = String.format("%td", today);
		System.out.println(h);
		/////
		String i = String.format("%te", today);
		System.out.println(i);				
	}
	// String 的方法
	public static void testStringMethod() {
		String s = "abcdefghijklmnopqrstuvwxyz";
		String s1 = "Abcdefghijklmnopqrstuvwxyz";
		System.out.println(s);
		char sI = s.charAt(0);
		System.out.println(sI);
		int comr = s.compareTo(s1);
		int comr1 = s.compareToIgnoreCase(s1);
		System.out.println(String.format("%d, %d", comr, comr1));
	}
}
