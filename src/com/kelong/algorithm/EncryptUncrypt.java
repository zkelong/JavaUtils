package com.kelong.algorithm;

public class EncryptUncrypt {
	
	public static void testEU() {
		String e = EAndU("I love Java!", '好');
		System.out.println(e);
		String u = EAndU(e, '好');
		System.out.println(u);
	}
	
	//加密 and 解密
	public static String EAndU(String value, char secret) {
		byte[] bt = value.getBytes(); //将对加密的内容转为字节数组
		for(int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (bt[i] ^ (int)secret);   //通过异运算进行加密
		}
		return new String(bt, 0, bt.length);		
	}
}
