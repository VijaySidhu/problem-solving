package com.problem.solving.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    /* Best: O(nlog(n)) time | O(nlog(n)) space
       Average: O(nlog(n)) time | O(nlog(n)) space
       Worst: O(nlog(n)) time | O(nlog(n)) space
        Merge Sort is a Divide and Conquer algorithm. It divides the input array into two halves,
        calls itself for the two halves, and then merges the two sorted halves.
        The merge() function is used for merging two halves.
     */
    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int middleIdx = array.length / 2;
        int[] leftHalf = Arrays.copyOfRange(array, 0, middleIdx);
        int[] rightHalf = Arrays.copyOfRange(array, middleIdx, array.length);
        return mergeSortedArrays(mergeSort(leftHalf), mergeSort(rightHalf));
    }

    public static int[] mergeSortedArrays(int[] leftHalf, int[] rightHalf) {
        int[] sortedArray = new int[leftHalf.length + rightHalf.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] <= rightHalf[j]) {
                sortedArray[k++] = leftHalf[i++];
            } else {
                sortedArray[k++] = rightHalf[j++];
            }
        }
        while (i < leftHalf.length) {
            sortedArray[k++] = leftHalf[i++];
        }
        while (j < rightHalf.length) {
            sortedArray[k++] = rightHalf[j++];
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] arrA = {5, 1, 9, 3, 2, 10};
        arrA = mergeSort(arrA);
        System.out.println("Sorted Array: " + Arrays.toString(arrA));
    }

}