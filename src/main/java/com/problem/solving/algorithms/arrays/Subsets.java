package com.problem.solving.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// Leet code 78
public class Subsets {
    /*
    Time complexity: O(N X2^N) to generate all subsets and then copy them into output list.
    Space complexity:O(N X 2^N) to keep all the subsets of length N, since each of N elements
    could be present or absent.
    https://www.youtube.com/watch?v=taIvqOIT3cM&ab_channel=codebix
     */
    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3,};

        List<List<Integer>> result = subsets(num);

        for (List<Integer> combs : result) {
            combs.stream().forEach(c -> {
                System.out.print(c + " ");

            });
            System.out.print(" , ");
        }
    }

    /*

     */

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        dfs(subset, 0, nums, new ArrayList<>());
        return subset;
    }

    // Subset is final list of all subsets
    // current is list identified for given index
    private static void dfs(List<List<Integer>> subset, int index, int[] nums, List<Integer> current) {
        // Add current create list for index into final list
            subset.add(new ArrayList<>(current));

        // Iterate from index to length of array
        for (int i = index; i < nums.length; i++) {
            // Add current index into list
            current.add(nums[i]);
            // look for subsets with DFS and increment index
            dfs(subset, i + 1, nums, current);
            // Remove processed integer from list
            current.remove(current.size() - 1);
        }

    }


}
