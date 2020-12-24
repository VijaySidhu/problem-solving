package com.problem.solving.algorithms.arrays;

import java.util.Stack;

/*
    Given an absolute path for a file (Unix-style), simplify it.
    Or in other words, convert it to the canonical path.
 */
public class SimplifyPath {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
    }
    /*
      1. If File name encounters push into stack
      2. If . encounters do nothing
      3. If .. encounters pop top element from stack because we need to jump back to parent directory
      4. When we see //// just ignore them because it's equivalent to /
     */

    public static String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : paths) {
            if (s.equals(".")) {
                // Do nothing
            }
            // We need to jump back to parent directory
            else if (s.equalsIgnoreCase("..")) {
                // If stack is not empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (s.length() > 0) {
                stack.push(s);
            }
        }

        // Build Result
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : stack) {
            stringBuilder.append("/" + s);
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append("/");
        }

        return stringBuilder.toString();
    }

}
