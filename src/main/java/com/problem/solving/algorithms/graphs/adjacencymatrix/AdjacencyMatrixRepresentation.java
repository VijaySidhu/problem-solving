package com.problem.solving.algorithms.graphs.adjacencymatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * https://github.com/haifengl/smile/tree/master/graph/src/main/java/smile/graph Time Complexity
 * Removing O(1) Queries O(1). Adding vertex O(v^2)
 * <p>
 * Space complexity O(v^2)
 */
public class AdjacencyMatrixRepresentation {

  /**
   * Number of vertices
   */
  private int n;

  /**
   * Is directed graph
   */
  private boolean diagraph;

  /**
   * Adcency matrix, non zero values are weight of edges
   */
  private int[][] graph;

  public AdjacencyMatrixRepresentation(int n) {
    this(n, false);
  }

  public AdjacencyMatrixRepresentation(int n, boolean diagraph) {
    this.n = n;
    this.diagraph = diagraph;
    graph = new int[n][n];
  }

  public static void main(String[] args) {
    AdjacencyMatrixRepresentation matGraph = new AdjacencyMatrixRepresentation(4);
    System.out.println(matGraph.getNumVertices());
    matGraph.addEdge(1, 2);
    matGraph.addEdge(1, 3);
    matGraph.addEdge(0, 3);
    matGraph.getOutNeighbours(1).stream().forEach(i -> {
      System.out.println(i);
    });
    matGraph.getInNeighbours(0).stream().forEach(i -> {
      System.out.println(i);
    });
  }

  public int getNumVertices() {
    return n;
  }

  public boolean hasEdge(int source, int target) {
    return graph[source][target] != 0.0;
  }

  public int getWeight(int source, int target) {
    return graph[source][target];
  }

  public AdjacencyMatrixRepresentation setWeight(int source, int target, int weight) {
    graph[source][target] = weight;
    if (!diagraph) {
      graph[target][source] = weight;
    }
    return this;
  }

  public void addVertex() {
    int v = getNumVertices();
    if (v >= graph.length) {
      int[][] newAdjacencyList = new int[v * 2][v * 2];
      for (int i = 0; i < graph.length; i++) {
        for (int j = 0; j < graph.length; j++) {
          newAdjacencyList[i][j] = graph[i][j];
        }
      }
      graph = newAdjacencyList;
    }
  }

  public void addEdge(int v, int w) {
    graph[v][w] += 1;
  }

  /**
   * finding all  out-neighbors of a vertex. If there are multiple edges between vertex this
   * neighbour appears once in the list
   *
   * @param v
   * @return
   */
  public List<Integer> getOutNeighbours(int v) {
    List<Integer> neighbours = new ArrayList<>();
    for (int i = 0; i < getNumVertices(); i++) {
      for (int j = 0; j < graph[v][i]; j++) {
        neighbours.add(i);
      }
    }
    return neighbours;
  }

  public List<Integer> getInNeighbours(int v) {
    List<Integer> inNeighbours = new ArrayList<>();
    for (int i = 0; i < getNumVertices(); i++) {
      for (int j = 0; j < graph[i][v]; j++) {
        inNeighbours.add(i);
      }
    }
    return inNeighbours;
  }
}
