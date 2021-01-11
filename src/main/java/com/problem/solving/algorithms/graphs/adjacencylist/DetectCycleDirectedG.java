package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.*;

public class DetectCycleDirectedG {

    public static void main(String[] args) {
        // Yes in below there is cycle
        int[][] edges = new int[][]{
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 0},
                {0, 2},
                {3, 2},
                {2, 3}

        };
        int[][] noCycle = new int[][]{
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {3, 2},
                {2, 3}

        };
        Graph g = new Graph(4, noCycle);
        Map<Integer, List<Integer>> graph = g.graph;
        Set<Integer> seen = new HashSet<>();
        int source = 0;

        // Recursive
        System.out.println(dfs(source, graph, seen, -1));

        // Iterative solution
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        seen = new HashSet<>();
        seen.add(source);

        System.out.println(iterativeDFS(stack, graph, seen));

    }

    // not working
    public static boolean iterativeDFS(Stack<Integer> stack, Map<Integer, List<Integer>> graph, Set<Integer> seen) {
        while (!stack.isEmpty()) {
            int parent = 0;
            int current = stack.pop();
            parent = current;

            List<Integer> neighbors = graph.get(current);
            for (int i : neighbors) {
                if (!seen.contains(i)) {
                    stack.push(i);
                    seen.add(i);
                } else if (i != parent) {
                    return true;
                }
            }
        }

        return false;

    }

    private static boolean dfs(int current, Map<Integer, List<Integer>> graph, Set<Integer> seen, int parent) {

        List<Integer> neighborus = graph.get(current);
        for (int n : neighborus) {
            if (!seen.contains(n)) {
                seen.add(n);
                if (dfs(n, graph, seen, current)) {
                    return true;
                }
            } else if (n != parent) {
                return true;
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
