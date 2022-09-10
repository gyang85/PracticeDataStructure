package com.tree;

public class Tree {

	Tree leftChild;
	Tree rightChild;
	Tree parent;
	int data;
	public Tree(int value) {
		this.data = value;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
	}
}
