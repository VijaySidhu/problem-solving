package com.problem.solving.algorithms.arrays;

import java.util.Arrays;

/**
 * Leetcode 300 Given an integer array nums,
 * return the length of the longest strictly increasing subsequence.
 */
public class LongestIncreasingSubsequence {

    /*Time complexity : O(nlogn). Binary search takes nlogn time and it is called n times.
      Space complexity : O(n).dp array of size n is used.
      . We will solve this with dp approach. We can take dp array and initialize with all ZEROs
      This dp array is meant to store the increasing subsequence formed by including
      the currently encountered element. While traversing the nums array, we keep on filling the
      dp array with the elements encountered so far. For the element corresponding to the jTH
      index.we determine its correct position in the dp array by making use of Binary Search
      (which can be used since the dp array is storing increasing subsequence) and also insert it at
      the correct position.An important point to be noted is that for Binary Search,
      we consider only that portion of
      the dp array in which we have made the updates by inserting some elements at their correct positions.
      */
    public static void main(String[] args) {
        int[] input = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(input));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            // Index of num
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

}
