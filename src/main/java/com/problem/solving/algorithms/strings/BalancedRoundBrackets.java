package com.problem.solving.algorithms.strings;

public class BalancedRoundBrackets {


    public static void main(String[] args) {
        System.out.println(returnBracketsRequiredToBalance("())("));
        System.out.println(returnBracketsRequiredToBalance("(((())))"));
        System.out.println(returnBracketsRequiredToBalance("))))"));
    }

    public static int returnBracketsRequiredToBalance(String brackets) {

        int open = 0;
        int close = 0;
        int i = 0;
        int j = brackets.length();
        while (i < j) {
            if (brackets.charAt(i) == '(') {
                open++;
            }
            if (brackets.charAt(i) == ')') {
                open--;
            }
            if (open < 0) {
                close++;
                open++;
            }
            i++;
        }
        return close + open;
    }
}
