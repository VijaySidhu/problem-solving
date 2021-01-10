package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    /*
        TC : O (2^N)
        SC : O(N)
     */

    private static List<Integer> ans;

    public static List<Integer> grayCode(int n) {
        ans = new ArrayList<>();
        if (n == 0) {
            ans.add(0);
            return ans;
        }

        backtrack(n - 1, new boolean[n]);
        return ans;
    }

    private static void backtrack(int i, boolean[] arr) {
        if (i == -1) {
            StringBuilder builder = new StringBuilder();
            for (boolean b : arr) {
                builder.append(b ? '1' : '0');
            }

            ans.add(Integer.parseInt(builder.toString(), 2));
            return;
        }

        backtrack(i - 1, arr);
        arr[i] = !arr[i];
        backtrack(i - 1, arr);
    }

    public static void main(String[] args) {
        grayCode(2);
        ans.stream().forEach(e -> {
            System.out.println(e);
        });
    }

}
