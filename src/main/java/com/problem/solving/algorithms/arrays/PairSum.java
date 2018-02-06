package com.problem.solving.algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by VijaySidhu on 2/5/2018.
 */
public class PairSum {

    /**
     * With HashMap, TC : O(n) SC : O(n)
     */
    public static void printSumPairsHashMap(int array[], int k) {
        Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
        for (Integer val : array) {
            if (pairs.containsKey(val)) {
                System.out.println(val + "," + pairs.get(val));
            } else {
                pairs.put(k - val, val);
            }
        }
    }

    /**
     * Use Quick Sort if array is too large
     * TC : O(NLogN) Less efficient than above method
     * SC : In Place More No Risk of Out Of memory error
     */
    public static void printSumPairsQuickSort(int array[], int k) {

        // Sort Given Array with Quick Sort
        Arrays.sort(array);
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            if (array[start] + array[end] == k) {
                System.out.println(array[start] + "," + array[end]);
                start++;
                end--;
            } else if (array[start] + array[end] < k) {
                start++;

            } else if (array[start] + array[end] > k) {
                end--;

            }
        }
    }

}
