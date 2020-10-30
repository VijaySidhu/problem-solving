package com.problem.solving.algorithms.stack;

import java.util.Stack;

/**
 * Read the Prefix expression in reverse order (from right to left) If the symbol is an operand,
 * then push it onto the Stack If the symbol is an operator, then pop two operands from the Stack
 * Create a string by concatenating the two operands and the operator between them. string =
 * (operand1 + operator + operand2) And push the resultant string back to Stack Repeat the above
 * steps until end of Prefix expression.
 */
public class PrefixToInfix {

  // Function to check if character
// is operator or not
  static boolean isOperator(char x) {
    switch (x) {
      case '+':
      case '-':
      case '*':
      case '/':
        return true;
    }
    return false;
  }

  // Convert prefix to Infix expression
  public static String convert(String str) {
    Stack<String> stack = new Stack<>();

    // Length of expression
    int l = str.length();

    // Reading from right to left
    for (int i = l - 1; i >= 0; i--) {
      char c = str.charAt(i);
      if (isOperator(c)) {
        String op1 = stack.pop();
        String op2 = stack.pop();

        // Concat the operands and operator
        String temp = "(" + op1 + c + op2 + ")";
        stack.push(temp);
      } else {

        // To make character to string
        stack.push(c + "");
      }
    }
    return stack.pop();
  }

  // Driver code
  public static void main(String[] args) {
    String exp = "*-A/BC-/AKL";
    System.out.println("Infix : " + convert(exp));
  }
}
