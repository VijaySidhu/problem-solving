package com.problem.solving.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subsets {
    /*
    Time complexity: O(N X2^N) to generate all subsets and then copy them into output list.
    Space complexity:O(N X 2^N) to keep all the subsets of length N, since each of N elements
    could be present or absent.
     */
    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3, 4};

        List<List<Integer>> result = subsets(num);

        for (List<Integer> combs : result) {
            combs.stream().forEach(c -> {
                System.out.print(c + " ");

            });
            System.out.print(" , ");
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        recurse(result, nums, new Stack<>(), 0);


        return result;
    }


    private static void recurse(List<List<Integer>> result, int[] nums, Stack path, int position) {
        if (position == nums.length) {
            result.add(new ArrayList<>(path));

            return;
        }

        path.push(nums[position]);

        recurse(result, nums, path, position + 1);

        path.pop();

        recurse(result, nums, path, position + 1);
    }
}
