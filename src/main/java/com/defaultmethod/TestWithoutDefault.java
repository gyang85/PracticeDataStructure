package com.defaultmethod;

public class TestWithoutDefault implements InterfaceWithDefault{

	public void print() {
		printColor();
		
	}
	
	public static void main (String args[]) {
		TestWithoutDefault obj = new TestWithoutDefault();
		obj.print();
	}

}
