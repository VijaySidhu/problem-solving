package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Operations {

  private Map<Integer, List<Integer>> graphAdjList;

  private int v;

  void breadthFirstSearchTraverse(int source) {

    boolean[] visited = new boolean[v];

    // Create queue for BFS
    LinkedList<Integer> queue = new LinkedList<>();

    // Mark current node as visited and add it to queue
    visited[source] = true;
    queue.add(source);

    while (queue.size() != 0) {
      //dqueue vertex from q and print it
      source = queue.poll();
      System.out.println(source + " ");

      // Get all neighbours of source if not visited mark visted and enQ those

      List<Integer> neighbours = graphAdjList.get(source);
      for (int neighbour : neighbours) {
        // Mark visted if not already visted and add it to Queue
        if (visited[neighbour] == false) {
          visited[neighbour] = true;
          queue.add(neighbour);
        }
      }
    }
  }

  public void setGraphAdjList(Map<Integer, List<Integer>> graphAdjList) {
    this.graphAdjList = graphAdjList;
  }

  public void setV(int v) {
    this.v = v;
  }

}
