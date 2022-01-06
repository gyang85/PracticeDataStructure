package com.heap;

import java.util.Vector;

/**
 * Heap Data structure is widely used data structure
 * Implemented in Priority queue as implementation in JAVA
 * 
 * Below logic need to implement for heapify
 * What is heapify -> after adding element we compare element with parent and do swap if it is less
 * Do this recursively till top node
 * 
 * Step 1 : Add the element in the last of the array
 * Now check if new element is lar
 * Below is max heap example. Parent node should be greater than child
 * 
 *   	   50 
 	  	 /    \
		35     30  
	   /  \    /  \
	  20  15   10  5
  
 */
public class Heap {

	Vector<Integer> list;
	
	public Heap() {
		list = new Vector();
	}
	public void addItem(int data) {
		list.add(data);
		// call to heapify
		// get the last element which is added
		int lastElementIndex = list.size()-1;
		heapifyUp(lastElementIndex);
	}
	
	public int parent(int i) {
		if (i==0) {
			return 0;
		}
		return (i-1)/2; // i-1 we are keeping as elements storing from 0th position
	}
	
    // return left child of `A[i]`
    private int getleftChildIndex(int i) {
        return (2*i + 1);
    }
 
    // return right child of `A[i]`
    private int getRightChildIndex(int i) {
        return (2*i + 2);
    }
	/**
	 * This method required to arrange the element in maxHeap property
	 * @param index
	 */
	public void heapifyUp(int index){
		// fetch parent node index (index/2)
		if (index>0 && list.get(parent(index))< list.get(index)) {
			// swap the element
			int parentElement = list.get(parent(index));
			list.setElementAt(list.get(index),parent(index));
			list.setElementAt(parentElement, index);
			heapifyUp(parent(index));
		}
	}
	
	/**
	 * This method to heapify downside tree
	 * @param index
	 */
	public void heapifyDown(int index) {
	
	 int leftIndex = getleftChildIndex(index);
	 int rightIndex = getRightChildIndex(index);
	 if (leftIndex>list.size()-1 || rightIndex>list.size()-1) {
		 return;
	 }	
	 int largerIndex = (list.get(leftIndex) > list.get(rightIndex))? leftIndex : rightIndex;
	 if (list.get(largerIndex)> list.get(index)){
		 // swap the element
		 int temp = list.get(index);
		 list.setElementAt(list.get(largerIndex), index);
		 list.setElementAt(temp, largerIndex);
		 heapifyDown(largerIndex);
	 }
	}
	
	public void remove() {
		// remove will always delete element from top
		list.setElementAt(list.get(list.size()-1), 0);
		list.remove(list.size()-1);
		heapifyDown(0);
	}
	public static void main(String[] args) {
		Heap heapDS = new Heap();
		heapDS.addItem(40);
		heapDS.addItem(60);
		heapDS.addItem(45);
		heapDS.addItem(15);
		heapDS.addItem(25);
		heapDS.addItem(35);
		heapDS.addItem(65);
		heapDS.addItem(5);
		Object[] arr = heapDS.list.toArray();
		for (int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		System.out.println("\n\n");
		heapDS.remove();
		Object[] arr1 = heapDS.list.toArray();
		for (int i=0;i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		
	}

}
