package com.problem.solving.algorithms.arrays;

import com.problem.solving.algorithms.sorting.QuickSort;

/**
 * Created by VijaySidhu on 2/6/2018.
 */
public class AlternateSort {


    /**
     * Sort array in such way so that first element is first Max and Second element is first Min
     * Input : arr[] = {7, 1, 2, 3, 4, 5, 6}
     * Output : 7 1 6 2 5 3 4
     * An efficient solution involves following steps.
     * 1) Sort input array using a O(n Log n) algorithm.
     * 2) We maintain two pointers, one from beginning and one from end in sorted array. We alternatively print elements
     * pointed by two pointers and move them toward each other.
     *
     * Time Complexity: O(n Log n)
       Auxiliary Space : O(1)
     */
    public static void alternateSort(int array[], int n) {
        // Quick Sort
        QuickSort.setArray(array);
        QuickSort.quickSort(0, n);
        int i = 0;
        int j = n;
        while (i < j) {
            System.out.print(array[j--] + " ");
            System.out.print(array[i++] + " ");
        }
        // If the total element in array is odd
        // then print the last middle element.
        if (n % 2 != 0)
            System.out.print(array[i]);

    }


}
