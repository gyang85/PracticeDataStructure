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
		/*Example :
		
		int arr[] = { 2, 4, 1, 15};
		The logic is below

		Here we need to find smallest number in the left for each element. so lets begin

		Two things required

		1. array -> this will have the same array length and contain smaller element for each element index
		2. stack -> this will keep only smaller element

		Now start iterating from index 0

		for element 0th index 2 -> There is no element present in the stack so push the 2 in the stack
		Element 1st index 4 -> check in the stack using peek which is 2 , so 2 is less than 4. hence push 4 in the stack. put 2 in another array for 1st index. as 2 is smaller than 4
		Element 2nd index 1 -> check the stack using peek which is 4 and 4 is greater than 1 so pop the element,
		                       repeat the same for next peek element which 2 so 2 is greater than 1 so pop the element
							   Now stack is empty so push the 1 in the stack
		Element 3rd index 15 -> perform stack.peek -> 1, which is less than 15, so add 1 in another array at index 3rd and push 15 in the stack

		Now array is completed so program will exit*/


		System.out.println("Original array => " + Arrays.toString(arr));
		NearestSmallerElementInRight smallElement = new NearestSmallerElementInRight();
		System.out.println("Nearest smaller element in the right in the array =>"
				+ Arrays.toString(smallElement.findNearestSmallerinRight(arr)));
	}
}
