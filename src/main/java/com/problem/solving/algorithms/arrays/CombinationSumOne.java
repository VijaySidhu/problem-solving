package com.problem.solving.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumOne {

    public static void main(String[] args) {
        int[] candidate = new int[]{3, 4, 5};
        int target = 8;
        List<List<Integer>> result = combinationUptoSum(candidate, target);
        for (List<Integer> res : result) {
            System.out.print("[");
            for (int i : res) {
                System.out.print(i + " ");
            }
            System.out.print("]");
            System.out.print(",");
        }

    }

    private static List<List<Integer>> combinationUptoSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(target, new ArrayList<>(), 0, candidates, result);
        return result;
    }

    protected static void backtrack(int remain, List<Integer> comb, int start, int[] candidates, List<List<Integer>> results) {
        if (remain == 0) {
            results.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // Add current element into com
            comb.add(candidates[i]);
            // backtrack
            backtrack(remain - candidates[i], comb, start + 1, candidates, results);
            // remove current processed element
            comb.remove(comb.size() - 1);
        }

    }

}
