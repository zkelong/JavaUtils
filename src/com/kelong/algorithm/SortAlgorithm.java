package com.kelong.algorithm;

import java.util.Arrays;

public class SortAlgorithm {
	public static void test() {
		int arr[] = { 1, 92, 2, 23, 82, 3, 4, 9, 390, 0 };
		printArray(arr);
		// ///插值排序//////
		// printArray(insertSort_straight(arr));
		// printArray(insertSort_shell(arr));
		// ///选择排序//////
		// printArray(selectSort_simple(arr));
		// printArray(selectSort_two(arr));
		// ///交换排序//////
		// printArray(exchangeSort_bubble(arr));
		// printArray(exchangeSort_bubble_pos(arr));
//		printArray(exchangeSort_bubble_two(arr));
//		printArray(exchangeSort_quick(arr));
		copy(arr);
		printArray(arr);
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
	}
	
	public static void copy(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[i - 1]) {
				int temp = arr[i];
				int index = i;
				while(temp < arr[index-1]) {
					arr[index] = arr[index-1];
					index--;
					if(index < 1) {
						break;
					}
				}
				arr[index] = temp;
			}
		}
	}
	

	// /////////////////////////插值排序////////////////////////////////
	// 插值排序-直接插值排序
	public static int[] insertSort_straight(int[] arrIn) {
		int[] arr = arrIn;
		for (int i = 1; i < arr.length; ++i) {
			if (arr[i] < arr[i - 1]) {
				int x = arr[i];
				int j = i - 1;
				while (x < arr[j]) {
					arr[j + 1] = arr[j];
					j--;
					if (j < 0)
						break;
				}
				arr[j + 1] = x;
			}
		}
		return arr;
	}

	//插值排序-希尔排序 以增量dk划分数组，比较小数组首尾，没有排序进行时，对分数组进行插值排序
	public static int[] insertSort_shell(int[] arrIn) {
		int[] arr = arrIn.clone();
		int dk = arr.length / 2;
		while (dk > 0) {
			for (int i = dk; i < arr.length; ++i) {
				if (arr[i] < arr[i - dk]) {
					int x = arr[i];
					int j = i - 1;
					while (x < arr[j]) {
						arr[j + 1] = arr[j];
						j--;
						if (j < 0)
							break;
					}
					arr[j + 1] = x;
				}
			}
			dk = dk / 2;
		}
		return arr;
	}

	// ////////////////////////////选择排序///////////////////////////
	// 选择排序-简单选择排序
	public static int[] selectSort_simple(int[] arrIn) {
		int[] arr = Arrays.copyOf(arrIn, arrIn.length);
		for (int i = 0; i < arr.length; ++i) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; ++j) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
		return arr;
	}

	// 选择排序-二元选择排序
	public static int[] selectSort_two(int[] arrIn) {
		int[] arr = arrIn.clone();
		for (int i = 0; i < arr.length / 2; ++i) {
			int minIndex = i;
			int maxIndex = i;
			for (int j = i + 1; j < arr.length - i; ++j) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
				if (arr[j] > arr[maxIndex]) {
					maxIndex = j;
				}
			}
			int tempMin = arr[minIndex];
			int tempMax = arr[maxIndex];
			arr[minIndex] = arr[i];
			arr[maxIndex] = arr[arr.length - i - 1];
			arr[i] = tempMin;
			arr[arr.length - i - 1] = tempMax;
		}
		return arr;
	}

	// 选择排序-堆排序(树形选择排序)
	public static int[] selectSort_heap(int[] arrIn) {
		int[] arr = arrIn.clone();
		return arr;
	}

	// ////////////////////////交换排序/////////////////////////
	// 交换排序-冒泡排序
	public static int[] exchangeSort_bubble(int[] arrIn) {
		int[] arr = arrIn.clone();
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr.length - i - 1; ++j) {
				if (arr[j + 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

	// 交换排序-冒泡排序-改进，查到上轮排序的最后位置
	public static int[] exchangeSort_bubble_pos(int[] arrIn) {
		int[] arr = arrIn.clone();
		int i = arr.length - 1;
		while (i > 0) {
			int pos = 0;
			for (int j = 0; j < i; ++j) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					pos = j;
				}
			}
			i = pos;
		}
		return arr;
	}

	// 交换排序-冒泡排序-改进，同时排序大的和小的
	public static int[] exchangeSort_bubble_two(int[] arrIn) {
		int[] arr = arrIn.clone();
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			for (int i = low; i < high; ++i) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			high--;
			for (int j = high; j > low - 1; --j) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			low++;
		}
		return arr;
	}
	
	//交换排序-快速排序
	public static int[] exchangeSort_quick(int[] arrIn) {
		int[] arr = arrIn.clone();
		quickSort(arr, 0, arr.length - 1);
		return arr;
	}
	//快速排序
	public static void quickSort(int[] arr, int low, int high) {
		if(low >= high)
			return;
		int left = low;
		int right = high;
		int key = arr[left];
		while(left < right) {
			while(right > left && arr[right] >= key) {				
				--right;
			}
			if(left < right) {
				arr[left] = arr[right];
				++left;
			}
			while(left < right && arr[left] <= key) {
				++left;
			}
			if(left < right) {
				arr[right] = arr[left];
				--right;
			}
		}
		arr[left] = key;
		quickSort(arr, low, left);
		quickSort(arr, left + 1, high);
	}
}
