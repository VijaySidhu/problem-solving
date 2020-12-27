package com.problem.solving.algorithms.arrays;

//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit. You may complete as many transactions as you
//like (ie, buy one and sell one share of the stock multiple times). However, you may not engage
//in multiple transactions at the same time (ie, you must sell the stock before you buy again).
public class MaxProfit {
    /*
    Time complexity : O(n). Only a single pass is needed.
    Space complexity : O(1). Only two variables are used.
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }

        return profit;
    }
}
