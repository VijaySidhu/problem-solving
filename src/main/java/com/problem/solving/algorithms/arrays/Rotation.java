package com.problem.solving.algorithms.arrays;

/**
 * Created by VijaySidhu on 2/5/2018.
 */
public class Rotation {
    /**
     * Rotates given array of size n by d
     * Juggling Algo rotates array in sets
     * First find  GCD and let loop iterate < = GCD(Total number of Sets)
     * Time complexity: O(n)
     * Auxiliary Space: O(1)
     */
    public static int[] rotateWithJugglingAlgorithm(int array[], int n, int d) {
        int i, j, k, temp;
        // Loop upto GCD
        for (i = 0; i < GCD.gcd(d, n); i++) {
            temp = array[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n) {
                    k = k - n;
                }
                if (k == i) {
                    break;
                }
                array[j] = array[k];
                j = k;
            }
            array[j] = temp;
        }
        return array;
    }

    /**
     * O(LogN) with Binary Search
     */
    public static int findMinRotatedSorted(int[] arr, int low, int high) {
        // This condition is needed to handle the case when array is not
        // rotated at all
        if (high < low) return arr[0];

        // If there is only one element left
        if (high == low) return arr[low];

        // Find mid
        int mid = low + (high - low) / 2; /*(low + high)/2;*/

        // Check if element (mid+1) is minimum element. Consider
        // the cases like {3, 4, 5, 1, 2}
        if (mid < high && arr[mid + 1] < arr[mid])
            return arr[mid + 1];

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];

        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid])
            return findMinRotatedSorted(arr, low, mid - 1);
        return findMinRotatedSorted(arr, mid + 1, high);
    }
}
