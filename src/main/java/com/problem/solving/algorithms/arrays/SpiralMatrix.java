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
        1. For each outer layer we want to iterate through its element in clockwise order starting from top left corner
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
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                ans.add(matrix[r1][c]);
            }
            for (int r = r1 + 1; r <= r2; r++) {
                ans.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    ans.add(matrix[r2][c]);
                }
                for (int r = r2; r > r1; r--) {
                    ans.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }


}
