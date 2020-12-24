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
        System.out.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int a = dp[i][j];
                    int b = dp[i][j + 1];
                    int c = dp[i + 1][j];

                    dp[i + 1][j + 1] = Math.min(a, Math.min(b, c));
                    dp[i + 1][j + 1]++;
                }
            }
        }

        return dp[m][n];
    }
}
