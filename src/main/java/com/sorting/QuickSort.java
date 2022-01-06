package com.sorting;

import java.util.Arrays;

public class QuickSort {

	/**
	 * Quick sort is based on partitioning There will be two pointer for comparison
	 * => 1. starting from start index 
	 * 2. start for end index
	 * Now lets assume first pivot
	 * element is first index and start comparing from start now loop first pointer
	 * and compare element. if element is less or equal than pivot element then move
	 * to the next element until receive greater than pivot element once receive
	 * greater element stop the pointer and start comparing from ending index and
	 * compare if element is greater or equal then pivot element move to pointer
	 * until receive smaller element
	 * 
	 * Now left side we receive larger element and right side we receive smaller
	 * element so swap the element Repeat the same process until jth cursor crossed
	 * ith cursor Now swap jth element with pivot element and return jth index as
	 * pivot element Now we have all small element in left side and large element in
	 * right side so we need to call recursion for same process
	 * 
	 * @param items
	 * @return
	 */
	public void quickSort(int[] items, int low, int high) {
		if (low < high) {
			int pivot = partition(items, low, high);
			// Left element of pivot
			quickSort(items, low, pivot - 1);
			// Right elements of the pivot
			quickSort(items, pivot + 1, high);
		}
	}

	/**
	 * 15, 99, 24, 5, 9, 1, 4, 6, 2 
	 * 15 ,99(stop), 24, 5,9,1,4,6,2(stop) 15, 2, 24,
	 * 5, 9, 1, 4, 6, 99 15, 2, 24(stop), 5, 9, 1, 4, 6(stop),99 15, 2, 6, 5, 9, 1,
	 * 4, 24, 99
	 * 
	 * 15, 2, 6, 5, 9, 1, 4(stop right), 24 (stop left), 99
	 * 
	 * Swap with pivot
	 * 
	 * 4, 2, 6, 5, 9, 1, 15, 24, 99 => pivot is 15
	 * 
	 * 
	 * @param items
	 * @param low
	 * @param high
	 * @return
	 */
	public int partition(int[] items, int low, int high) {
		int i = low;
		int j = high;
		int pivot = items[i];
		while (i < j) {
			while (items[i] <= pivot) {
				i++;
			}
			while (items[j] > pivot) {
				j--;
			}
			if (i < j) {
				int temp = items[i];
				items[i] = items[j];
				items[j] = temp;
			}
		}

		if (i > j) {
			// swap the pivot element
			int temp = items[low];
			items[low] = items[j];
			items[j] = temp;
		}
		System.out.println("Place the pivot " + Arrays.toString(items));
		System.out.println("Pivot position " + j);
		return j;

	}

	public static void main(String args[]) {
		QuickSort quickSort = new QuickSort();
		int arr[] = { 15, 99, 24, 5, 9, 1, 4, 6, 2 };
		System.out.println("Before start " + Arrays.toString(arr));
		quickSort.quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

}
