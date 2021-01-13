package com.problem.solving.algorithms.arrays;

import java.util.Arrays;

public class DriverLessCar {

    public static void main(String[] args) {

        System.out.println(carTrack(5, 5));
    }


    public static int carTrack(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        // Fill an array with 1
        for (int[] arr : dp) {
            Arrays.fill(arr, 0);
        }

        System.out.println(Arrays.toString(dp));

        dp[1][1] = 1;

        // Iterate over matrix
        for (int r = 0; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                if (r < c) {
                    continue;
                }

                if (r + 1 <= m) dp[r + 1][c] += dp[r][c];
                if (c + 1 <= n) dp[r][c + 1] += dp[r][c];
            }
        }
        return dp[m][n];

    }
}
