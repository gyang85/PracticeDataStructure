package com.array.problems;

import java.util.Arrays;
import java.util.Stack;

/**
 * This algorithm is used to find the nearest smaller element in the left in the array
 * Solution :
 * 
 * Use one stack where we will check if top element is smaller then return the smaller element or pop the element until got smaller element
 * and then push the current element. we will do the same for all the element and store smaller element in the corresponding array
 * @author nxf43614
 *
 */
public class NearestSmallestElementLeft {

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public int[] findNearestSmallerElement(int[] arr) {
		int[] smallerElementArr = new int[arr.length];
		Stack<Integer> stackForSmaller = new Stack<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (stackForSmaller.isEmpty()) {
				stackForSmaller.push(arr[i]);
				smallerElementArr[i] = -1;
			} else {
				boolean smallerFound = false;
				while (!stackForSmaller.isEmpty()) {
					if (stackForSmaller.peek() < arr[i]) {
						smallerElementArr[i] = stackForSmaller.peek();
						stackForSmaller.push(arr[i]);
						smallerFound = true;
						break;
					} else {
						stackForSmaller.pop();
					}
				}
				if (!smallerFound) {
					smallerElementArr[i] = -1;
					stackForSmaller.push(arr[i]);
				}
			}
		}
		return smallerElementArr;

	}

	public static void main(String args[]) {
		int arr[] = { 4, 14, 1, 5, 9, 12, 45 };
		System.out.println("Original array => " + Arrays.toString(arr));
		NearestSmallestElementLeft smallElement = new NearestSmallestElementLeft();
		System.out.println("Nearest smaller element in the array =>"
				+ Arrays.toString(smallElement.findNearestSmallerElement(arr)));
	}
}
