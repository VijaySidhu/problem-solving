package com.problem.solving.algorithms.graphs.adjacencymatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import javafx.util.Pair;

public class PrimsWithBinHeapEfficient {


  /*
      1. Create set of MST that keeps track of vertices already added in MST.
      2. Create Key set to save key value. Initialize all vertices with INFINITY.
           i. Assign Key value ZERO to source node
      3. Do the following until all vertices are not added to MST.
          i.  Pick vertex u which is not in MST and has minimum key value.
          ii. Include u to MST.
          iii.Update key value of all adjacent of u.
               a.) To update key value loop over all adjacents.
                   For each adjacent vertix v,
                   If weight of edge u to v is less than previous key value
                   then update key value as weight of u to v.

   */
  public static void main(String[] args) {
    int noOfVertices = 5;
    int startVertex = 0;  // A is start vertex

    List<Pair<Integer, Integer>>[] adj = new ArrayList[noOfVertices];

    //Pair(vertex, weight)
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

    int[] path = new int[noOfVertices];
    Pair<Integer, Integer>[] distance = new Pair[noOfVertices];
    boolean[] mstset = new boolean[noOfVertices];

    // Intialize distance array
    for (int i = 0; i < noOfVertices; i++) {
      distance[i] = new Pair<Integer, Integer>(i, Integer.MAX_VALUE);
    }

    distance[startVertex] = new Pair<>(startVertex, 0); // Making distance for start vertex 0
    path[startVertex] = startVertex; // Updating path for start vertex to itself

    PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>(
        (a, b) -> a.getValue() - b.getValue());
    q.add(distance[startVertex]);

    while (!q.isEmpty()) {
      Pair<Integer, Integer> vertexPair = q.remove();
      Integer vertex = vertexPair.getKey();
      mstset[vertex] = true;

      List<Pair<Integer, Integer>> adjVertices = adj[vertex];

      for (Pair<Integer, Integer> adjPair : adjVertices) {
        int adjVertex = adjPair.getKey();
        int weight = adjPair.getValue();

        int newDistance = distance[vertex].getValue() + weight;
        if (!mstset[adjVertex] && distance[adjVertex].getValue() > newDistance) {
          q.remove(distance[adjVertex]);
          distance[adjVertex] = new Pair<>(adjVertex, newDistance);
          path[adjVertex] = vertex;
          q.add(distance[adjVertex]);
        }
      }
    }

    System.out.println("MST formed by edges :");
    for (int i = 0; i < noOfVertices; i++) {
      if (i != startVertex) {
        System.out.println((char) (i + 'A') + " - " + (char) (path[i] + 'A'));
      }
    }
  }
}

