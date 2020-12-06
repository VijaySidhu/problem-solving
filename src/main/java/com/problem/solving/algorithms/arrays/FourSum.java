package com.problem.solving.algorithms.arrays;


import java.util.HashMap;
import java.util.Map;

/* https://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/
Given an array of integers, find anyone combination of four elements in the array
whose sum is equal to a given value X.
Input: array = {10, 2, 3, 4, 5, 9, 7, 8}
       X = 23
Output: 3 5 7 8
Sum of output is equal to 23,
i.e. 3 + 5 + 7 + 8 = 23.
Method 2: Hashing Based Solution[O(n^2)]
 */
public class FourSum {

    /*
    1. Store sums of all pairs in hash table
    2. Traverse through all pairs again and search for X - (Current pair sum) in hash table.
    3. If pair is found with required sum, then make sure that all elements are distinct array.
        elements and an element is not considered more than once.
     */
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40, 1, 2};
        int x = 91;
        int n = arr.length;
        findFourElements(arr, n, x);
    }

    static void findFourElements(int arr[], int n, int x) {

        Map<Integer, Pair> map = new HashMap<>();

        // Store sum of all pairs in hashmap
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int sum = arr[i] + arr[j];
                map.put(sum, new Pair(i, j));
            }
        }

        // Traverse through all pairs and search for X-(current pair sum)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int sum = arr[i] + arr[j];
                if (map.containsKey(x - sum)) {
                    Pair p = map.get(x - sum);
                    // Making sure that all elements are
                    // distinct array elements and an
                    // element is not considered more than
                    // once.
                    if (p.getFirst() != i && p.getSecond() != i && p.getFirst() != i && p.getSecond() != j) {
                        System.out.print(
                                arr[i] + ", " + arr[j] + ", "
                                        + arr[p.first] + ", "
                                        + arr[p.second]);
                        return;
                    }
                }
            }
        }

    }

    private static class Pair {

        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }
}
