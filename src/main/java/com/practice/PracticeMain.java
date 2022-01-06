package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeMain {

	public static void main(String[] args) {
		System.out.println("Entering main..");
		int []arr = {5, 2, 6, 8, 1, 9};
		int sum = 12;
		///findPair(arr, sum);
		int[] b = {  3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
		checkSubArrayWithZeroSum(b);
	}

	/**
	 * find a pair with given sum in  an array
	 * @param a
	 * @param targetSum
	 */
	public static void findPair(int []a, int targetSum) {
		boolean pairFound = false;
		for (int i=0; i< a.length;i++) {
			for (int j=0; j<a.length;j++) {
				if (i!=j && j>i) {
					int sum = a[i]+a[j];
					if (sum==targetSum) {
						System.out.println("Pair found "+a[i]+ " "+a[j]);
						pairFound = true;
					}
				}
			}
		}
		if (!pairFound) {
			System.out.println("No Pair found ");
		}
	}
	
	/**
	 * Check if subarray with zero sum
	 * @param a
	 * Sample { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }
	 */
	public static void checkSubArrayWithZeroSum(int []a) {
		int sum =0;
		List<String> subarry = new ArrayList();
		for (int i=0;i<a.length;i++) {
			sum = 0;
			sum = a[i];
			subarry.clear();
			subarry.add(String.valueOf(a[i]));
			for (int j=1;j<a.length;j++) {
				if (i!=j && j>i) {
					sum = sum + a[j];
					subarry.add(String.valueOf(a[j]));
					if (sum == 0) {
						System.out.println("subarray found "+subarry.toString());
					}
				}
			}
		}
	}
}
