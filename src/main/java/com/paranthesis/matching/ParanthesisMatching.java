package com.paranthesis.matching;

import java.util.Stack;

/**
 * To find in the expression if paranthesis are matching then return true or return false
 * To solve this, use stack and push the element if opening bracket found
 * Check when we got closing bracket check from stack using peek method if its having opening bracket respect to closing bracket
 * pop the element
 * @author nxf43614
 *
 */
public class ParanthesisMatching {

	public static final Character ROUND_BRACKET_OPEN ='(';
	public static final Character ROUND_BRACKET_CLOSE =')';
	public static final Character CURLY_BRACKET_OPEN ='{';
	public static final Character CURLY_BRACKET_CLOSE ='}';
	public static final Character SQUARE_BRACKET_OPEN = '[';
	public static final Character SQUARE_BRACKET_CLOSE = ']';
	
	/**
	 * 
	 * @param expression
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean isParanthesisMatching(String expression) {
		boolean matching = false;
		@SuppressWarnings("rawtypes")
		Stack parantheshStack = new Stack<Character>();
		for (int i = 0; i < expression.length(); i++) {
			switch (expression.charAt(i)) {
			case '(':
				parantheshStack.push(expression.charAt(i));
				break;
			case '{':
				parantheshStack.push(expression.charAt(i));
				break;
			case '[':
				parantheshStack.push(expression.charAt(i));
				break;
			case ')':
				if (parantheshStack.isEmpty()) {
					matching = false;
				} else if (!parantheshStack.peek().equals(ROUND_BRACKET_OPEN)) {
					matching = false;
				} else {
					parantheshStack.pop();
					matching = true;
				}
				break;
			case '}':
				if (parantheshStack.isEmpty()) {
					matching = false;
				} else if (!parantheshStack.peek().equals(CURLY_BRACKET_OPEN)) {
					matching = false;
				} else {
					parantheshStack.pop();
					matching = true;
				}
				break;
			case ']':
				if (parantheshStack.isEmpty()) {
					matching = false;
				} else if (!parantheshStack.peek().equals(SQUARE_BRACKET_OPEN)) {
					matching = false;
				} else {
					parantheshStack.pop();
					matching = true;
				}
				break;
			default:
				break;
			}
		}
		return matching;
	}

	public static void main (String [] args) {
		ParanthesisMatching paranthisMatching = new ParanthesisMatching();
		String expression = "[{{()}}]";
		System.out.println("Paranthis matching => "+paranthisMatching.isParanthesisMatching(expression));
	}
}
