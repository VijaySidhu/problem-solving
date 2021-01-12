package com.problem.solving.algorithms.arrays;

//A robot is located at the top-left corner of a m x n grid. It can only move either down or
// right at any point in time. How many possible unique paths are there?
// The robot is trying to reach the bottom-right corner of the grid.
// https://www.programcreek.com/2014/05/leetcode-unique-paths-java/
public class UniquePath {
    // Depth first search us straight forward but is too expensive
    public static void main(String[] args) {

        System.out.println(uniqueuePaths(3, 3));

        int[][] obstacleGrid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathWithObstacles(obstacleGrid));


    }

    /*
TC O(MXN)
SC O(1)
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and space is marked as 1 and 0 respectively in the grid.
    */
    public static int uniquePathWithObstacles(int[][] obstaclesGrid) {
        int rows = obstaclesGrid.length;
        int cols = obstaclesGrid[0].length;
        // If starting cell has an obstacle, then simply return as there would be
        if (obstaclesGrid[0][0] == 1) {
            return 0;
        }
        // number of ways to reach starting cell is 0
        obstaclesGrid[0][0] = 1;
        // Filling the values for first the column. If cell is not obstacle and upper cell is 1 then assign 1 else 0
        for (int r = 1; r < rows; r++) {
            obstaclesGrid[r][0] = (obstaclesGrid[r][0] == 0 && obstaclesGrid[r - 1][0] == 1) ? 1 : 0;
        }
        // Fill first row if previous cell is and current cell is not obstacle set 1 else 0
        for (int c = 1; c < cols; c++) {
            obstaclesGrid[0][c] = (obstaclesGrid[0][c] == 0 && obstaclesGrid[0][c - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1), fill up the values
        // Number of ways of reaching cell[i][j] = cell[i-1][j] +cell[i][j-1];
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstaclesGrid[i][j] == 0) {
                    obstaclesGrid[i][j] = obstaclesGrid[i - 1][j] + obstaclesGrid[i][j - 1];
                } else {
                    obstaclesGrid[i][j] = 0;
                }
            }
        }
        return obstaclesGrid[rows - 1][cols - 1];

    }


    //
    /*
    Dynamic programming with memorization
    1. Create 2D table to store result of subproblems and initialize with -1
    2. Calculate count of paths to reach in bottomup manner using recursive solution
    TC : The time complexity of this algorithm is O(m*n).
     */
    private static int uniqueuePaths(int m, int n) {
        int[][] mem = new int[m][n];
        // initialize an array with -1
        //init with -1 value
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mem[i][j] = -1;
            }
        }
        return helper(mem, m - 1, n - 1);

    }

    private static int helper(int[][] mem, int m, int n) {
        // Edge only has one path
        if (m == 0 || n == 0) {
            mem[m][n] = 1;
            return 1;
        }
        //  Return path
        if (mem[m][n] != -1) {
            return mem[m][n];
        }
        mem[m][n] = helper(mem, m, n - 1) + helper(mem, m - 1, n);
        return mem[m][n];
    }
}
