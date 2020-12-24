package com.problem.solving.algorithms.arrays;

public class AddBinaryStrings {
    public static void main(String[] args) {
        System.out.println(addBinaryStrings("011", "011"));
    }

    /*
      The idea is to start from last characters of two strings and compute digit sum one by one.
      If sum becomes more than 1, then store carry for next digits.
     */
    public static String addBinaryStrings(String a, String b) {
        String result = "";
        // Initialize digit sum
        int sum = 0;
        // Traverse both strings starting from last characters
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j > 0 || sum == 1) {
            // Compute sum of last
            // digit and carry
            sum += ((i >= 0) ? a.charAt(i) - '0' : 0);
            sum += ((j >= 0) ? b.charAt(j) - '0' : 0);
            // If current digit sum is
            // 1 or 3, add 1 to result
            result = (char) (sum % 2 + '0') + result;

            // Compute carry
            sum /= 2;

            // Move to next digits
            i--;
            j--;

        }
        return result;
    }

}
