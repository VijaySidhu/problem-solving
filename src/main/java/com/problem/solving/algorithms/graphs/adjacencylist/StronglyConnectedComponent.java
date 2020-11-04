package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
All vertices are reachable from each other
We can find all strongly
connected components in O(V+E) time using Kosaraju’s algorithm.
Space complexity O(v)
 * Given a directed graph, find all strongly connected components in this graph.
 * We are going to use Kosaraju's algorithm to find strongly connected component.
 *
 * Algorithm
 * Create a order of vertices by finish time in decreasing order.
 * Reverse the graph
 * Do a DFS on reverse graph by finish time of vertex and created strongly connected
 * components.
 *
 * Runtime complexity - O(V + E)
 * Space complexity - O(V)
 Three steps
 1. DFS
 2. Reverse graph (tranponse)
 3. Fill order (Results)
 */
public class StronglyConnectedComponent {

  private Map<Integer, List<Integer>> stronglyConnectedG;

  private int vertices;

  public Map<Integer, List<Integer>> getStronglyConnectedG() {
    return stronglyConnectedG;
  }

  public void setStronglyConnectedG(
      Map<Integer, List<Integer>> stronglyConnectedG) {
    this.stronglyConnectedG = stronglyConnectedG;
  }

  public int getVertices() {
    return vertices;
  }

  public void setVertices(int vertices) {
    this.vertices = vertices;
  }

  // 1.
  public void dfs(int v, boolean[] visited) {
    if (visited == null) {
      visited = new boolean[this.vertices];
    }
    visited[v] = true;
    System.out.println(v);
    // Get neighbours
    List<Integer> neighbours = stronglyConnectedG.get(v);
    if (neighbours != null) {
      for (int neighbour : neighbours) {
        if (visited[neighbour] == false) {
          visited[neighbour] = true;
          dfs(neighbour, visited);
        }
      }
    }
  }

  // 2.
  public Map<Integer, List<Integer>> transpose() {
    return AdjList.transpose(stronglyConnectedG);
  }

  // 3.
  public void fillOrderWithResults(int v, boolean[] visited, Stack stack) {
    if (visited == null) {
      visited = new boolean[this.vertices];
    }
    if (stack == null) {
      stack = new Stack();
    }
    // Mark current node as visited
    visited[v] = true;

    // get all neighbours and recurse those
    List<Integer> neighbours = stronglyConnectedG.get(v);

    if (neighbours != null) {
      for (int neighbor : neighbours) {
        if (visited[neighbor] == false) {
          fillOrderWithResults(neighbor, visited, stack);
        }
      }
      stack.push(new Integer(v));
    }

  }

  public void printStronglyConnectedComponents() {
    Stack stack = new Stack();

    // Mark all the vertices as not visited (For first DFS)
    boolean visited[] = new boolean[this.vertices];
    for (int i = 0; i < this.vertices; i++) {
      visited[i] = false;
    }

    // Fill vertices in stack according to their finishing
    // times
    for (int i = 0; i < this.vertices; i++) {
      if (visited[i] == false) {
        fillOrderWithResults(i, visited, stack);
      }
    }
    Map<Integer, List<Integer>> transposed = this.transpose();
    stronglyConnectedG = transposed;
    // Second pass on Transposed graph
    // Mark all the vertices as not visited (For second DFS)
    for (int i = 0; i < this.vertices; i++) {
      visited[i] = false;
    }
    // Now process all vertices in order defined by Stack
    while (stack.empty() == false) {
      // Pop a vertex from stack
      int v = (int) stack.pop();
      // Print Strongly connected component of the popped vertex
      if (visited[v] == false) {
        dfs(v, visited);
        System.out.println();
      }
    }
  }


}
