package com.problem.solving.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  Given an array of distinct integers candidates and a target integer target,
  return a list of all unique combinations of candidates where the chosen numbers sum to target
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5};
        List<List<Integer>> ls = combinationSum2(arr, 8);
        ls.stream().forEach(s -> {
            s.stream().forEach(a -> {
                System.out.print(a + " ");
            });
            System.out.println(" ");
        });
    }

    /*
    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

    Each number in candidates may only be used once in the combination.

    Note: The solution set must not contain duplicate combinations.
    TC  O(k * 2^N), where k is the average length of each possible solution. Copying such a possible solution list takes O(k) time.
    SC 2^N each element is used once
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);

        List<Integer> combination = new ArrayList<>();
        toFindCombinationsToTarget(candidates, results, combination, 0, target);

        return results;
    }

    /*
        We could incrementally build combination and once we find the current combination is not valid,
        we backtrack and try another option
               []
            /    \    \
           [3]   [4]   [5]
         /   |    \
      [3,3] [3,4] [3,5]

     */
    private static void toFindCombinationsToTarget(int[] candidates, List<List<Integer>> results, List<Integer> combination, int startIndex, int target) {
        if (target == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            combination.add(candidates[i]);
            toFindCombinationsToTarget(candidates, results, combination, i + 1, target - candidates[i]);
            combination.remove(combination.size() - 1);
        }
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}
