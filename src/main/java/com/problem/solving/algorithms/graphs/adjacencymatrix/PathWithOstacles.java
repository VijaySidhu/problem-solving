package com.problem.solving.algorithms.graphs.adjacencymatrix;

public class PathWithOstacles {

    public static void main(String[] args) {

        int[][] array = new int[][]
                {{0, 0, 0, -1, 0},
                        {-1, 0, 0, -1, -1},
                        {0, 0, 0, -1, 0},
                        {-1, 0, 0, 0, 0},
                        {0, 0, -1, 0, 0}};

    }

    static boolean isPath(int[][] grid) {
        // Set source node to  1
        grid[0][0] = 1;

        return false;

    }

}
