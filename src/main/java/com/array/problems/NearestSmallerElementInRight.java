package com.array.problems;

import java.util.Arrays;
import java.util.Stack;

/**
 * Find nearest smaller element in right 
 * Solution: { 2, 4, 1, 15, 3, 5, 30, 12 }
 * Read from right and push the element in stack
 * Do peek from stack and check if the current element is greater than peek then return element. if not found do pop element until its found
 * if stack went empty then return -1 and push the current element
 * @author nxf43614
 *
 */
public class NearestSmallerElementInRight {

	public int[] findNearestSmallerinRight(int arr[]) {
		int [] smallerElementArray = new int[arr.length];
		Stack<Integer> elementStack = new Stack<Integer>();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (elementStack.isEmpty()) {
				elementStack.push(arr[i]);
				smallerElementArray[i]=-1;
			} else {
				if (elementStack.peek()<arr[i]) {
					smallerElementArray[i] = elementStack.peek();
					elementStack.push(arr[i]);
				} else {
					boolean smallerFound = false;
					while (!elementStack.isEmpty()) {
						if (elementStack.peek()<arr[i]) {
							smallerElementArray[i] = elementStack.peek();
							elementStack.push(arr[i]);
							smallerFound = true;
							break;
						} else {
							elementStack.pop();
						}
					}
					if (!smallerFound) {
						elementStack.push(arr[i]);
						smallerElementArray[i] = -1;
					}
				}
			}
		}
		return smallerElementArray;
	}
	
	public static void main (String args[]) {
		int arr[] = { 2, 4, 1, 15, 3, 5, 30, 12 };
		System.out.println("Original array => " + Arrays.toString(arr));
		NearestSmallerElementInRight smallElement = new NearestSmallerElementInRight();
		System.out.println("Nearest smaller element in the right in the array =>"
				+ Arrays.toString(smallElement.findNearestSmallerinRight(arr)));
	}
}
