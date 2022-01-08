package com.sorting;

import java.util.Arrays;

/**
 * Merge sort is based on divide and conquer approach Divide array in two sub
 * array and sort each both subarray Now merge both array
 *
 * @author nxf43614
 *
 */
public class MergeSort {

	public void mergeSort(int[] items, int left, int right) {
		// divide in two subarray and then merge
		// right index
		if (left < right) {
			int midIndex = (left + right) / 2;
			mergeSort(items, left, midIndex);
			mergeSort(items, midIndex + 1, right);
			mergeSubArray(items, left, midIndex, right);
		}
	}

	/**
	 * merge both array
	 * 
	 * @param items
	 * @param left
	 * @param midIndex
	 * @param right    Merges two subarrays of items[] First subarray is arr[l..m]
	 *                 Second subarray is arr[m+1..r] 1, 2, 3, 4, 5, 6
	 */
	private void mergeSubArray(int[] items, int leftIndex, int midIndex, int rightIndex) {
		// Here we need to create two temporary subarray for comparison

		int sizeOfLeft = midIndex - leftIndex + 1;
		int sizeOfRight = rightIndex - midIndex;

		// create temporary array
		int[] left = new int[sizeOfLeft];
		int[] right = new int[sizeOfRight];

		/* Copy data to temp arrays */
		for (int i = 0; i < sizeOfLeft; ++i)
			left[i] = items[leftIndex + i];
		for (int j = 0; j < sizeOfRight; ++j)
			right[j] = items[midIndex + 1 + j];

		// Now compare these two array and add in element
		int l = 0; // index of left array
		int r = 0; // index of right array
		int k = leftIndex;
		while (l < sizeOfLeft && r < sizeOfRight) {
			if (left[l] <= right[r]) {
				items[k] = left[l];
				l++;
			} else {
				items[k] = right[r];
				r++;
			}
			k++;
		}

		// copy remaining element of left
		while (l < sizeOfLeft) {
			items[k] = left[l];
			l++;
			k++;
		}
		// copy remaining element of left
		while (r < sizeOfRight) {
			items[k] = right[r];
			r++;
			k++;
		}

	}

	public static void main(String args[]) {
		MergeSort mergeSort = new MergeSort();
		int arr[] = { 15, 99, 24, 5, 9, 1, 4, 6, 2 };
		System.out.println("Before start " + Arrays.toString(arr));
		mergeSort.mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
