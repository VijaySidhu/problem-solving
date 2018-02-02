package com.problem.solving.algorithms.sorting;

import com.problem.solving.algorithms.ProblemSolverUtils;

/**
 * Created by VijaySidhu on 2/1/2018.
 */
public class QuickSort {

    private static int[] array;

    /**
     * O(nlogn)
     * Pick Pivot
     * Recursivly sort elements and put elements less than pivot on left side
     * and greater on right side
     */
    public static int[] quickSort(int lowerIndex, int higherIndex) {
        // Get the pivot element from the middle of the list
        int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
        int i = lowerIndex;
        int j = higherIndex;
        // Divide into two lists
        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (array[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (array[j] > pivot) {
                j--;
            }
            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                ProblemSolverUtils.swap(array, i, j);
                i++;
                j--;
            }
        }

        // Call recursively
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
        if (j > lowerIndex) {
            quickSort(lowerIndex, j);
        }
        return array;
    }
    public static  void setArray(int[] array) {
        QuickSort.array = array;
    }
}
