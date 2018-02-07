package com.problem.solving.algorithms.sorting;

import com.problem.solving.algorithms.ProblemSolverUtils;

import java.util.HashMap;
import java.util.Map;

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

        /**
         * Sort By Value Hash Map
         */
        System.out.println("");
        System.out.println("Sort By Value");
        Map<Integer, Integer> map = new HashMap<>();
        map.put(10, 10);
        map.put(1, 1);
        map.put(110, 11);
        map.put(02, 2);
        Map<Integer, Integer> sortedMap = SortByValueMap.sortByValue(map);
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " <-> " + entry.getValue());


        }
        /**
         * Frequency Sort
         */
        System.out.println("");
        System.out.println("Sort by frequency");
        int a[] = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 };
        FrequencySort.sortByFrequency(a);

    }


}
