package com.sorting;

import java.util.Arrays;

public class BubbleSort {
	/**
	 * Logic for bubble sort
	 * 
	 * Take element from start index and compare to next element and swap if it is
	 * greater Repeat until reached to end
	 */

	public int[] sort(int items[]) {
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items.length - 1; j++) {
				if (items[j] > items[j + 1]) {
					int temp = items[j];
					items[j] = items[j + 1];
					items[j + 1] = temp;
				}
			}
		}
		return items;
	}

	public static void main(String args[]) {
		BubbleSort insertionSort = new BubbleSort();
		int arr[] = { 15, 99, 24, 98, 3, 9998, 5, 9, 1, 4, 6, 2 };
		System.out.println(Arrays.toString(insertionSort.sort(arr)));
	}

}
