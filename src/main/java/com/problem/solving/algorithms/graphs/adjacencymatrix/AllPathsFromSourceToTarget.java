package com.problem.solving.algorithms.graphs.adjacencymatrix;

import java.util.ArrayList;
import java.util.List;

/*
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths
from node 0 to node n - 1, and return them in any order.
 */
public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1, 2},
                {3},
                {3},
                {},
        };
        int source = 0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        current.add(source);
        dfs(graph, source, graph.length - 1, current, result);

        for (List<Integer> ls : result) {
            for (Integer v : ls) {
                System.out.print(v + " ");
            }
            System.out.println("");
        }


    }

    // DFS
    public static void dfs(int[][] graph, int source, int target, List<Integer> current, List<List<Integer>> result) {

        // If source and destination are equal then we found path and add it in result list
        if (source == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        // explore neighbors nodes
        for (int nextNode : graph[source]) {
            // Add it into current list we will explore from this node in recursion
            current.add(nextNode);
            dfs(graph, nextNode, target, current, result);
            // Remove the previous choice before trying next choice
            current.remove(current.size() - 1);
        }
    }
}
