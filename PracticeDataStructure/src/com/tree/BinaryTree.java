package com.tree;

import java.util.Scanner;

/**
 * A tree whose elements have at most 2 children is called a binary tree. 
 * Since each element in a binary tree can have only 2 children, we typically name them the left and right child.
 * @author nxf43614
 *
 */
public class BinaryTree {

	static Scanner sc = null;
	
	/**
	 * Below function will create BinaryTree
	 * This will add continuosly node in the left until you enter -1
	 * after entering -1 it will visit to root and ask for entering data for right
	 * if data is -1 it will check for parent
	 * @return
	 */
	public static Tree createTree() {
		System.out.println("Enter the data");
		int data = sc.nextInt();
		// Pass -1 to exist from recursion
		if (data ==-1) return null;
		Tree root = new Tree(data);
		System.out.println("Enter data for left of " + data);
		root.leftChild = createTree();
		System.out.println("Enter data for right of " + data);
		root.rightChild = createTree();
		return root;
	}
	
	/**Inorder traversal
	 * InOrder follows left Node Right
	 * @param root
	 */
	public void inOrder(Tree root) {
		if (root == null) {
			return;
		}
		inOrder(root.leftChild);
		System.out.println(root.data);
		inOrder(root.rightChild);
	}
	
	/** preOrder traversal
	 *  preOrder follows Node Left Right
	 * @param root
	 */
	public void preOrder(Tree root) {
		if (root == null) return;
		System.out.println(root.data);
		preOrder(root.leftChild);
		preOrder(root.rightChild);
	}
	
	/** postOrder traversal
	 *  postOrder follows Left Right node
	 * @param root
	 */
	public void postOrder(Tree root) {
		if (root == null) return;
		preOrder(root.leftChild);
		preOrder(root.rightChild);
		System.out.println(root.data);
	}
	
	public static void main (String args[]) {
		sc = new Scanner(System.in);
		Tree root = createTree();
		System.out.println(root.data);
	}
}
