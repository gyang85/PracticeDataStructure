package com.expression.evaluator;

/**
 * Infix to prefix
 * 
 * @author nxf43614 Logic : Below are the logic to convert infix to prefix
 * 
 *         1. Reverse the infix string => while reversing update closing bracket
 *         with open bracket and open bracket to closing bracket 2. Now convert
 *         the string into postfix 3. reverse the output
 */
public class InfixToPrefix {
	public static final Character OPENING_BRACKET = '(';
	public static final Character CLOSING_BRACKET = ')';

	/**
	 * Convert into reverse expression
	 * 
	 * @param expression
	 * @return
	 */
	public String reverseExpression(String expression) {
		StringBuilder reverseExpressionBuilder = new StringBuilder();
		for (int i = expression.length() - 1; i >= 0; i--) {
			if (expression.charAt(i) == CLOSING_BRACKET) {
				reverseExpressionBuilder.append(OPENING_BRACKET);
			} else if (expression.charAt(i) == OPENING_BRACKET) {
				reverseExpressionBuilder.append(CLOSING_BRACKET);
			} else {
				reverseExpressionBuilder.append(expression.charAt(i));
			}
		}
		System.out.println("Reverse Expression => " + reverseExpressionBuilder.toString());
		return reverseExpressionBuilder.toString();
	}

	public String reversePostFixOutput(String expression) {
		StringBuilder reverseExpressionBuilder = new StringBuilder();
		for (int i = expression.length() - 1; i >= 0; i--) {
			reverseExpressionBuilder.append(expression.charAt(i));
		}
		return reverseExpressionBuilder.toString();
	}

	public static void main(String[] args) {
		InfixToPrefix infixToPrefix = new InfixToPrefix();
		InfixToPostFix infixToPostFix = new InfixToPostFix();
		String expression = "a+(b*c)-d";
		System.out.println("Infix Expression => " + expression);
		String reverseExpression = infixToPrefix.reverseExpression(expression);
		String postFixExpression = infixToPostFix.inFixToPostFix(reverseExpression);
		System.out.println("Postfix Expression => " + postFixExpression);
		String preFixExpression = infixToPrefix.reversePostFixOutput(postFixExpression);
		System.out.println("Prefix Expression => " + preFixExpression);
	}

}
