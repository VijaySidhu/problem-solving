package com.problem.solving.algorithms.arrays;

public class SortColors {
    /*
    Three way partitioning --> We can divide an array into four sections using three pointers. Lets name pointers
    Low, Mid and High
    a[0…low-1] only zeroes
    a[low..mid-1] only ones
    a[mid…high] unknown
    a[high+1..n-1] only twos

    1. If element at mid is 0 then swap mid and low and increment mid and low
    2. If element at mid is 2 then swap mid and high and decrement high
    3. If element at mid is 1 do nothing just increment mid

    Time complexity O(n)
    Space complexity O(1)
     */

    public static void sortColors(int[] inputArray) {
        int low = 0;
        int mid = 0;
        int high = inputArray.length - 1;

        while (mid <= high) {
            // Low range
            if (inputArray[mid] == 0) {
                swap(inputArray, mid, low);
                low++;
                mid++;
            }
            // High range
            else if (inputArray[mid] == 2) {
                swap(inputArray, mid, high);
                high--;
            }
            // do nothing when element at mid pointer is at 1
            else {
                mid++;
            }
        }


    }


    private static void swap(int[] input, int mid, int low) {
        int temp = input[mid];
        input[mid] = input[low];
        input[low] = temp;
    }

    public static void main(String[] args) {
        int[] a = {2, 0, 2, 1, 1, 0};
        sortColors(a);
        for (int val : a) {
            System.out.print(val + " ");
        }
    }
}
