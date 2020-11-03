package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PathFinder {

  private Map<Integer, List<Integer>> adjListMap;

  private int v;

  public void setAdjListMap(Map<Integer, List<Integer>> adjListMap) {
    this.adjListMap = adjListMap;
  }

  public void setV(int v) {
    this.v = v;
  }

  // With BFS

  public boolean isReachable(int source, int destination) {
    LinkedList<Integer> queue = new LinkedList();
    boolean[] visted = new boolean[v];
    visted[source] = true;
    queue.add(source);

    while (queue.size() != 0) {
      source = queue.poll();
      List<Integer> neighbours = adjListMap.get(source);
      for (int neighbour : neighbours) {
        if (neighbour == destination) {
          return true;
        }
        if (visted[neighbour] == false) {
          visted[neighbour] = true;
          queue.add(neighbour);
        }
      }
    }
    return false;
  }

}

