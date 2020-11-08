package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
Topological sorting for Directed Acyclic Graph (DAG) is a linear
ordering of vertices such that for every directed edge u v,
 vertex u comes before v in the ordering.

 */
public class TopologicalSortingWithDFS {


  private Map<Integer, List<Integer>> adjMap;

  private int v;

  public void setAdjMap(Map<Integer, List<Integer>> adjMap) {
    this.adjMap = adjMap;
  }

  public void setV(int v) {
    this.v = v;
  }

  // With DFS
  public void topologicallySorted(int i, boolean visted[], Stack<Integer> stack) {

    if (visted == null) {
      visted = new boolean[v];
    }
    visted[i] = true;

    // Recurse all neighbours of this
    List<Integer> neighbours = adjMap.get(i);
    if (neighbours != null) {
      for (int neighbor : neighbours) {
        if (visted[neighbor] == false) {
          topologicallySorted(neighbor, visted, stack);
        }
      }
    }
    // Push current vertex to stack
    stack.push(new Integer(i));
  }

  void topologicalSortedGraph() {
    Stack<Integer> stack = new Stack<Integer>();
    boolean[] visted = new boolean[v];
    for (int i = 0; i < v; i++) {
      visted[i] = false;
    }
    for (int i = 0; i < v; i++) {
      if (visted[i] == false) {
        topologicallySorted(i, visted, stack);
      }
    }

    // print stack
    while (stack.isEmpty() == false) {
      System.out.println(stack.pop());
    }
  }
}
