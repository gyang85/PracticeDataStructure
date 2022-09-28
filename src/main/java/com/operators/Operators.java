package com.operators;

public class Operators {

	/**
	 * Operators
	 * 
	 * ^ - bitwise xor operator  => If a single operand is a one, returns a one in a bit position
	 * & - bitwise and operator => If bits of both operands are ones, returns a one in each bit position
	 * | - bitwise or operator =>  If bits of either operand are ones, returns a one in a bit position
	 * ~ - Bitwise NOT => Flips the bits in the operand
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 5;
		int b = 2;
		int result = a ^ b;
		System.out.println("a converted to bits " + Integer.toBinaryString(a));
		System.out.println("b converted to bits " + Integer.toBinaryString(b));
		System.out.println("bitwise xor operator operation result " + Integer.toBinaryString(result));
		
		System.out.println("bitwise or operator operation result " + Integer.toBinaryString(a | b));
		System.out.println("bitwise and operator operation result " + Integer.toBinaryString(a & b));
		System.out.println("XOR operation result " + result);
		System.out.println("bitwise not result" + Integer.toBinaryString(~a));

	}

}
