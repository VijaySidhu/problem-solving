package com.problem.solving.algorithms.arrays;

import com.problem.solving.algorithms.ProblemSolverUtils;

/**
 * Created by VijaySidhu on 2/5/2018.
 */
public class RunnerArray {
    public static void main(String[] args) {
        int array[] = {1, 4, 45, 6, 10, 8};
        /**
         * PairSum with hash map
         *
         */
        System.out.println("");
        System.out.println("Pair Sum");
        PairSum.printSumPairsHashMap(array, 16);
        System.out.println("");
        System.out.println("With Quick Sort");
        PairSum.printSumPairsQuickSort(array, 16);

        /**
         * Rotation with juggling
         */
        System.out.println("");
        System.out.println("Rotate an Array of size n by d");
        int beforeRotation[] = {1, 2, 3, 4, 5, 6, 7};
        ProblemSolverUtils.printSingleDimArray(Rotation.rotateWithJugglingAlgorithm(beforeRotation, 7, 2));
        /**
         * Search in Sorted and Rotated Array
         */
        System.out.println("");
        System.out.println("Search in Roated and Sorted Array");
        int index = SearchSortedRotated.searchInRotatedArray(Rotation.rotateWithJugglingAlgorithm(array, 6, 2), 0, array.length - 1, 1);
        System.out.println("Found at index " + index);
        /**
         * Recursive reverse
         *
         */
        System.out.println("");
        System.out.println("Recursive reverse");
        int beforeReverse[] = {1, 2, 3, 4, 5, 6, 7};
        ProblemSolverUtils.printSingleDimArray(Reverse.reverseRecursive(beforeReverse, 0, beforeReverse.length - 1));
        /**
         * Search in Sorted and Rotated Array
         */
        System.out.println("");
        System.out.println("Search in Sorted and Rotated Array");
        System.out.println(Rotation.findMinRotatedSorted(beforeRotation, 0, beforeRotation.length - 1));
        /**
         * Alternate Sort
         */
        System.out.println("");
        System.out.println("Alternate Sort");
        AlternateSort.alternateSort(array, array.length - 1);
        /**
         * Kadane Algo
         */
        System.out.println("");
        System.out.println("Kadane's Algo");
        int arr[] = {2, 3, 4, 5, 7};
        System.out.println(ContigousSumSubarray.maxSumOfSubArray(arr));
    }
}
