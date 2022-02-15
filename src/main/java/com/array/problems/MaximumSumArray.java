package com.array.problems;

public class MaximumSumArray {

	public static int maxSubArray(int[] nums) {
		 
	    int n = nums.length;
	    int maximumSubArraySum = Integer.MIN_VALUE;
	    int start = 0;
	    int end = 0;
	 
	    for (int left = 0; left < n; left++) {
	 
	        int runningWindowSum = 0;
	 
	        for (int right = left; right < n; right++) {
	            runningWindowSum += nums[right];
	 
	            if (runningWindowSum > maximumSubArraySum) {
	                maximumSubArraySum = runningWindowSum;
	                start = left;
	                end = right;
	            }
	        }
	    }
	    System.out.println("Found Maximum Subarray between "+ start +" and "+end);
	    return maximumSubArraySum;
	}
	
	public static void main (String args[]) {
		int elements[]= {-2,2,-1,7,3};
		int sum = maxSubArray(elements);
		System.out.println("Maximum sum = "+sum);
	}
}
