package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.List;
import java.util.Map;

public class DetectCycle {

  /*
   * DFS can be used to detect cycle in graph.
   * DFS for connected graph produces tree. There is cycle
   * in graph only if there is back edge(Edge from node to itself )
   *  present
   * Time complexity O(V+E)
   * Space O(V)
   */

  private Map<Integer, List<Integer>> adjListMap;

  private int v;

  public void setAdjListMap(Map<Integer, List<Integer>> adjListMap) {
    this.adjListMap = adjListMap;
  }

  public void setV(int v) {
    this.v = v;
  }

  public boolean isCyclic(int i, boolean[] visited, boolean[] recursionStack) {

    // initilize visted and recursion stack
    if (visited == null && recursionStack == null) {
      visited = new boolean[v];
      recursionStack = new boolean[v];
    }
    // If current node is on recursion stack return true;
    if (recursionStack[i]) {
      return true;
    }
    if (visited[i]) {
      return false;
    }
    // Mark current node as visited
    visited[i] = true;
    recursionStack[i] = true;

    List<Integer> neighbours = adjListMap.get(i);
    if (neighbours != null) {
      for (int neighbor : neighbours) {
        if (isCyclic(neighbor, visited, recursionStack)) {
          return true;
        }
      }
    }
    recursionStack[i] = false;
    return false;
  }


}
