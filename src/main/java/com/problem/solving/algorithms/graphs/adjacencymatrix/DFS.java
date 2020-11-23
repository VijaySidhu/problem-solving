package com.problem.solving.algorithms.graphs.adjacencymatrix;

public class DFS {

    private int[][] adjMatrix;

    private int numberOfVertices;


    public static void dfsTraverse(int[][] graph, int row, int col, boolean[][] visited) {
        int rows = graph.length;
        int cols = graph[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        System.out.println(graph[row][col]);
        dfsTraverse(graph, row + 1, col, visited);
        dfsTraverse(graph, row - 1, col, visited);
        dfsTraverse(graph, row, col + 1, visited);
        dfsTraverse(graph, row, col - 1, visited);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfsTraverse(grid, 0, 0, visited);

    }


}