package com.problem.solving.algorithms.leetcode;

import java.util.HashMap;

/*
    Given an array of integers nums and an integer target,
    return indices of the two numbers such that they add up to
    target.
    Input: nums = [3,2,4], target = 6
    Output: [1,2]
 */
public class TwoSum {

  public static void main(String[] args) {
    int[] input = {3, 2, 4};
    int target = 6;
    int[] result = TwoSum.twoSumIndexReturn(input, target);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + " ");
    }
  }

  /* One pass hashmap
     Time complexity : O(n).
     Space complexity : O(n).

     1. Calculate complement by subtracting current number in input from target.
     2. If complement is not in the map push it in the map with index.
     3. If complement is in the map return from map. Thats answer

   */
  public static int[] twoSumIndexReturn(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return new int[]{0, 0};
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(nums[i])) {
        return new int[]{map.get(nums[i]), i};
      }
      map.put(complement, i);
    }
    return new int[]{0, 0};
  }

}
