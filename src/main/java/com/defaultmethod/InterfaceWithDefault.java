package com.defaultmethod;

public interface InterfaceWithDefault {

	public void print();
	default void printColor() {
		System.out.println("Test");
	}
	
}
