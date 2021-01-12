package com.problem.solving.algorithms.arrays;

import java.util.Arrays;

//A robot is located at the top-left corner of a m x n grid. It can only move either down or
// right at any point in time. How many possible unique paths are there?
// The robot is trying to reach the bottom-right corner of the grid.
// https://www.programcreek.com/2014/05/leetcode-unique-paths-java/
public class UniquePath {
    // Depth first search us straight forward but is too expensive
    public static void main(String[] args) {
        System.out.println(uniqueuePaths(3, 3));
        System.out.println(uniquePathsNonRecursive(5, 5));

    }

    /*
     Non recursive
     TC O(MXN)
     */
    public static int uniquePathsNonRecursive(int m, int n) {
        int[][] dp = new int[m][n];
        // Fill all the values with -1
        for (int[] arr : dp) {
            Arrays.fill(arr, 1);
        }
        //Start from position 1 ,1 always as for position 0 there will be 1 path always
        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    //
    /*
    Dynamic programming with memorization recursive
    1. Create 2D table to store result of subproblems and initialize with -1
    2. Calculate count of paths to reach in bottomup manner using recursive solution
    TC : The time complexity of this algorithm is O(m*n).
     */
    private static int uniqueuePaths(int m, int n) {
        int[][] mem = new int[m][n];
        // initialize an array with -1
        //init with -1 value
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mem[i][j] = -1;
            }
        }
        return helper(mem, m - 1, n - 1);

    }

    private static int helper(int[][] mem, int m, int n) {
        // Edge only has one path
        if (m == 0 || n == 0) {
            mem[m][n] = 1;
            return 1;
        }
        //  Return path
        if (mem[m][n] != -1) {
            return mem[m][n];
        }
        mem[m][n] = helper(mem, m, n - 1) + helper(mem, m - 1, n);
        return mem[m][n];
    }
}
