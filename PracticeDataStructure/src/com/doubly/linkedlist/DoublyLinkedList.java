package com.doubly.linkedlist;

/**
 * Created for learning purpose
 * 
 * @author Gyanendra Kumar
 *
 */

public class DoublyLinkedList {

	Node head = null;
	Node tail = null;
	
	public Node addList(Node node, int value) {
		if (node == null) {
			Node newNode = new Node(value);
			head = tail = newNode;
			return newNode;
		} else {
			Node newNode = new Node(value);
			tail.nextNode = newNode;
			newNode.previousNode = tail;
			tail = newNode;
		}
		return node;
	}
	
	/**
	 * Delete element from linked list
	 * @param value
	 */
	public int deleteNode (int value) {
      int deleted = 0;
	  Node currentNode = head;
	  while (currentNode!=null) {
		  if (currentNode.value==value) {
			  Node temp = currentNode.nextNode;
			  currentNode = currentNode.previousNode;
			  currentNode.nextNode = temp;
			  temp.previousNode = currentNode;
			  break;
		  } 
		  currentNode = currentNode.nextNode;
		  
	  }
	  return deleted;
	}
	
	/**
	 * Display list
	 * @param node
	 */
	public void displayList(Node node) {
		Node startNode = node;
		while (startNode!=null) {
			System.out.print(startNode.value+"->");
			startNode = startNode.nextNode;
		}
		System.out.println("\n");
	}
	
	public Node reverseList(Node node) throws Exception {
		if (node==null) {
			throw new Exception("Empty list");
		}
		Node currentNode = node;
		Node temp = null;
		while (currentNode !=null) {
			Node nextNode = currentNode.nextNode;
			currentNode.nextNode = currentNode.previousNode;
			currentNode.previousNode = nextNode;
			currentNode = currentNode.previousNode;
		}
		temp = tail;
		tail = head;
		head = temp;
		return head;
	}
	public static void main(String args[]) throws Exception {
		DoublyLinkedList list = new DoublyLinkedList();
		Node node = null;
	    node = list.addList(node, 1);
	    node = list.addList(node, 2);
	    node = list.addList(node, 3);
	    node = list.addList(node, 4);
	    list.displayList(node);
	    list.deleteNode(2);
	    list.displayList(node);
	    node = list.reverseList(node);
	    list.displayList(node);
	    
	}
	
}
