package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import javafx.util.Pair;

/*https://github.com/cormacpayne/algorithms
 * A minimum spanning tree or minimum weight spanning tree is a subset of the edges of a connected,
 * edge-weighted undirected graph that connects all the vertices together, without any cycles and
 * with the minimum possible total edge weight. OR Subgraph of complete graph in which all nodes are
 * connected with minimum number of edges
 * Properties -->
 *        If it has N vertices then it should have n-1 edges
 *        No cycles
 *         Complete Graphs having N vertices we can create n^n-2 spanning trees
 */
public class PrimsOrMinimumSpanningTree {

  /*
      Time complexity : O(E Log V))
   */
  public static void main(String[] args) {
    int numberOfVertices = 5;

    int startVertex = 0;

    // Array of list
    List<Pair<Integer, Integer>>[] adj = new ArrayList[numberOfVertices];

    boolean[] mstSet = new boolean[numberOfVertices];

    int[] path = new int[numberOfVertices];

    Pair<Integer, Integer>[] distance = new Pair[numberOfVertices];

    numberOfVertices = numberOfVertices;

    List<Pair<Integer, Integer>> list = new ArrayList<>();
    list.add(new Pair(1, 4));
    list.add(new Pair(2, 1));
    adj[0] = list;

    list = new ArrayList<>();
    list.add(new Pair(0, 4));
    list.add(new Pair(2, 2));
    list.add(new Pair(4, 4));
    adj[1] = list;

    list = new ArrayList<>();
    list.add(new Pair(0, 1));
    list.add(new Pair(1, 2));
    list.add(new Pair(3, 4));
    adj[2] = list;

    list = new ArrayList<>();
    list.add(new Pair(2, 4));
    list.add(new Pair(4, 4));
    adj[3] = list;

    list = new ArrayList<>();
    list.add(new Pair(1, 4));
    list.add(new Pair(3, 4));
    adj[4] = list;

    // Initialize distance array set INFINITY
    for (int i = 0; i < numberOfVertices; i++) {
      distance[i] = new Pair<>(i, Integer.MAX_VALUE);
    }
    // Mark distance for start vertex
    distance[startVertex] = new Pair<>(startVertex, 0);
    // Set path of start vertex to itself
    path[startVertex] = startVertex;

    PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(
        Comparator.comparingInt(Pair::getValue));
    priorityQueue.add(distance[startVertex]);
    while (!priorityQueue.isEmpty()) {
      Integer u = priorityQueue.remove().getKey();
      mstSet[u] = true;
      // Get neighbors
      List<Pair<Integer, Integer>> adjVertices = adj[u];
      for (Pair<Integer, Integer> adjPair : adjVertices) {
        int adjVertex = adjPair.getKey();
        int weight = adjPair.getValue();
        int newDistance = distance[u].getValue() + weight;
        if (!mstSet[adjVertex] && distance[adjVertex].getValue() > newDistance) {
          priorityQueue.remove(distance[adjVertex]);
          distance[adjVertex] = new Pair<>(adjVertex, newDistance);
          path[adjVertex] = u;
          priorityQueue.add(distance[adjVertex]);
        }
      }
    }
    System.out.println("MST formed by edge");
    for (int i = 0; i < numberOfVertices; i++) {
      if (i != startVertex) {
        System.out.println((char) (i + 'A') + " - " + (char) (path[i] + 'A'));
      }
    }

  }
}
