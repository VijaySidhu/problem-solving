package com.problem.solving.algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

    /*
      Best: O(n^2) time | O(1) space
      Average: O(n^2) time | O(1) space
      Worst: O(n^2) time | O(1) space
       The selection sort algorithm sorts an array by repeatedly finding the minimum element
       from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
           1) The subarray which is already sorted.
           2) Remaining subarray which is unsorted
      In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.
     */

    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        int startIdx = 0;
        while (startIdx < array.length - 1) {
            int smallestIdx = startIdx;
            for (int i = startIdx + 1; i < array.length; i++) {
                if (array[smallestIdx] > array[i]) {
                    smallestIdx = i;
                }
            }
            swap(startIdx, smallestIdx, array);
            startIdx++;
        }
        return array;
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] arrA = {5, 1, 9, 3, 2, 10};
        arrA = selectionSort(arrA);
        System.out.println("Sorted Array: " + Arrays.toString(arrA));
    }
}
