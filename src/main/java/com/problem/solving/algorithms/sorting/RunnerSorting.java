package com.problem.solving.algorithms.sorting;

import com.problem.solving.algorithms.ProblemSolverUtils;

/**
 * Created by VijaySidhu on 2/1/2018.
 */
public class RunnerSorting {
    public static void main(String[] args) {

        /**
         * Quick Sort
         */
        int[] input = {5, 4, 33, 25, 3, 2, 1};
        QuickSort.setArray(input);
        ProblemSolverUtils.printSingleDimArray(QuickSort.quickSort(0, input.length - 1));

    }


}
