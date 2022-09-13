package com.array.problems;

public class MaxElementInArray {

	public static int findMaxElementInArr(int a[]) {
		int maxElement = a[0];
		// Assuming first element is maximum element
		// iterate array
		for (int i = 1; i < a.length; i++) {
			if (a[i] > maxElement) {
				maxElement = a[i];
			}
		}
		return maxElement;
	}

	public static int findMinElementInArr(int a[]) {
		int minElement = a[0];
		// Assuming first element is maximum element
		// iterate array
		for (int i = 1; i < a.length; i++) {
			if (a[i] < minElement) {
				minElement = a[i];
			}
		}
		return minElement;
	}

	public static void main(String args[]) {
		int a[] = { 4, 3, 2, 11, 23, 3, 44, 8, 93, 2, 34, 7, 8, 9 };
		System.out.println("MAX Element in array " + findMaxElementInArr(a));
		System.out.println("MIN Element in array " + findMinElementInArr(a));
	}

}
