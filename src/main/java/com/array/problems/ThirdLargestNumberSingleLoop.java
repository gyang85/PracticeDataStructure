package com.array.problems;

public class ThirdLargestNumberSingleLoop {
	
	/**
	 * Find third largest number
	 * @param array
	 * @return
	 */
	private static int findThirdLargest(int[] array) {
        //3
        int first, second, third;
        //4
        first = second = third = array[0];
        //5
        for (int i = 1; i < array.length; i++) {
            //6
            if (array[i] > first) {
                third = second;
                second = first;
                first = array[i];
            } else if (array[i] > second) {
                //7
                third = second;
                second = array[i];
            } else if (array[i] > third) {
                //8
                third = array[i];
            }
        }
        //9
        return third;
    }
	
	public static void main(String[] args) {
        //1
        int a[] = {4, 3, 2, 11, 23, 3, 44, 8, 93, 2, 34, 7, 8, 9};
        System.out.println("Third largest number is " + findThirdLargest(a));
        Math.pow(2, 3);
    }

}
