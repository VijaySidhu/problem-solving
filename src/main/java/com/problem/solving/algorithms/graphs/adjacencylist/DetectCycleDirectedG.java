package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.*;

public class DetectCycleDirectedG {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0, 1},
                {1, 2},
                {2, 0},
        };
        Graph g = new Graph(3, edges);
        Map<Integer, List<Integer>> graph = g.graph;
        Set<Integer> seen = new HashSet<>();
        int source = 0;
        System.out.println(dfs(source, graph, seen));

    }

    private static boolean dfs(int current, Map<Integer, List<Integer>> graph, Set<Integer> seen) {
        if (seen.contains(current)) {
            return true;
        }
        List<Integer> neighborus = graph.get(current);
        for (int n : neighborus) {
            if (!seen.contains(current)) {
                seen.add(current);
                if (dfs(n, graph, seen)) {
                    return true;
                }
            }

        }
        return false;
    }

    private static class Graph {
        Map<Integer, List<Integer>> graph;
        int v;

        public Graph(int vertices, int[][] edges) {
            this.v = vertices;
            graph = new HashMap<>();
            for (int i = 0; i < vertices; i++) {
                graph.put(i, new ArrayList<>());
            }
            for (int[] ed : edges) {
                addEdge(ed[0], ed[1]);
            }

        }

        public void addEdge(int u, int v) {
            if (graph.containsKey(u)) {
                List<Integer> neighbors = graph.get(u);
                neighbors.add(v);
                graph.put(u, neighbors);
            } else {
                List<Integer> nb = new ArrayList<>();
                nb.add(v);
                graph.put(u, nb);
            }
        }

    }

}
