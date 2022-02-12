package com.tree;

public class Tree {

	Tree leftChild;
	Tree rightChild;
	int data;
	
	public Tree(int value) {
		this.data = value;
		this.leftChild = null;
		this.rightChild = null;
	}
}
