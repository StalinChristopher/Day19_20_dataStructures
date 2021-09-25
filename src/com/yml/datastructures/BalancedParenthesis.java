package com.yml.datastructures;

import java.util.Scanner;

import com.yml.stack.Stack;

public class BalancedParenthesis {
	Stack stack = new Stack();

	public static void balancedParenthesis() {
		BalancedParenthesis balancedParenthesis = new BalancedParenthesis();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the expression to be checked :");
		String input = scanner.nextLine();

		balancedParenthesis.isBalanced(input);
		scanner.close();
	}

	/**
	 * method to check for balanced parenthesis
	 * 
	 * @param expression
	 */
	public void isBalanced(String expression) {

		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(') {
				stack.push(expression.charAt(i));
			} else if (expression.charAt(i) == ')') {
				stack.pop();
			}
		}

		if (stack.isEmpty()) {
			System.out.println("Balanced Parenthesis");
		} else {
			System.out.println("Unbalanced Parenthesis");
		}
	}
}
