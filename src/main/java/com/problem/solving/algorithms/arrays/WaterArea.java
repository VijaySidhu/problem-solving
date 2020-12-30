package com.problem.solving.algorithms.arrays;

public class WaterArea {

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

    public static int waterArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int water = 0;

        int leftIndex = 0;
        int rightIndex = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        while (leftIndex <= rightIndex) {
            leftMax = Math.max(leftMax, height[leftIndex]);
            rightMax = Math.max(rightMax, height[rightIndex]);

            if (leftMax < rightMax) {
                water += leftMax - height[leftIndex];
                leftIndex++;
            } else {
                water += rightMax - height[rightIndex];
                rightIndex--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        System.out.println(waterArea(input));

    }
}
