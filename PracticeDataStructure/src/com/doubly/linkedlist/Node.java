package com.doubly.linkedlist;

public class Node {
	int value;
	Node previousNode;
	Node nextNode;

	public Node(int value) {
		this.value = value;
		this.nextNode = null;
		this.previousNode = null;
	}
}
