package com.problem.solving.algorithms.arrays;

/**
 * Created by VijaySidhu on 2/5/2018.
 */
public class SearchSortedRotated {

    /**
     * Use Binary Search. In One pass of Bin Search
     * TC : O(logN)
     * Find middle point mid = (l + h)/2
     * 1) Find middle point mid = (l + h)/2
     * 2) If key is present at middle point, return mid.
     * 3) Else If arr[l..mid] is sorted
     * a) If key to be searched lies in range from arr[l]
     * to arr[mid], recur for arr[l..mid].
     * b) Else recur for arr[mid+1..r]
     * 4) Else (arr[mid+1..r] must be sorted)
     * a) If key to be searched lies in range from arr[mid+1]
     * to arr[r], recur for arr[mid+1..r].
     * b) Else recur for arr[l..mid]
     */
    public static int searchInRotatedArray(int[] sortedRotatedArray, int low, int high, int key) {

        if (low > high) {
            return 0;
        }
        int mid = (low + high) / 2;
        if (sortedRotatedArray[mid] == key) {
            return mid;
        }
        // if start to mid is sorted
        if (sortedRotatedArray[low] <= sortedRotatedArray[mid]) {
            if (key >= sortedRotatedArray[low] && key <= sortedRotatedArray[mid]) {
                return searchInRotatedArray(sortedRotatedArray, low, mid - 1, key);
            }
            return searchInRotatedArray(sortedRotatedArray, mid + 1, high, key);
        }

        // If arr[low to mid] is unsorted
        if (key >= sortedRotatedArray[mid] && key <= sortedRotatedArray[high]) {
            return searchInRotatedArray(sortedRotatedArray, mid + 1, high, key);
        }
        return searchInRotatedArray(sortedRotatedArray, low, mid - 1, key);
    }

    public static void main(String[] args) {

        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int n = arr.length;
        int key = 6;
        int i = searchInRotatedArray(arr, 0, n - 1, key);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }
}
