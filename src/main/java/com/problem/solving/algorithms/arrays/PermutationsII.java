package com.problem.solving.algorithms.arrays;

import java.util.*;

/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 */
public class PermutationsII {

    // TC O(N!)
    // SC O(N)
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        // Build map with number as key and value will count of each number
        for (int num : nums) {
            if (!counter.containsKey(num)) {
                counter.put(num, 0);

            }
            counter.put(num, counter.get(num) + 1);
        }
        LinkedList<Integer> comb = new LinkedList<>();
        backTrack(comb, nums.length, counter, results);
        return results;
    }

    /*
    The total number of steps to complete the exploration is exactly the number of nodes
    in the tree. Therefore, the time complexity of the algorithm is linked directly with
    the size of the tree.
     */
    private static void backTrack(LinkedList<Integer> comb, int length, Map<Integer, Integer> counter, List<List<Integer>> results) {
        if (comb.size() == length) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            results.add(new ArrayList<Integer>(comb));
            return;
        }
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0)
                continue;
            // add this number into the current combination
            comb.addLast(num);
            counter.put(num, count - 1);

            // continue the exploration
            backTrack(comb, length, counter, results);

            // revert the choice for the next exploration
            comb.removeLast();
            counter.put(num, count);
        }

    }
}
