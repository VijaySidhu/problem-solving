package com.problem.solving.algorithms.arrays;

public class TrappingRainWater {

    /*
       1. Take two pointers. First pointer points at starting position of an array and second one points at last element
       2. Iterate an array and do the following
            i.  Find maximum height left bar
            ii. Find maximum height right bar
                 If left bar height is less than right bar height increment left pointer and calculate area
                 ELSE decrement right index and calculate water area
       3. Return calculated water area
     */
    // TC O(n) SC O(1)

    public static int waterArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int left = 0, right = heights.length - 1;
        int left_max = 0, right_max = 0;
        int ans = 0;
        while (left < right) {
            if (heights[left] < heights[right]) {
                if (heights[left] >= left_max) {
                    left_max = heights[left];
                } else {
                    ans += left_max - heights[left];
                }
                left++;
            } else {
                if (heights[right] >= right_max) {
                    right_max = heights[right];
                } else {
                    ans += right_max - heights[right];
                }
                right--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        System.out.println(waterArea(input));

    }
}
