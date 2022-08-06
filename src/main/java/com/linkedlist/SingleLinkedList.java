package com.linkedlist;

public class SingleLinkedList {

	/**
	 * List all items
	 * @param head
	 */
	public void listNode (Node head) {
		Node startNode = head;
		while (startNode.nextNode!=null) {
			System.out.print(startNode.value+"->");
			startNode = startNode.nextNode;
		}
		System.out.print(startNode.value+"->");
	}
	
	public Node addItem(Node existingItems, int value) {
		Node newNode = null;
		if (existingItems == null) {
			 newNode = new Node(value);
			 existingItems = newNode;
		} else {
			// reach to end of list
			Node startNode = existingItems;
			while (startNode.nextNode != null) {
				startNode = startNode.nextNode;
			}
			// insert node at last
			newNode = new Node(value);
			startNode.nextNode = newNode;
		}
		return existingItems;
	}
	
	/**
	 * Reverse singly linked list
	 * @param head
	 * @return
	 */
	public Node reverse(Node head) {
		Node previous = head;
		Node current = head;
		Node nextNode = current.nextNode;
		head.nextNode = null;
		while (nextNode != null) {
			current = nextNode;
			nextNode = nextNode.nextNode;
			current.nextNode = previous;
			previous = current;
		}
		Node lastNode = current;
		return lastNode;
	}
	
	public static void main(String args[]) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		Node node = null;
		node = singleLinkedList.addItem(node, 1);
		node = singleLinkedList.addItem(node, 2);
		node = singleLinkedList.addItem(node, 3);
		node = singleLinkedList.addItem(node, 4);
		node = singleLinkedList.addItem(node, 5);
		singleLinkedList.listNode(node);
		Node reversed = singleLinkedList.reverse(node);
		System.out.println("after reversal");
		singleLinkedList.listNode(reversed);
		
	}
}
