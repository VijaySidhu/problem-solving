package com.problem.solving.algorithms.arrays;

public class DiagnolDifference {

    public static void main(String[] args) {

        int arr[][] = {
                {11, 2, 4},
                {4, 5, 6},
                {10, 8, -12}
        };
        System.out.println(diagonalDiff(arr));
    }

    public static int diagonalDiff(int[][] arr) {
        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                // Primary Diagnol
                if (i == j) {
                    d1 = d1 + arr[i][j];
                }
                // Secondary diagnal
                if (i == arr.length - j - 1) {
                    d2 = d2 + arr[i][j];
                }

            }
        }
        return d2 - d1;
    }
}
