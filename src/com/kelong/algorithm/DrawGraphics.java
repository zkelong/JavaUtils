package com.kelong.algorithm;

import java.util.Scanner;

/**
 * 练习画图形的算法
 * @author Administrator
 *
 */
public class DrawGraphics {
	
	/**
	 * 画菱形
	 */
	public static void drawDiamond() {
		int a;
		System.out.println("Input a number:\n");
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < a + i; j++) {
				if(j == a - 1 + i || j == a - 1 - i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for(int i = 0; i < a - 1; i++) {
			for(int j = 0; j <= (a - 1) * 2 - i; j++) {
				if(j == i + 1 || j == (a - 1) * 2 - i - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		int x,y,size;  
		size = a;
		 for (x=-size;x<=size;x++)  
		 {  
		     for (y=-size;y<=size;y++)  
		     {  
		         if (Math.abs(x)+Math.abs(y)<=size)  
		         {  
		             System.out.printf("*");  
		         } else {  
		        	 System.out.printf(" ");  
		         }  
		     }  
		     System.out.printf("\n");  
		 } 
	}
	
}
