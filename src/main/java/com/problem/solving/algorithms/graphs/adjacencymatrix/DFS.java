package com.problem.solving.algorithms.graphs.adjacencymatrix;

import java.util.Stack;

public class DFS {

    private int[][] adjMatrix;

    private int numberOfVertices;


    // recursive
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

    // https://algorithms.tutorialhorizon.com/depth-first-search-dfs-in-2d-matrix-2d-array-iterative-solution/
    // https://java2blog.com/depth-first-search-in-java/
    public static void iterative(int[][] graph) {
        Stack<Integer> s = new Stack();
        s.push(graph[0][0]);
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        visited[0][0] = true;
        while (!s.empty()) {
            int currentNode = s.pop();
            System.out.println(currentNode);
            for (int i = 1; i < graph.length; i++) {
                for (int j = 1; j < graph[0].length; j++) {
                    if (visited[i][j] == false) {
                        visited[i][j] = true;

                        s.push(graph[i][j]);
                    }


                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        //  dfsTraverse(grid, 0, 0, visited);
        iterative(grid);

    }


}