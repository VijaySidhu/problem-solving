package com.problem.solving.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class CombinationsAllDFS {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> result = combine(n, k);
        for (List<Integer> combs : result) {
            combs.stream().forEach(c -> {
                System.out.print(c + " ");

            });
            System.out.print(" , ");
        }

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (n <= 0 || n < k)
            return result;

        List<Integer> item = new ArrayList<Integer>();
        dfs(n, k, 1, item, result); // because it need to begin from 1

        return result;
    }

    private static void dfs(int n, int k, int start, List<Integer> item,
                            List<List<Integer>> res) {
        if (item.size() == k) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = start; i <= n; i++) {
            item.add(i);
            dfs(n, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }

}
