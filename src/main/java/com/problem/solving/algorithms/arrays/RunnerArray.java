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
    }
}
