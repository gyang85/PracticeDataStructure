package com.sorting;

import java.util.Arrays;

/**
 * Find the smallest element in the array and swap with start element
 * @author nxf43614
 *
 */
public class SelectionSort {

	public void sort(int [] arr) {
		for (int i=0;i<arr.length-1 ;i++) {
			int min = i;
			for (int j = i+1; j<arr.length;j++) {
				if (arr[j]<arr[min]) {
					min = j;
				}
			}
			if (min!=i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
	}
	
	public static void main(String args[]) {
		SelectionSort selectionSort = new SelectionSort();
		int arr[] = { 15, 99, 24, 5, 9, 1, 4, 6, 2 };
		selectionSort.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
