package com.problem.solving.algorithms.arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},};
        rotateImage(array);
        int rows = array.length;
        int colums = array[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /*
    Idea is to split the given matrix and rotate elements with in split matrix
    TC O(n^2) is complexity given by two inserted loops
    SC O(1) we are doing in place rotation and allocate only the list split rectangle
    as a temporary helper
     */
    public static void rotateImage(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                // Save element in temp
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
