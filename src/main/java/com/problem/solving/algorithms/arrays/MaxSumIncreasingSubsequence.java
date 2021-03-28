package com.problem.solving.algorithms.arrays;

import java.util.Arrays;
/*
O(N^2)
 */
public class MaxSumIncreasingSubsequence {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3};
        System.out.println(sumOfLIS(input));
    }


    public static int sumOfLIS(int[] arr) {
        int T[] = new int[arr.length];

        for (int i = 0; i < T.length; i++) {
            T[i] = arr[i];
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    T[i] = Math.max(T[i], T[j] + arr[i]);
                }
            }
        }

        int max = T[0];
        for (int i = 1; i < T.length; i++) {
            if (T[i] > max) {
                max = T[i];
            }
        }
        return max;
    }
}
