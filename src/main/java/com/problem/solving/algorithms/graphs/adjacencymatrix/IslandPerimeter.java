package com.problem.solving.algorithms.graphs.adjacencymatrix;

public class IslandPerimeter {
    /*
    Go through every cell on the grid and whenever you are at cell 1 (land cell), look for surrounding (UP, RIGHT, DOWN, LEFT) cells. A land cell without any surrounding land cell will have a perimeter of 4. Subtract 1 for each surrounding land cell.
    When you are at cell 0 (water cell), you don't need to do anything. Just proceed to another cell.
     */
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1},
        };
        int rows = grid.length;
        int cols = grid[0].length;
        int up, down, left, right;
        int result = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    // Handle first row
                    if (r == 0) {
                        up = 0;
                    } else {
                        up = grid[r - 1][c];
                    }
                    // handle first col
                    if (c == 0) {
                        left = 0;
                    } else {
                        left = grid[r][c - 1];
                    }
                    // Handle last row
                    if (r == rows - 1) {
                        down = 0;
                    } else {
                        down = grid[r + 1][c];
                    }

                    // handle last column
                    if (c == cols - 1) {
                        right = 0;
                    } else {
                        right = grid[r][c + 1];
                    }
                    result += 4 - (up + left + right + down);
                }
            }
        }

    }
}
