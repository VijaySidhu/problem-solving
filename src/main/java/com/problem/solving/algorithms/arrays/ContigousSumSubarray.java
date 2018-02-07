package com.problem.solving.algorithms.arrays;

/**
 * Created by VijaySidhu on 2/6/2018.
 */
public class ContigousSumSubarray {

    /**
     * Kadane’s Algorithms  TC : O(N)
     *
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
