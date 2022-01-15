package com.expression.evaluator;

import java.util.Stack;

public class InfixToPostFix {

	public static final Character OPENING_BRACKET = '(';
	public static final Character CLOSING_BRACKET = ')';

	public String inFixToPostFix(String expression) {
		StringBuilder converted = new StringBuilder();
		Stack operatorStack = new Stack<Character>();
		char[] array = expression.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (isOperator(array[i])) {
				if (operatorStack.isEmpty()) {
					operatorStack.push(array[i]);
				} else {
					//System.out.println("Operator - " + array[i]);
					// get operator precedance
					int lastOperatorPrecedance = getOperatorPrecedenece((Character) operatorStack.peek());
					int currentOperatorPrecedance = getOperatorPrecedenece(array[i]);
					/** Handling closing bracket */
					if (isClosingBracket(array[i])) {
						while (operatorStack.peek() != OPENING_BRACKET) {
							converted.append(operatorStack.pop());
						}
						operatorStack.pop();
					} else {
						/**
						 * push the operator is found higher precendence else pop it until found lower
						 * precedance operator
						 */
						if (currentOperatorPrecedance > lastOperatorPrecedance
								|| operatorStack.peek().equals(OPENING_BRACKET)) {
							operatorStack.push(array[i]);
						} else {
							while (!operatorStack.isEmpty() && currentOperatorPrecedance <= getOperatorPrecedenece(
									(Character) operatorStack.peek())) {
								converted.append(operatorStack.pop());
							}
							operatorStack.push(array[i]);
						}
					}
				}

			} else {
				converted.append(array[i]);
			}
		}
		popAllOperator(converted, operatorStack);
		return converted.toString();

	}

	/**
	 * Pop all the operator and append to postfix
	 * 
	 * @param converted
	 * @param operatorStack
	 */
	public void popAllOperator(StringBuilder converted, Stack operatorStack) {
		while (!operatorStack.isEmpty()) {
			converted.append(operatorStack.pop());
		}
	}

	/**
	 * Check if character is closing bracket
	 * 
	 * @param data
	 * @return
	 */
	public boolean isClosingBracket(Character data) {
		if (data.equals(CLOSING_BRACKET)) {
			return true;
		}
		return false;
	}

	public static boolean isOperator(Character data) {
		if (data.equals('+') || data.equals('-') || data.equals('*') || data.equals('/') || data.equals('(')
				|| data.equals(')')) {
			return true;
		} else {
			return false;
		}
	}

	public static int getOperatorPrecedenece(Character operator) {
		if (operator.equals('+') || operator.equals('-')) {
			return 1;
		} else if (operator.equals('*') || operator.equals('/') || operator.equals('%')) {
			return 2;
		} else if (operator.equals('(') || operator.equals(')')) {
			return 3;
		}
		return -1;
	}

	public static void main(String args[]) {
		InfixToPostFix infixToPostfix = new InfixToPostFix();
		String infixExpression = "a+(b*c)-d"; 
		// a+(b*c)-d - postfix=>  abc*+d-
		// a+(b*c)-d - prefix=>  -+a*bcd
		System.out.println("Infix expression " + infixExpression);
		System.out.println("PostFix expression " + infixToPostfix.inFixToPostFix(infixExpression));
	}
}
