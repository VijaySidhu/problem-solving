package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.*;

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
        gp.addEdge(3, 4);
        int counter = 0;

        boolean[] visited = new boolean[5];

        for (int i = 0; i < 5; i++) {
            if (visited[i]) {
                continue;
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int current = q.remove();
                visited[current] = true;
                List<Integer> neis = gp.graph.get(current);
                if (neis != null) {
                    for (int nei : neis) {
                        if (visited[nei] == false) {
                            q.add(nei);
                        }
                    }
                }
            }
            counter++;
        }
        System.out.println(counter);
    }
}

