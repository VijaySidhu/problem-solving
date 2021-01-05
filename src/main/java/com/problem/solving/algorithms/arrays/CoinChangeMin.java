package com.problem.solving.algorithms.arrays;

import java.util.Arrays;

public class CoinChangeMin {

    // We are going over every single coin and amount so TC O(mXn)
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // Fill an array with invalid amount basically value greater than amount
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // Check if current coin is acceptable not greater the current amout
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }

        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }


}
