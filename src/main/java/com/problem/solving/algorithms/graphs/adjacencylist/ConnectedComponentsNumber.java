package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://github.com/luckykumardev/leetcode-solution
   Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function
   to find the number of connected components in an undirected graph.
 */
public class ConnectedComponentsNumber {

    public static void main(String[] args) {
       /* int[][] graph = new int[][]{
                {0, 1},
                {1, 2},
                {3, 4}
        };*/
        int[][] graph = new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
        };
        G gp = new G(5);
        gp.addEdge(0, 1);
        gp.addEdge(1, 2);
        gp.addEdge(2, 3);
        gp.addEdge(3, 4);
        int counter = 0;

        boolean[] visited = new boolean[5];
        // Apply DFS for all vertices
        for (int v = 0; v < 5; v++) {
            //Call DFS
            if (!visited[v]) {
                dfs(gp.graph, v, -1, visited);
                counter++;
            }
        }
        System.out.println(counter);
    }

    public static void dfs(Map<Integer, List<Integer>> graph, int currentNode, int pre, boolean[] visited) {
        if (visited[currentNode]) {
            return;
        }
        visited[currentNode] = true;
        List<Integer> neighbors = graph.get(currentNode);
        if (neighbors != null) {
            for (Integer nei : neighbors) {
                if (nei != pre) {
                    dfs(graph, currentNode, pre, visited);
                }
            }
        }

    }
}

