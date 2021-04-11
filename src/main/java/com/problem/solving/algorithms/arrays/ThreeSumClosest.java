package com.problem.solving.algorithms.arrays;

import java.util.Arrays;

public class ThreeSumClosest {
    /*
    Given an array nums of n integers and an integer target,
    find three integers in nums such that the sum is closest to target.
     */

    /* O(n^2)
     1. Sort the given array. (Quick Sort)
        In the sorted array, we process each value from left to right. For value v,
        we need to find a pair which sum, ideally, is equal to target - v. We will
        follow the same two pointers approach as for 3Sum, however, since this 'ideal'
        pair may not exist, we will track the smallest absolute difference between the sum and
        the target. The two pointers approach naturally enumerates pairs so that the sum moves
        toward the target.
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
