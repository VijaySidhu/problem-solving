package com.problem.solving.algorithms.stack;
/*Read the Prefix expression in reverse order (from right to left)
If the symbol is an operand, then push it onto the Stack
If the symbol is an operator, then pop two operands from the Stack
Create a string by concatenating the two operands and the operator after them.
string = operand1 + operand2 + operator
And push the resultant string back to Stack
Repeat the above steps until end of Prefix expression.
*/

import java.util.Stack;

public class PreToPostFix {

  // funtion to check if character
  // is operator or not
  static boolean isOperator(char x) {
    switch (x) {
      case '+':
      case '-':
      case '/':
      case '*':
        return true;
    }
    return false;
  }

  // Convert prefix to Postfix expression
  static String preToPost(String pre_exp) {

    Stack<String> s = new Stack<String>();

    // length of expression
    int length = pre_exp.length();

    // reading from right to left
    for (int i = length - 1; i >= 0; i--) {
      // check if symbol is operator
      if (isOperator(pre_exp.charAt(i))) {
        // pop two operands from stack
        String op1 = s.peek();
        s.pop();
        String op2 = s.peek();
        s.pop();

        // concat the operands and operator
        String temp = op1 + op2 + pre_exp.charAt(i);

        // Push String temp back to stack
        s.push(temp);
      }

      // if symbol is an operand
      else {
        // push the operand to the stack
        s.push(pre_exp.charAt(i) + "");
      }
    }

    // stack contains only the Postfix expression
    return s.peek();
  }

  // Driver Code
  public static void main(String args[]) {
    String pre_exp = "*-A/BC-/AKL";
    System.out.println("Postfix : "
        + preToPost(pre_exp));
  }
}
