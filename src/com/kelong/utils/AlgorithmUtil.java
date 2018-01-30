package com.kelong.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class AlgorithmUtil {
	////////////////////数组获取最值
	/**
	 * 时间最大值
	 * @param arr
	 * @return
	 */
	public static Date getMax(Date[] arr) {
		if(arr.length < 1) {
			return null;
		} else if(arr.length == 1) {
			return arr[0];
		}
		Date date = arr[0];
		for(int i = 1; i < arr.length; ++i) {
			if(date.before(arr[i])) {
				date = arr[i];
			}
		}
		return date;
	}
	/**
	 * 时间最小值
	 * @param arr
	 * @return
	 */
	public static Date getMin(Date[] arr) {
		if(arr.length < 1) {
			return null;
		} else if(arr.length == 1) {
			return arr[0];
		}
		Date date = arr[0];
		for(int i = 1; i < arr.length; ++i) {
			if(date.after(arr[i])) {
				date = arr[i];
			}
		}
		return date;
	}
	/////////////////加密算法-MD5
	/**
	 * 字符串MD5加密
	 * @param aStr
	 * @return
	 */
	public static String stringToMd5(String aStr) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = aStr.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            System.out.println();
            String s = new String(str);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
	/**
	 * 问价MD5-与文件内容有关，与名字无关
	 * @param path
	 * @return
	 */
    public static String fileToMD5(String path){
        try {
            FileInputStream fis = new FileInputStream(path);
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                digest.update(buffer, 0, len);
            }
            fis.close();
            BigInteger bigInt = new BigInteger(1, digest.digest());
            return  bigInt.toString(16);
        } catch (IOException | NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return "";
    }
}
