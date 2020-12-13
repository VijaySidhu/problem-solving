package com.problem.solving.algorithms.arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18},
        };

        int[][] output = merge(array);

        for (int i = 0; i < output.length; i++) {
            for (int c = 0; c < output[0].length; c++) {
                System.out.print(output[i][c] + " ");
            }
        }


    }

    /*
      First, we sort the list as described. Then, we insert the first interval into our merged list
      and continue considering each interval in turn as follows: If the current interval begins after
      the previous interval ends, then they do not overlap and we can append the current interval to merged.
       Otherwise, they do overlap, and we merge them by updating the end of the previous interval if it is
        less than the end of the current interval.
        Time complexity : O(nlogn) sorting + linear scan
        SC : O(Log N)
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
