package com.problem.solving.algorithms.arrays;

public class TrappingRainWater {

    /*
       Algorithm
                    Initialize left pointer to 0 and right pointer to size-1
                    While left < right, do:
                        If height[left] is smaller than height[right]
                            If height[left] >= left_max, update left_max
                            Else add left_max−height[left] to ans
                            move left to the next position (left++).
                        Else
                            If height[right] >= right_max, update right_maxright_max
                            Else add right_max−height[right] to ans
                            move right to the next position (right--).
    Complexity analysis
	Time  complexity: O(n). Single iteration of O(n).
	Space complexity: O(1). Only constant space required for left, right, left_max and right_max.
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
