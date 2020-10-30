package com.problem.solving.algorithms.stack;

import java.util.Stack;

/**
 * Time Complexity: O(n) Auxiliary Space: O(n) for stack. Algorithm:
 * <p>
 * Declare a character stack S. Now traverse the expression string exp. If the current character is
 * a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack. If the current character is a
 * closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and if the popped character is the
 * matching starting bracket then fine else parenthesis are not balanced. After complete traversal,
 * if there is some starting bracket left in stack then “not balanced”
 */
public class BalancedParanthesis {

  static boolean areBalancedParanthesis(String expression) {

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < expression.length(); i++) {
      char currentChar = expression.charAt(i);
      if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
        stack.push(currentChar);
        continue;
      }
      if (stack.isEmpty()) {
        return false;
      }
      char check;
      switch (currentChar) {
        case ')':
          check = stack.pop();
          if (check == '{' || check == '[') {
            return false;
          }
          break;

        case '}':
          check = stack.pop();
          if (check == '(' || check == '[') {
            return false;
          }
          break;

        case ']':
          check = stack.pop();
          if (check == '(' || check == '{') {
            return false;
          }
          break;
      }
    }
    return (stack.isEmpty());
  }

  // Driver code
  public static void main(String[] args) {
    String expr = "([{}])";

    // Function call
    if (areBalancedParanthesis(expr)) {
      System.out.println("Balanced ");
    } else {
      System.out.println("Not Balanced ");
    }
  }

}
