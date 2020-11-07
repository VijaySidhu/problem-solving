package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import javafx.util.Pair;

/*
    Time complexity is O(E logV)
 */
public class Dijkstra {

  /*
        Create Distance array which will hold distance from start vertex.
        Create Path array which will hold vertex which we got shortest distance
        Create Priority queue which will hold vertex next to be processed but in order of increasing weights
         Pseudocode
           i. Initialize distance for all vertices to inifinity. Set distance of source vertex to ZERO
          ii. Set path for source vertex to itself e.g path[sourceV] = sourceV
          iii.Add source vertex in priority queue with priority 0
          iv. Do the following until queue is not empty
                * Poll vertex (v) from queue & iterate through all adjacent vertices (neighbors)
                   ^ Update distance of neighbor
                        if(distance[neighbor] > distance[v]+weight)
                           then distance[v]  = distance[u]+weight
                           path[neighbor] = v;
                   ^ Add neighbor in queue



  */
  private int numberOfVertices;

  //Pair(vertex, weight)
  private List<Pair<Integer, Integer>>[] adjacencyList = null;

  private int[] path = null;

  private int[] distance = null;

  private int startVertex = 0;

  private PriorityQueue<Pair<Integer, Integer>> queue;

  public Dijkstra() {
    this.numberOfVertices = 5;
    this.adjacencyList = new ArrayList[numberOfVertices];
    path = new int[numberOfVertices];
    distance = new int[numberOfVertices];
    // Fill an array with -1
    Arrays.fill(distance, Integer.MAX_VALUE);
    // Distance of start vertex to itself is always zero
    distance[startVertex] = 0;
    // update path of start vertex to itself
    path[startVertex] = startVertex;

    // Initialize graph
    List<Pair<Integer, Integer>> list = new ArrayList<>();
    list.add(new Pair(1, 4));
    list.add(new Pair(2, 1));
    adjacencyList[0] = list;

    list = new ArrayList<>();
    list.add(new Pair(4, 4));
    adjacencyList[1] = list;

    list = new ArrayList<>();
    list.add(new Pair(1, 2));
    list.add(new Pair(3, 4));
    adjacencyList[2] = list;

    list = new ArrayList<>();
    list.add(new Pair(4, 4));
    adjacencyList[3] = list;

    list = new ArrayList<>();
    adjacencyList[4] = list;
    queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
    queue.add(new Pair<>(startVertex, 0));
  }

  public void shortestPath() {

    while (queue.isEmpty() == false) {
      Pair<Integer, Integer> vertexPair = queue.remove();
      Integer vertex = vertexPair.getKey();
      // Get all neighbours
      List<Pair<Integer, Integer>> adjVertices = adjacencyList[vertexPair.getKey()];

      // Iterate through all adjacents vertices
      if (adjVertices != null) {
        for (Pair<Integer, Integer> adjPair : adjVertices) {
          int adjVertex = adjPair.getKey();
          int weight = adjPair.getValue();

          // Calculate new distance
          int newDistance = distance[vertex] + weight;

          // if new distance is less than previous distance keep new distance and take vertex on path
          if (distance[adjVertex] == -1 || distance[adjVertex] > newDistance) {
            distance[adjVertex] = newDistance;
            path[adjVertex] = vertex;
            queue.add(new Pair<>(adjVertex, distance[adjVertex]));
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
