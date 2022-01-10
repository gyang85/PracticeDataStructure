package com.sorted.search;
/**
 * Binary search is widely used algorithm and its time complexity is O(logn)
 * Its applied on searching element in sorted array
 * Find middle index and search element 
 * if element is less than middle index, it means it would not present in right portions
 * and if element is greater than middle that means element will be present in right index
 * We should keep continue dividing in subarray and do the operation
 * @author nxf43614
 *
 */
public class BinarySearch {

	public int search(int arr[], int key, int left, int right) {
		int elementFound = -1;
		while (left < right) {
			int middle = (left + right) / 2;
			if (arr[middle] == key) {
				elementFound = middle;
				break;
			} else if (key < arr[middle]) {
				right = middle - 1;
			} else if (key > arr[middle]) {
				left = middle + 1;
			}

		}
		return elementFound;
	}

	public static void main(String args[]) {
		BinarySearch binarySearch = new BinarySearch();
		int arr[] = { 1, 2, 5, 15, 24, 30, 50 };
		int searchIndex = binarySearch.search(arr, 2, 0, arr.length - 1);
		if (searchIndex != -1) {
			System.out.println("Element found at position - " + searchIndex);
		} else {
			System.out.println("Element not present");
		}
	}
}
