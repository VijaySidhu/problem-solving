package com.problem.solving.algorithms.arrays;

public class LastWordLength {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));

    }

    public static int lengthOfLastWord(String s) {
        int length = s.length() - 1;
        int count = 0;
        for (int i = length; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            } else {
                count++;
            }

        }
        return count;
    }
}
