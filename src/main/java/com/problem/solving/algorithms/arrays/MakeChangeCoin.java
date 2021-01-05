package com.problem.solving.algorithms.arrays;

/*
    Given an array of distinct positive integers
    representing coin denominations and a single
    non-negative integer n representing a target
    amount of money, write a function that returns
    the number of ways to make change for that
    target amount using the given coin
    denominations.
        Note that an unlimited amount of coins is at
        your disposal.
        Sample Input
        n = 6
        denoms = [1, 5]
        Sample Output
        2 // 1x1 + 1x5 and 6x1
 */
public class MakeChangeCoin {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Auxilary space
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for (int denomination : denoms) {
            for (int amount = 1; amount < n + 1; amount++) {
                if (denomination <= amount) {
                    ways[amount] = ways[amount] + ways[amount - denomination];
                }

            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        System.out.println(numberOfWaysToMakeChange(6, new int[]{1, 5}));
    }


}
