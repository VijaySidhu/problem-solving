package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ShortestPathUnWeightedGraph {

  Queue<Integer> queue;

  private int numberOfVertices;

  private int startVertex;

  private Map<Integer, List<Integer>> unweightedGraph;

  private int[] path;

  private int[] distance;

  public ShortestPathUnWeightedGraph(int numberOfVertices, int startVertex,
      Map<Integer, List<Integer>> unweightedGraph) {
    this.numberOfVertices = numberOfVertices;
    this.startVertex = startVertex;
    this.unweightedGraph = unweightedGraph;
    this.path = new int[numberOfVertices];
    this.distance = new int[numberOfVertices];
    // Fill an array with -1
    Arrays.fill(distance, -1);

    // Mark distance for start vertex is 0;
    distance[startVertex] = 0;

    // update path for start vertex to itself
    path[startVertex] = startVertex;

    // Build Queue for BFS and start node in queue
    queue = new LinkedList<>();
    queue.add(startVertex);

  }

  /*
      1. We need distance array which will hold the distance from start vertex.
      2. We need path array which will hold the vertex through which we got the shortest distance.
      3. We need to go in Breadth first fashion. ( So we need Queue).
   */
  public void shortestPathUnweightedGraph() {
    while (queue.size() != 0) {
      int vertex = queue.remove();
      List<Integer> adjacentsOfCurrentVertex = unweightedGraph.get(vertex);
      if (adjacentsOfCurrentVertex != null) {
        for (Integer adjVertex : adjacentsOfCurrentVertex) {
          if (distance[adjVertex] == -1) {
            // Update distance
            distance[adjVertex] = distance[vertex] + 1;
            //update path
            path[adjVertex] = vertex;
            queue.add(adjVertex);
          }
        }

      }
    }
    System.out.println("Distance from " + (char) (startVertex + 'A') + " :");
    for (int i = 0; i < numberOfVertices; i++) {
      System.out.print("Distance to " + (char) (i + 'A') + " is " + distance[i]);
      System.out.println(" from path " + (char) (path[i] + 'A'));
    }
  }
}
