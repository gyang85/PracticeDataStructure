package com.sorting;

import java.util.Arrays;

public class InsertionSort {
	/**
	 * Logic to sort element in insertion sort compare the element from right to
	 * left start with index start+1 and shift the items 15, 9, 1, 4, 6, 2 Now start
	 * with index 1=> keep 9 in temp and compare till start index Check if previous
	 * element is greater than shift to right ie. copy into 1st position so now
	 * first position is empty and no element left to compare so set the temp
	 * variable to them
	 * 
	 * @param items
	 */
	public int[] sort(int[] items) {
		for (int i = 1; i < items.length; i++) {
			int j = i;
			int temp = items[j];
			// compare till start index
			while (j > 0 && temp < items[j - 1]) {
				items[j] = items[j - 1];
				j--;
			}
			items[j] = temp;
		}
		return items;
	}

	public static void main(String args[]) {
		InsertionSort insertionSort = new InsertionSort();
		int arr[] = { 15, 99, 24, 5, 9, 1, 4, 6, 2 };
		System.out.println(Arrays.toString(insertionSort.sort(arr)));
	}
}
