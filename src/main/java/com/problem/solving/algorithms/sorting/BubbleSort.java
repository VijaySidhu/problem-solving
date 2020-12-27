package com.problem.solving.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arrA = {5, 1, 9, 3, 2, 10};
        arrA = bubbleSort(arrA);
        System.out.println("Sorted Array: " + Arrays.toString(arrA));
    }

    /*
         // Best: O(n) time | O(1) space
         // Average: O(n^2) time | O(1) space
         // Worst: O(n^2) time | O(1) space
     */
    public static int[] bubbleSort(int[] input) {
        if (input.length == 0) {
            return new int[]{};
        }
        int size = input.length - 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                if (input[j] > input[j + 1]) {
                    //swap the elements
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }

        return input;
    }
}
