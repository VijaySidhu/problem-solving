package com.problem.solving.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9,}
        };
        spiralFormPrint(arr).stream().forEach(i -> {
            System.out.print(i + " ");
        });
    }

    // Output: [1,2,3,6,9,8,7,4,5]
    /*
        The answer will be all the elements in clockwise order from the first-outer layer,
        followed by the elements from the second-outer layer, and so on.
        1. For each outer layer (Parameter)we want to iterate through its element in clockwise order starting from top left corner
        Time Complexity: O(N) where N is the total number of elements in the input matrix.
         We add every element in the matrix to our final answer.

Space Complexity:
        O(1) without considering the output array, since we don't use any additional data structures for our computations.
        O(N) if the output array is taken into account.
     */
    public static List spiralFormPrint(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int startRow = 0, endRow = matrix.length - 1;
        int startColumn = 0, endColumn = matrix[0].length - 1;
        while (startRow <= endRow && startColumn <= endColumn) {
            // Left to right
            for (int c = startColumn; c <= endColumn; c++) {
                ans.add(matrix[startRow][c]);
            }
            // top  to bottom
            for (int r = startRow + 1; r <= endRow; r++) {
                ans.add(matrix[r][endColumn]);
            }

            if (startRow < endRow && startColumn < endColumn) {
                // right to left
                for (int c = endColumn - 1; c > startColumn; c--) {
                    ans.add(matrix[endRow][c]);
                }
                // bottom to top
                for (int r = endRow; r > startRow; r--) {
                    ans.add(matrix[r][startColumn]);
                }
            }
            startRow++;
            endRow--;
            startColumn++;
            endColumn--;
        }
        return ans;
    }


}
