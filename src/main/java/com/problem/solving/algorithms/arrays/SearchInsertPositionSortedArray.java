package com.problem.solving.algorithms.arrays;

public class SearchInsertPositionSortedArray {
    /*
    Set start and end as 0 and N – 1, where the start and end variables denote the lower and upper bound of the search space respectively.
    Calculate mid = (start + end) / 2.
    If arr[mid] is found to be equal to K, print mid as the required answer.
    If arr[mid] exceeds K, set low = mid + 1. Otherwise, set high = mid – 1.
     */

    static int find_index(int[] arr, int n, int K) {

        // Lower and upper bounds
        int start = 0;
        int end = n - 1;

        // Traverse the search space
        while (start <= end) {
            int mid = (start + end) / 2;

            // If K is found
            if (arr[mid] == K)
                return mid;

            else if (arr[mid] < K)
                start = mid + 1;

            else
                end = mid - 1;
        }

        // Return insert position
        return end + 1;
    }

    // Driver Code
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int n = arr.length;
        int K = 2;

        System.out.println(find_index(arr, n, K));
    }

}
