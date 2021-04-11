package com.problem.solving.algorithms.arrays;

import java.util.*;

/* Leetcode 15
   Given an integer array nums,
   return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
   and nums[i] + nums[j] + nums[k] == 0.
   Notice that the solution set must not contain duplicate triplets.

   We move our pivot element nums[i] and analyze elements to its right.
   We find all pairs whose sum is equal -nums[i] using the Two Sum:
   One-pass Hash Table approach, so that the sum of the pivot element (nums[i]) and the pair (-nums[i])
   is equal to zero.

   To do that, we process each element nums[j] to the right of the pivot,
   and check whether a complement -nums[i] - nums[j] is already in the hashset.
   If it is, we found a triplet.
   Then, we add nums[j] to the hashset, so it can be used as a complement from that point on.

 */
public class ThreeSum {
    /* Time Complexity: O(n^2).SC O(n) Sort is O(nLogN)

       For the main function:
            * Sort the input array nums.
            * Iterate through the array:
                If the current value is greater than zero, break from the loop. Remaining values cannot sum to zero.
                If the current value is the same as the one before, skip it.
                Otherwise, call twoSum for the current position i.


       For twoSum function:

        For each index j > i in A:
            Compute complement value as -nums[i] - nums[j].
            If complement exists in hashset seen:
                We found a triplet - add it to the result res.
                Increment j while the next value is the same as before to avoid duplicates in the result.
            Add nums[j] to hashset seen
      return res

     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        return res;
    }

    void twoSum(int[] nums, int i, List<List<Integer>> res) {
        Set seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1])
                    ++j;
            }
            seen.add(nums[j]);
        }
    }

}
