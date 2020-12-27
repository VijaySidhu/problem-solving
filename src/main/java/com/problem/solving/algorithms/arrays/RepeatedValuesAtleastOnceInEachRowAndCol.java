package com.problem.solving.algorithms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedValuesAtleastOnceInEachRowAndCol {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 7, 4, 5},
                {2, 5, 9, 3, 3},
                {1, 8, 5, 3, 5},
                {5, 0, 3, 5, 6},
                {3, 8, 3, 5, 6},
                {1, 0, 3, 0, 5},
        };
        repeatedValues(matrix);

    }

    public static List<Integer> repeatedValues(int[][] matrix) {
        int rows = matrix.length;
        int col = matrix[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                // TODO
            }
        }
        return ls;
    }
}
