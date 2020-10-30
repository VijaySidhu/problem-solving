package com.problem.solving.algorithms.stack;

import java.util.Stack;

/**
 * 1.While there are input symbol left …1.1 Read the next symbol from the input. 2.If the symbol is
 * an operand …2.1 Push it onto the stack. 3.Otherwise, …3.1 the symbol is an operator. …3.2 Pop the
 * top 2 values from the stack. …3.3 Put the operator, with the values as arguments and form a
 * string. …3.4 Push the resulted string back to stack. 4.If there is only one value in the stack
 * …4.1 That value in the stack is the desired infix string.
 */
public class PostToInfix {

  static boolean isOperand(char x) {
    return (x >= 'a' && x <= 'z') ||
        (x >= 'A' && x <= 'Z');
  }

  // Get Infix for a given postfix
// expression
  static String getInfix(String exp) {
    Stack<String> s = new Stack<String>();
    for (int i = 0; i < exp.length(); i++) {
      // Push operands
      if (isOperand(exp.charAt(i))) {
        s.push(exp.charAt(i) + "");
      }

      // We assume that input is
      // a valid postfix and expect
      // an operator.
      else {
        String op1 = s.peek();
        s.pop();
        String op2 = s.peek();
        s.pop();
        s.push("(" + op2 + exp.charAt(i) +
            op1 + ")");
      }
    }

    // There must be a single element
    // in stack now which is the required
    // infix.
    return s.peek();
  }

  // Driver code
  public static void main(String args[]) {
    String exp = "ab*c+";
    System.out.println(getInfix(exp));
  }
}
