package com.problem.solving.algorithms.arrays;

/*
Given two strings word1 and word2, return the minimum number of operations required to
convert word1 to word2. You have the following three operations permitted on a word:
    Insert a character
    Delete a character
    Replace a character
*/
public class EditDistance {

    public static void main(String[] args) {
        System.out.println(editDistanceDP("horse", "ros"));
    }

    public static int editDistanceDP(String wordOne, String wordTwo) {
        int m = wordOne.length();
        int n = wordTwo.length();
        int[][] dp = new int[m + 1][n + 1];

        //Fill cols
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        // Fill rows
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // first element
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If match case... get primary diagonal cell i-1 and j-1
                if (wordOne.charAt(i - 1) == wordTwo.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // previous row and previous col
                } else {
                    // If not matching take the minimum value left top and primary diagonal cell
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
}
