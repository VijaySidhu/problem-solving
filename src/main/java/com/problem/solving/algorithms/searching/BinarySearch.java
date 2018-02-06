package com.problem.solving.algorithms.searching;

/**
 * Created by VijaySidhu on 2/5/2018.
 */
public class BinarySearch {

    /**
     * Bin Search uses divide and conquer approach
     * TC : O(logN)
     * Below method will return index where the element is present
     */
    public static int binarySearch(int[] array, int search) {
        int start = 0;
        int end = array.length - 1;
        int mid = (start + end) / 2;
        int foundLocation = 0;

        while (start <= end) {
            // Search in Right
            if (array[mid] < search) {
                start = mid + 1;

            } else if (array[mid] == search) {
                foundLocation = mid + 1;
            }
            // left side of mid
            else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        if (start > end)
            foundLocation = 0;

        return foundLocation;
    }

    /**
     * Bin Search uses divide and conquer approach
     * TC : O(logN)
     * Below method will return index where the element is present
     */
    public static int recursiveBinarySearch(int array[], int low, int high, int search) {
        if (high >= low) {
            int mid = low + (high - 1) / 2;
            // If element is present at middle
            if (array[mid] == search) {
                return mid;
            }
            if (array[mid] > search) {
                return recursiveBinarySearch(array, low, mid - 1, search);
            }
            return recursiveBinarySearch(array, mid + 1, high, search);
        }
        return -1;
    }
}
