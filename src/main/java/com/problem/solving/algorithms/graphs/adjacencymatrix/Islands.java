package com.problem.solving.algorithms.graphs.adjacencymatrix;

public class Islands {
    /*
      Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
      An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
      You may assume all four edges of the grid are all surrounded by water.

      TC O(MXN)
      SC O(MXN)
     */

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},


        };
        int numberOfIslands = 0;
        // DFS Matrix
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    calculateNumberOfIslandsDFS(grid, i, j);
                }
            }
        }
        System.out.println(numberOfIslands);

    }

    public static void calculateNumberOfIslandsDFS(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        // Check boundaries
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0') {
            return;
        }
        // Change 1 to 0 as we visited this node
        grid[row][col] = '0';
        calculateNumberOfIslandsDFS(grid, row - 1, col);
        calculateNumberOfIslandsDFS(grid, row + 1, col);
        calculateNumberOfIslandsDFS(grid, row, col - 1);
        calculateNumberOfIslandsDFS(grid, row, col + 1);

    }


}
