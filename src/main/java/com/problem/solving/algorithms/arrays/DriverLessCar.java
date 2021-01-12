package com.problem.solving.algorithms.arrays;

import java.util.Arrays;

public class DriverLessCar {

    public static void main(String[] args) {

        System.out.println(carTrack(5, 5));
    }

    public static int carTrack(int m, int n) {
        int[][] dp = new int[m][n];

        // Fill an array with 1
        for (int[] arr : dp) {
            Arrays.fill(arr, 1);
        }

        // Iterate over matrix
        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                if (r < c) {
                    continue;
                }
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[m - 1][n - 1];

    }
}
