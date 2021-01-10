package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.*;

public class ValidTree {
    /*
     * Graph is tree basically if it is not connected graph mean n-1 edges.
        Going by this definition, our algorithm needs to do the following:
        Check whether or not there are n - 1 edges. If there's not, then return false.
        Check whether or not the graph is fully connected. Return true if it is, false if otherwise.
     */

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 4}
        };

        GPH g = new GPH(5, edges);

        Map<Integer, List<Integer>> graph = g.graph;

        // Use Stack for DFS and put the first node in stack
        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        stack.push(0);
        seen.add(0);
        System.out.println(dfsWithStackIsCycle(g, graph, stack, seen));
    }

    /*
      O(N)
     */
    private static boolean dfsWithStackIsCycle(GPH g, Map<Integer, List<Integer>> graph, Stack<Integer> stack, Set<Integer> seen) {
        // Iterate over stack until it is empty
        while (!stack.isEmpty()) {
            // Pop an element from stack
            int current = stack.pop();
            // Get all Neighbors
            List<Integer> neighbors = graph.get(current);

            // Iterate over neighbors
            for (int neighbor : neighbors) {

                if (seen.contains(neighbor)) {
                    continue;
                }

                stack.push(neighbor);
                seen.add(neighbor);
            }

        }
        if (seen.size() == g.V) {
            return true;
        }
        return false;
    }


    public static class GPH {
        Map<Integer, List<Integer>> graph;
        int V;

        public GPH(int v, int[][] edges) {
            graph = new HashMap<>();
            this.V = v;
            this.addEdges(edges);
        }

        public void addEdges(int[][] edges) {
            for (int i = 0; i < V; i++) {
                graph.put(i, new ArrayList<>());
            }

            for (int[] edge : edges) {
                this.addEdge(edge[0], edge[1]);
            }

        }

        void addEdge(int u, int v) {
            if (graph.containsKey(u)) {
                List<Integer> neis = graph.get(u);
                if (neis != null) {
                    neis.add(v);
                }
                graph.put(u, neis);

            } else {
                List<Integer> nei = new ArrayList<>();
                nei.add(v);
                graph.put(u, nei);
            }

        }
    }

}
