package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class StronglyConnected {

  /*
      1. Traverse orignal graph with DFS and put each visited source node into stack
      2. Get Transpose of orignal graph
      3. Traverse transposed graph with DFS and order defined by stack
   */
  public void getStronglyConnected(Map<Integer, List<Integer>> graph) {
    boolean[] visited = new boolean[graph.size() + 1];
    Stack stack = new Stack();
    // Mark all nodes not visited
    for (int i = 0; i < graph.size() + 1; i++) {
      visited[i] = false;
    }
    // build stack for each vertex if it's not visted
    for (int i = 0; i < graph.size() + 1; i++) {
      if (visited[i] == false) {
        buildStack(i, visited, stack, graph);
      }
    }
    // Get Transpose of graph
    Map<Integer, List<Integer>> transposed = getTransponse(graph);

    // Traverse transposed graph  with dfs
    // Mark all nodes not visited
    for (int i = 0; i < transposed.size() + 1; i++) {
      visited[i] = false;
    }
    /// Process all vertices order defined by stack
    while (stack.empty() == false) {
      //pop vertex from stack
      int v = (int) stack.pop();
      if (visited[v] == false) {
        dfs(v, visited, transposed);
        System.out.println("");
      }
    }
  }

  private Map<Integer, List<Integer>> getTransponse(Map<Integer, List<Integer>> graph) {
    Map<Integer, List<Integer>> transposedGraph = new HashMap<>();
    for (Integer u : graph.keySet()) {
      for (Integer v : graph.get(u)) {
        List<Integer> neighbors = transposedGraph.get(v);
        if (null == neighbors) {
          neighbors = new ArrayList<>();
          transposedGraph.put(u, neighbors);
        }
        neighbors.add(u);
      }
    }
    return transposedGraph;
  }

  private void buildStack(int source, boolean[] visited, Stack stack,
      Map<Integer, List<Integer>> graph) {
    visited[source] = true;
    List<Integer> neighbors = graph.get(source);
    if (neighbors != null) {
      for (int neighbor : neighbors) {
        if (visited[neighbor] == false) {
          visited[neighbor] = true;
          buildStack(neighbor, visited, stack, graph);
        }
      }
      stack.push(new Integer(source));
    }
  }

  private void dfs(int source, boolean[] visited, Map<Integer, List<Integer>> transposedGraph) {
    visited[source] = true;
    System.out.println(source);
    List<Integer> neighbors = transposedGraph.get(source);
    if (neighbors != null) {
      for (int neighbor : neighbors) {
        if (visited[neighbor] == false) {
          dfs(neighbor, visited, transposedGraph);
        }
      }
    }
  }
}
