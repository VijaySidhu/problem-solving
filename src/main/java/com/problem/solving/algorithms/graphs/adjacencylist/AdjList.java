package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjList {

  private Map<Integer, List<Integer>> adjListMap;

  private int numVertices;

  private int numEdges;

  /**
   * Create Empty graph
   */
  public AdjList() {
    adjListMap = new HashMap<>();
  }

  public static void main(String[] args) {
    AdjList adjList = new AdjList();
    adjList.addVertex();
    adjList.addEdge(0, 1);
    adjList.addEdge(0, 4);
    adjList.addEdge(1, 2);
    adjList.addEdge(1, 3);
    adjList.getOutNeighbour(0).stream().forEach(i -> {
      System.out.println(i);
    });
  }

  public Map<Integer, List<Integer>> getAdjListMap() {
    return adjListMap;
  }

  public int getNumEdges() {
    return numEdges;
  }

  public void addVertex() {
    int v = getNumVertices();
    List<Integer> neighbours = new ArrayList<>();
    adjListMap.put(v, neighbours);
  }

  public void addEdge(int v, int w) {
    List<Integer> currentNeighbours = adjListMap.get(v);
    if (currentNeighbours != null) {
      currentNeighbours.add(w);
    } else {
      currentNeighbours = new ArrayList<>();
      currentNeighbours.add(w);
    }
    adjListMap.put(v, currentNeighbours);
  }

  public List<Integer> getOutNeighbour(int v) {
    return new ArrayList<Integer>(adjListMap.get(v));
  }

  public List<Integer> getInNeighbour(int v) {
    List<Integer> inNeighbors = new ArrayList<Integer>();
    for (int u : adjListMap.keySet()) {
      for (int w : adjListMap.get(u)) {
        if (v == w) {
          inNeighbors.add(u);
        }

      }
    }
    return inNeighbors;
  }

  public int getNumVertices() {
    return numVertices;
  }

}
