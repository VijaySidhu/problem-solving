package com.problem.solving.algorithms.arrays;

import java.util.Arrays;

public class ThreeSumClosest {
    /*
    Given an array nums of n integers and an integer target,
    find three integers in nums such that the sum is closest to target.
     */

    /* O(n^2)
     1. Sort the given array.
     2. Loop over the array and fix the first element of the possible triplet, arr[i]
     3. Then fix two pointers, one at i+1 and the other at n-1. And look at the sum,
        * If the sum is smaller than the sum we need to get to, we increase the first pointer.
        * Else,If the sum is bigger, Decrease the end pointer to reduce the sum.
        * Update the closest sum found so far.
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, sz = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < sz && diff != 0; ++i) {
            int lo = i + 1, hi = sz - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(diff))
                    diff = target - sum;
                if (sum < target)
                    ++lo;
                else
                    --hi;
            }
        }
        return target - diff;
    }


}
