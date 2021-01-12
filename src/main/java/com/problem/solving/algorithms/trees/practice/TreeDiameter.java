package com.problem.solving.algorithms.trees.practice;

import java.util.ArrayList;
import java.util.List;

/*
  Given an undirected tree, return its diameter: the number of edges in a longest
  path in that tree
  TC O(N)
  SC O(N)
  First of all, we could convert the input edges into the adjacency list, which this time we would treat as Tree, rather than Graph. We assume the node with the index of 0 as the root node.
  We then define a function named dfs(curr, visited) which returns the maximal distance starting from the curr node to any of its descendant leaf nodes. The visited parameter is used to keep track of the nodes that we've visited so far.
  Within the function of dfs(curr, visited), we will obtain the top two maximal distances starting from the curr node. With these top two distances, we can then update the global diameter that we've seen so far.
  Once we traverse the entire tree once and only once, we will obtain the diameter of the tree/graph.
 */
public class TreeDiameter {

    private List<List<Integer>> graph;
    private Integer diameter = 0;

    public int treeDiameter(int[][] edges) {

        // build the adjacency list representation of the graph.
        this.graph = new ArrayList<>();
        boolean[] visited = new boolean[edges.length + 1];
        for (int i = 0; i < edges.length + 1; ++i) {
            this.graph.add(new ArrayList<>());
            visited[i] = false;
        }
        for (int[] edge : edges) {
            Integer u = edge[0], v = edge[1];
            this.graph.get(u).add(v);
            this.graph.get(v).add(u);
        }

        dfs(0, visited);

        return this.diameter;
    }

    /**
     * return the max distance
     * starting from the 'curr' node to its the leaf nodes
     */
    private int dfs(int curr, boolean[] visited) {
        // the top 2 distance starting from this node
        Integer topDistance1 = 0, topDistance2 = 0;

        visited[curr] = true;
        for (Integer neighbor : graph.get(curr)) {
            int distance = 0;
            if (!visited[neighbor])
                distance = 1 + this.dfs(neighbor, visited);

            if (distance > topDistance1) {
                topDistance2 = topDistance1;
                topDistance1 = distance;
            } else if (distance > topDistance2) {
                topDistance2 = distance;
            }
        }

        // with the top 2 distance, we can update the current diameter
        this.diameter = Math.max(this.diameter, topDistance1 + topDistance2);

        return topDistance1;
    }

}
