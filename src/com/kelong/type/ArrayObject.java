package com.kelong.type;

import java.util.Arrays;

public class ArrayObject {
	public void test() {
//		testMemory();
		testClone();
	};
	
	//填充替换数组元素
	public void testFill() {
		int[] iarr = new int[9];
		Arrays.fill(iarr, 1);
		for(int i : iarr) {
			System.out.print(i + ",");
		}
	}
	
	//copyOf
	public void testCopy() {
		int[] iarr = new int[9];
		int[] iarr1 = Arrays.copyOf(iarr, iarr.length);
		printArray(iarr1);
	}
	
	//copyOfRange
	public void testCopyOfRange() {
		int[] iarr = {1, 3, 2, 4, 5, 2, 9, 10};
		int[] iarr1 = Arrays.copyOfRange(iarr, 1, 4);
		printArray(iarr1);
	}
	
	//clone
	public void testClone() {
		int[] iarr = {1, 3, 2, 4, 5, 2, 9, 10};
		int[] iarr1 = iarr.clone();
		printArray(iarr1);
	}
	
	//systemArrayCopy
	public void testSystemArrayCopy() {
		int[] iarr = {1, 3, 2, 4, 5, 2, 9, 10};
		int[] iarr1 = new int[8];
		System.arraycopy(iarr, 0, iarr1, 0, iarr.length);
		printArray(iarr1);
	}
	
	//Array memory
	public void testMemory() {
		int num1 = 1024 * 1024 * 2;
		int[] arr1 = new int[num1];
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = i;
		}
		//获得占用内存总数，并将单位转换为MB
		long memory1 = Runtime.getRuntime().totalMemory() / 1024 / 1024;
		System.out.println("占用：" + memory1);
		int num2 = 1024 * 1024;
		int[][] arr2 = new int[num2][2];
		for(int i = 0; i < arr2.length; i++) {
			arr2[i][0] = i;
			arr2[2][1] = i;
		}
		long memory2 = Runtime.getRuntime().totalMemory() / 1024 /1024;
		System.out.println("占用：" + memory2);
	}
	
	public void printArray(int[] arr) {
		for(int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + ",");
		}
	}
}
