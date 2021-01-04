package com.problem.solving.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/*
  Given an array nums of distinct integers, return all the possible permutations.
  You can return the answer in any order.
  https://www.youtube.com/watch?v=foBqt8E94mI&ab_channel=PrakashShukla
 */
public class Permutations {


    // Use same solution of subset problem

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(permutations, nums, new ArrayList<>(), used);
        return permutations;
    }

    private static void dfs(List<List<Integer>> permutations, int[] nums, List<Integer> current, boolean[] used) {
        if (current.size() == nums.length) {
            permutations.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false) {
                used[i] = true;
                current.add(nums[i]);
                dfs(permutations, nums, current, used);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }

    }




    /*
     TC O(N!) SC O(N)
    Step 1 : First we will calculate the all possible permutation of first n - 1 decimal's adjoining the last element to each of these permutations.

    Step 2 : Iterate the loop starting from 0 till i is less than n, if n is odd swap the first and last element, and if n is even then swap the i'th element and the last element.

    Step 3 : In above every iteration the algorithm will produce all the permutations of n decimal's that end with the current last element.

     */

    // Without duplicates
    private static void heapPermutation(int[] a, int size, int n) {

        // If size becomes 1 print the obtained permutations
        if (size == 1) {
            printArr(a, n);
        }

        for (int i = 0; i < size; i++) {
            heapPermutation(a, size - 1, n);

            // If size is odd swap 0th with last element
            if (size % 2 == 1) {
                int temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            }

            // If size is even, swap ith and size-1 th element
            else {
                int temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }


    }

    // Prints the array
    static void printArr(int a[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[]) {
        int a[] = {1, 2, 3};

        //     heapPermutation(a, a.length, a.length);

        // Back track way
        List<List<Integer>> result = permute(a);
        for (List<Integer> rs : result) {
            for (Integer i : rs) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

}
