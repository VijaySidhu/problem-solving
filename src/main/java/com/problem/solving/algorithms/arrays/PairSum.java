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

    //Instead of returning pair it return indices of array
    //It turns out we can do it in one-pass. While we iterate
    // and inserting elements into the table, we also look back
    // to check if current element's complement already exists in the table.
    // If it exists, we have found a solution and return immediately.
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Use Quick Sort if array is too large TC : O(NLogN) Less efficient than above method SC : In
     * Place More No Risk of Out Of memory error
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
