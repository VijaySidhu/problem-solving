package com.problem.solving.algorithms.strings;

import java.util.Stack;

/*
Given an expression with only ‘}’ and ‘{‘. The expression may not be balanced.
Find minimum number of bracket reversals to make the expression balanced.
Input:  exp = "}{"
Output: 2
 */
public class MinimumBracketReversal {

    /*
    Approach :
       1. Remove all balanced brackets from string
       2. From remaining string we need [m/2]+[n%2] reversal e.g }}}}{{ requires 2+1 reversals

       Time Complexity: O(n)
       Auxiliary Space: O(n)
     */

    public static void main(String[] args) {
        Stack<Character> unbalancedString = removeBalancedBrackets("}}{{");
        int reducedLength = unbalancedString.size();
        int n = 0;
        while (!unbalancedString.isEmpty()) {
            unbalancedString.pop();
            n++;
        }
        System.out.println((reducedLength / 2) + (n % 2));
    }


    public static Stack<Character> removeBalancedBrackets(String brackets) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < brackets.length(); i++) {
            char c = brackets.charAt(i);
            if (c == '}' && !stack.isEmpty()) {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack;
    }
}
