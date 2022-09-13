package com.array.problems;

public class ThirdLargestNumberSingleLoop {
	
	/**
	 * Find third largest number
	 * @param array
	 * @return
	 */
	private static int findThirdLargest(int[] array) {
		// First initialize with minimum integer value 
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
        	// check if array element is greater then first largest then move first largest value to second largest and second largest to third
        	// largest
            if (array[i] > firstLargest) {
            	thirdLargest = secondLargest;
                secondLargest = firstLargest;
                firstLargest = array[i];
            } else if (array[i] > secondLargest) {
                //In this condition we will check if array element is not greater than with first largest but it is larger than second
            	// then assign second largest to third largest and assign second largest value with array element
                thirdLargest = secondLargest;
                secondLargest = array[i];
            } else if (array[i] > thirdLargest) {
            	//In this condition we will check if array element is not greater than with first & second largest but it is larger than third
            	// then assign third largest value with array element
                thirdLargest = array[i];
            }
        }
        //9
        return thirdLargest;
    }
	
	public static void main(String[] args) {
        //1
        int a[] = {4, 3, 2, 11, 23, 3, 44, 8, 93, 2, 34, 7, 8, 9};
        System.out.println("Third largest number is " + findThirdLargest(a));
        Math.pow(2, 3);
    }

}
