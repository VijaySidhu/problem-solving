package com.problem.solving.algorithms.arrays;

public class WaterArea {

    // How much water is contained for each index ?
    // find tallest pill to left and right of index
    // take min height from two pillars and check what is height of index

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
