package com.problem.solving.algorithms.strings;

public class LongestCommonSubsequence {

    /**
     * Leetcode 1143
     * TC and SC :: O(M*N)
     *
     * @return
     */
    public static int longestCommonSubSequence(String text1, String text2) {

        // Make a grid of 0's with text2.length() + 1 columns
        // and text1.length() + 1 rows.
        int[][] dpGrid = new int[text1.length() + 1][text2.length() + 1];

        // Iterate up each column, starting from the last one.
        for (int col = text2.length() - 1; col >= 0; col--) {
            for (int row = text1.length() - 1; row >= 0; row--) {
                // If the corresponding characters for this cell are the same...
                if (text1.charAt(row) == text2.charAt(col)) {
                    dpGrid[row][col] = 1 + dpGrid[row + 1][col + 1];
                    // Otherwise they must be different...
                } else {
                    dpGrid[row][col] = Math.max(dpGrid[row + 1][col], dpGrid[row][col + 1]);
                }
            }
        }

        // The original problem's answer is in dp_grid[0][0]. Return it.
        return dpGrid[0][0];
    }

    /*
    TC O(MN)
    SC O(Min(M,N))
     */
    public int longestCommonSubsequence(String text1, String text2) {

        // If text1 doesn't reference the shortest string, swap them.
        if (text2.length() < text1.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        // The previous column starts with all 0's and like before is 1
        // more than the length of the first word.
        int[] previous = new int[text1.length() + 1];

        // Iterate through each column, starting from the last one.
        for (int col = text2.length() - 1; col >= 0; col--) {
            // Create a new array to represent the current column.
            int[] current = new int[text1.length() + 1];
            for (int row = text1.length() - 1; row >= 0; row--) {
                if (text1.charAt(row) == text2.charAt(col)) {
                    current[row] = 1 + previous[row + 1];
                } else {
                    current[row] = Math.max(previous[row], current[row + 1]);
                }
            }
            // The current column becomes the previous one.
            previous = current;
        }

        // The original problem's answer is in previous[0]. Return it.
        return previous[0];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubSequence("abcde","ace"));
    }
}
