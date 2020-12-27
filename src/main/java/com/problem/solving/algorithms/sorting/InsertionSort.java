package com.problem.solving.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
    /* Best: O(n) time | O(1) space
       Average: O(n^2) time | O(1) space
       Worst: O(n^2) time | O(1) space
        1: Iterate from arr[1] to arr[n] over the array.
        2: Compare the current element (key) to its predecessor.
        3: If the key element is smaller than its predecessor, compare it to the elements before.
           Move the greater
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swap(j, j - 1, array);
                j -= 1;
            }
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
        arrA = insertionSort(arrA);
        System.out.println("Sorted Array: " + Arrays.toString(arrA));
    }

}
