package com.problem.solving.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  Given an array of distinct integers candidates and a target integer target,
  return a list of all unique combinations of candidates where the chosen numbers sum to target
 */
public class CombinationSum {

    /*
    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

    Each number in candidates may only be used once in the combination.

    Note: The solution set must not contain duplicate combinations.
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);

        List<Integer> combination = new ArrayList<>();
        toFindCombinationsToTarget(candidates, results, combination, 0, target);

        return results;
    }

    private void toFindCombinationsToTarget(int[] candidates, List<List<Integer>> results, List<Integer> combination, int startIndex, int target) {
        if (target == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            combination.add(candidates[i]);
            toFindCombinationsToTarget(candidates, results, combination, i + 1, target - candidates[i]);
            combination.remove(combination.size() - 1);
        }
    }
}
