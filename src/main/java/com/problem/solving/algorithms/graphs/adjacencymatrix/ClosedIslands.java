package com.problem.solving.algorithms.graphs.adjacencymatrix;

public class ClosedIslands {

    /*
    MXN
     */
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
        };
        int rows = grid.length;
        int cols = grid[0].length;
        int totalNumberOfIsland = 0;
        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (grid[r][c] == 0) {
                    if (isClosedIsland(grid, r, c, rows, cols)) {
                        ++totalNumberOfIsland;
                    }
                }

            }
        }
        System.out.println(totalNumberOfIsland);
    }

    public static boolean isClosedIsland(int[][] grid, int i, int j, int rows, int cols) {
        // -1 is visited
        // 1 is water
        // 0 island
        if (grid[i][j] == -1 || grid[i][j] == 1) {
            return true;
        }
        if (isOnPerimeter(i, j, rows, cols)) {
            return false;
        }
        // mark position visited
        grid[i][j] = -1;
        // check directions
        boolean left = isClosedIsland(grid, i, j - 1, rows, cols);
        boolean right = isClosedIsland(grid, i, j + 1, rows, cols);
        boolean up = isClosedIsland(grid, i - 1, j, rows, cols);
        boolean down = isClosedIsland(grid, i + 1, j, rows, cols);
        return left && right && up && down;
    }

    public static boolean isOnPerimeter(int i, int j, int rows, int cols) {
        if (i == 0) {
            return true;
        }
        if (j == 0) {
            return true;
        }
        if (i == rows - 1) {
            return true;
        }
        if (j == cols - 1) {
            return true;
        }

        return false;
    }

}
