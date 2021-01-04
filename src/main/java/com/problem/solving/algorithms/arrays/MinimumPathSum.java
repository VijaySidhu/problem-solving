package com.problem.solving.algorithms.arrays;

public class MinimumPathSum {

    /*
      Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
      which minimizes the sum of all numbers along its path.
      1. For every element we will go rightwards or downwards
      2. We can solve this with dynamic programming approach. Usually we take dp array for this but in this case
         we will just use original matrix to store min path sum because we don't need to retain original matrix
      3. To fill in the minimum sum equation will be
            grid[i][j] = grid[i][j]+min(grid[i+][j],grid[i][j+1])
       Time complexity : O(mXn) we traverse entire matrix once
       Space complexity : O(1) we are not using auxiliary space to store min sum
     */
    public static int minPathSum(int[][] grid) {
        // Find solutions of first row. Add left element into current element
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        // Find solutions for first column. Add top element into current element
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        // As we already calculated first row and col now we will calculate cost for sub matrix starting from pos[1][1]
        // We need to add minimum element from left or top
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(input));
    }

}
