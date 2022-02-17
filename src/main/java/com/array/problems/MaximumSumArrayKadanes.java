package com.array.problems;

/**
 * Logic : 
 * Check if the value at any index is greater than of total sum then assign to maxSoFar else skip
 * Calculate sum (maxEnding used here) via adding element present at index and previous sum
 * Now check if the totalSum (maxEnding) is less then current value at index then assign the currentvalue in maxEnding
 * Check maxSoFar, if maximumSumSoFar is less than maxEnding then assign maxEnding to maxSoFar
 * @author Gyanendra Kumar
 *
 */
public class MaximumSumArrayKadanes {

	
	/**
	 * {-2, -3, 4, -1, -2, 1, 5, -3} 
	 * MaxEnding is a cursor which are moving 
	 * @param a
	 * @return
	 */
	static int maxSumArray(int a[]) {
		int maximumSumSoFar = Integer.MIN_VALUE; // start with negative number
		int sum = 0; // start with 0
		for (int i=0; i<a.length;i++) {
			sum = sum + a[i];
			if (sum < a[i]) { // means after adding array value in existing sum, it is decreased. so check is sum is less value(negative no)
				sum = a[i];
			}
			// if maximum value till now is less than sum of maximum index value
			if (maximumSumSoFar < sum) {  
				maximumSumSoFar = sum;
			}
		}
		return maximumSumSoFar;
	}
	
	public static void main (String[] args)
    {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " + maxSumArray(a));
    }
 
}
