package com.problem.solving.algorithms.arrays;

public class FirstMissingPositive {

    // Naive approach sort and scan TC O(nLogN) and SC O(1)
    // Second use hashmap to restore number and its occurrence then scan array and find missing positive SC O(n)

    // Put each number in its right place first missing positive must be within [1,index+1]
    /*
    The main idea is: nums[index] restore the number: index+1.
    each time we encounter an valid integer, find the correct position and swap, otherwise continue.
            Time Complexity: O(n)
            Space Complxity: O(1)
     */

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 0};
        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            // Swap the number until they are in the right position.
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

}
