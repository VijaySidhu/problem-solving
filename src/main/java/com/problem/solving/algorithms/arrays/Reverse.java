package com.problem.solving.algorithms.arrays;

/**
 * Created by VijaySidhu on 2/6/2018.
 */
public class Reverse {

    /**
     * TC : O(N)
     *
     * @param array
     * @return
     */
    public static int[] reverseRecursive(int[] array, int start, int end) {
        int temp;
        if (start >= end) {
            return array;
        }
        temp = array[start];
        array[start] = array[end];
        array[end] = temp;
        reverseRecursive(array, start + 1, end - 1);
        return array;
    }
}
