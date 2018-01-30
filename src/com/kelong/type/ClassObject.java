package com.kelong.type;

public class ClassObject {
	int d;
	String s;
	static int sd;
	static String ss;
	public static int psd;
	public static String pss;
		
	public ClassObject() {
		System.out.println("class constructor!");
		d = 10;
		s = "string";
		sd = 100;
		ss = "staticString";
		psd = 1000;
		pss = "publicStaticString";
	}
	
	public String toString() {
		return "d:" + d + ",s:" + s + ",sd:" + sd + ",ss:" + ss + ",psd:" + psd + ",pss:" + pss;
	}
	
	//静态方法不能调用非静态方法
	public static void testStaticM() {
		System.out.println("staticMethod");
	}
	
	public static void compareObject() {
		String s1 = "aa";
		String s2 = "aa";
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}
}
