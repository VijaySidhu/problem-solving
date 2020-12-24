package com.problem.solving.algorithms.arrays;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairsEfficientFab(4));

    }

    /* One can reach iTH step in one of the two ways:
     1. Taking a single step from (i-1)th step.
     2. Taking a step of 2 from (i-2)th step.

     so total number of steps required
     dp[i]=dp[i−1]+dp[i−2]
     Time complexity : O(n). Single loop upto nn.
     Space complexity : O(n). dp array of size nn is used.
     */

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /* Fibonacci
    Time complexity :  O(n). Single loop upto nn is required to calculate nTH fibonacci number.
    Space complexity : O(1). Constant space is used.
     */

    public static int climbStairsEfficientFab(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


}
