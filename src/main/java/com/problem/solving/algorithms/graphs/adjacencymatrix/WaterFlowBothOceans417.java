package com.problem.solving.algorithms.graphs.adjacencymatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
If the input is empty, immediately return an empty array.

Initialize variables that we will use to solve the problem:

Number of rows and columns in our matrix;
2 queues, one for the Atlantic Ocean and one for the Pacific Ocean that will be used for BFS;
2 data structures, again one for each ocean, that we'll use to keep track of cells we already visited, to avoid infinite loops;
A small array [(0, 1), (1, 0), (-1, 0), (0, -1)] that will help with BFS.
Figure out all the cells that are adjacent to each ocean, and fill the respective data structures with them.

Perform BFS from each ocean. The data structure used to keep track of cells already visited has a double purpose - it also contains every cell that can flow into that ocean.

Find the intersection, that is all cells that can flow into both oceans.
 */
public class WaterFlowBothOceans417 {

    private int numRows;
    private int numCols;
    int[][] landHeights;
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    /*
        Start from ocean and work backsward, we already know that every cell we visit must be connected to ocean
        Algo
        1. Check for higher height instead of lower height, then we know that every cell we visit during the travesal can flow into ocean.
        2. Traverse from cells that is immediatly besides pacific and do same for atlantic. In the end cells
        that end up connected to both oceans will be our answer.
        TC O(M.N)
        SC O(M.N)
         */
    public List<List<Integer>> commonCellsWhereWaterFlows(int[][] matrix) {
        // Check if input is empty
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        // Save initial values to parameters
        numRows = matrix.length;
        numCols = matrix[0].length;
        landHeights = matrix;

        boolean[][] pacificReachable = new boolean[numRows][numCols];
        boolean[][] atlanticReachable = new boolean[numRows][numCols];

        // Loop through each cell adjacent to the oceans and start a DFS
        for (int i = 0; i < numRows; i++) {
            // pacific touches top left
            dfs(i, 0, pacificReachable);
            // atlantic bottom right
            dfs(i, numCols - 1, atlanticReachable);
        }

        for (int i = 0; i < numCols; i++) {
            dfs(0, i, pacificReachable);
            dfs(numRows - 1, i, atlanticReachable);

        }

        // Find all cells that can reach both oceans
        List<List<Integer>> commonCells = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    commonCells.add(Arrays.asList(i, j));
                }
            }
        }
        return commonCells;
    }

    private void dfs(int row, int col, boolean[][] reachable) {
        // This cell is reachable, so mark it
        reachable[row][col] = true;
        for (int[] dir : DIRECTIONS) { // Check all 4 directions
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            // Check if new cell is within bounds
            if (newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols) {
                continue;
            }
            // Check that the new cell hasn't already been visited
            if (reachable[newRow][newCol]) {
                continue;
            }
            // Check that the new cell has a higher or equal height,
            // So that water can flow from the new cell to the old cell
            if (landHeights[newRow][newCol] < landHeights[row][col]) {
                continue;
            }
            // If we've gotten this far, that means the new cell is reachable
            dfs(newRow, newCol, reachable);
        }
    }
}
