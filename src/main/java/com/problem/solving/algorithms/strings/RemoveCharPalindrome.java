package com.problem.solving.algorithms.strings;

public class RemoveCharPalindrome {
    static public void main(String args[]) {
        System.out.println(isPalindrome("abccbka"));
    }

    public static boolean isPalindrome(String input) {

        int leftIndex = 0;
        int rightIndex = input.length() - 1;

        while (leftIndex < rightIndex) {

            if (input.charAt(leftIndex) == input.charAt(rightIndex)) {
                leftIndex++;
                rightIndex--;
            } else {

                return (checkPal(input, leftIndex, rightIndex - 1) || checkPal(input, leftIndex + 1, rightIndex));
            }

        }
        return false;

    }

    public static boolean checkPal(String s, int l, int r) {
        while (l < r) {

            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }


        }

        return true;
    }
}
