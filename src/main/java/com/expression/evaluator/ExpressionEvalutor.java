package com.expression.evaluator;

import java.util.Stack;

public class ExpressionEvalutor {

	/**
	 * Logic to calculator expression evaluator
	 * 
	 * Create two stack, one for operator and another for operands
	 * Push operator in operator stack and push operand in operand stack
	 * During push check if high priority operator is already available in the stack
	 * If higher priority operator is there then pop the operator from operand and pop two element (v1,v2) from operand stack
	 * Perform operation and push operand result into operand stack
	 * If same priority operator are there then whoever is comes first it will be calculated
	 * if we get close closing operator then all the operator will be poped until open bracked comes
	 * @param operator
	 * @return
	 */
	
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
	
	public static boolean isOperator(Character data) {
		if (data.equals('+') || data.equals('-') || data.equals('*') || data.equals('/') || data.equals('(')|| data.equals(')')) {
			return true;
		}
		return false;
	}
	
	public static Integer performOperation(Character operator, Integer value1, Integer value2) {
		Integer result;
		switch(operator) {
		case '+':
			result = value1+value2;
			break;
		case '-':
			result = value1-value2;
			break;
		case '%':
			result = value1%value2;
			break;
		case '*':
			result = value1*value2;
			break;
		case '/':
			result = value1/value2;
			break;
			default:
				return 0;
		
		}
		return result;
	}
	public static void main(String args[]) {
		String expression = "2+4*(3/2+2)";
		Stack<Integer> operands = new Stack();
		Stack<Character> operators = new Stack();
		char[] charArray = expression.toCharArray();
		for (int i=0; i<charArray.length; i++) {
			if (isOperator(charArray[i])) {
				// check precendence of operator before pushing
				if (operators.isEmpty()) {
					operators.push(charArray[i]);
				} else if (charArray[i]==')') {
						// need to pop operator until receive opening bracket
						while (operators.peek().charValue()!='(') {
							Character op = operators.pop();
							Integer value2 = operands.pop();
							Integer value1 = operands.pop();
							Integer result = performOperation(op, value1, value2);
							operands.push(result);
						}
						operators.pop();
				} else if (getOperatorPrecedenece(charArray[i]) <= getOperatorPrecedenece(
						operators.peek()) && charArray[i]!='(' && operators.peek()!='(') {
					Character op = operators.pop();
					Integer value2 = operands.pop();
					Integer value1 = operands.pop();
					Integer result = performOperation(op, value1, value2);
					operands.push(result);
					operators.push(charArray[i]);
				} else {
					operators.push(charArray[i]);
				}
			} else {
				operands.push(Integer.parseInt(String.valueOf(charArray[i])));
			}
		}
		
		while (!operators.isEmpty()) {
			Character op = operators.pop();
			Integer value2 = operands.pop();
			Integer value1 = operands.pop();
			Integer result = performOperation(op, value1, value2);
			operands.push(result);
		}
		
		int result = operands.pop();
		System.out.println("Expression result =>"+ result);
	}
}
