package com.problem.solving.algorithms.stack;

/*
 Given a string containing just the characters '(' and ')',
 find the length of the longest valid (well-formed) parentheses substring.
 */
public class LongestValidParenthesis {

/*  BRUTE FORCE
    Time complexity : O(n^3)
        Generating every possible substring from a string of length nn requires O(n^2)
        Checking validity of a string of length nn requires O(n).
    Space complexity : O(n). A stack of depth n will be required for the longest substring.
    i. Every time we encounter opening bracket push into stack
    ii. For every closing bracket we pop it from stack if opening bracket is not available on stack
    for popping at anytime or if stack containes some elements after processing
    complete substring, the substring of parentheses is invalid. In this way, we repeat the process for every possible
    substring and we keep on storing the length of the longest valid string found so far.
    */

    /* Approach 2
    i. For every opening bracket encountered, we push its index onto stack
    ii. For every closing bracket, we pop from stack and subtract the current elements index from top element
    of the stack, which gives the length of the currently encountered valid string of parentheses.
        a) If while popping stack becomes empty, push the current element's index onto the stack
    iii In this way we keep calculating the lengths of valid substrings and return the length of longest valid
        string
      TC O(n)
      SC O(n)
    */

    /* Efficient approach without extra space
            TC O(n)
            SC O(1)
    i. Take two counters left and right.
    ii. Traverse string from left to right and for every opening bracket increment left counter
        and for each closing bracket increment right counter
    iii. When left is equal to right we calculate the length of current valid string and keep track of max
         length substring found so far.
           a) If right becomes greater than left we reset left and right to 0.
     */
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));

    }

    public static int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}

