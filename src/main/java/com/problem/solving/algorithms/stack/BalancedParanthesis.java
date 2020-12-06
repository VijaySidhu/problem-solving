package com.problem.solving.algorithms.stack;

import java.util.Stack;

/**
 * Time Complexity: O(n)
 * Auxiliary Space: O(n) for stack. Algorithm:
 */
public class BalancedParanthesis {

  /*
   i.   Declare a character stack S.
   ii.  Now traverse the expression string exp.
   iii. If Current character is starting bracket push into stack
   iv.  If current character is closing bracket pop from stack
              a) Check if it's closing bracket of current char continue processing
              b) Else brackets are not balanced
   */
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
