package com.problem.solving.algorithms.arrays;

/**
 * Created by VijaySidhu on 2/6/2018.
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 */
public class ContigousSumSubarray {

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSumOfSubArray(arr));
    }

    /**
     * Kadane’s Algorithms  TC : O(N)
     */
    public static int maxSumOfSubArray(int[] input) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for (Integer val : input) {
            maxEndingHere = maxEndingHere + val;
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
        }
        return maxSoFar;
    }
}
