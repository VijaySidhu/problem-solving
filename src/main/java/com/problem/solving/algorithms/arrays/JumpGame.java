package com.problem.solving.algorithms.arrays;

public class JumpGame {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 1, 4};
        System.out.println(canJump(array));
    }

    /*
      Time complexity : O(n). We are doing a single pass through the nums array, hence n steps,
       where n is the length of array nums.
      Space complexity : O(1). We are not using any extra memory.
      Keep track of last spot we have seen and check if we can get it to the ending position
     */
    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
