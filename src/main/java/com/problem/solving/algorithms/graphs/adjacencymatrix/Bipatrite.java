package com.problem.solving.algorithms.graphs.adjacencymatrix;

import java.util.LinkedList;

/*
1. Assign RED color to the source vertex (putting into set U).
2. Color all the neighbors with BLUE color (putting into set V).
3. Color all neighbor’s neighbor with RED color (putting into set U).
4. This way, assign color to all vertices such that it satisfies all the constraints of m way coloring problem where m = 2.
5. While assigning colors, if we find a neighbor which is colored with same color as current vertex, then the graph cannot be colored with 2 vertices (or graph is not Bipartite)
 */
public class Bipatrite {

  private int[][] G;

  private int V;

  public void setG(int[][] g) {
    G = g;
  }

  public void setV(int v) {
    V = v;
  }

  public boolean isBipartite(int src) {
    int colorArr[] = new int[V];
    for (int i = 0; i < V; ++i) {
      // Assign no color to all in start
      colorArr[i] = -1;
    }
    // Assign first color to source
    colorArr[src] = 1;

    // Create a queue (FIFO) of vertex numbers
    // and enqueue source vertex for BFS traversal
    LinkedList<Integer> q = new LinkedList<Integer>();
    q.add(src);
    while (q.size() != 0) {
      // Dequeue a vertex from queue
      int u = q.poll();

      // Return false if there is a self-loop
      if (G[u][u] == 1) {
        return false;
      }

      // Find all non-colored adjacent vertices
      for (int v = 0; v < V; ++v) {
        // An edge from u to v exists
        // and destination v is not colored
        if (G[u][v] == 1 && colorArr[v] == -1) {
          // Assign alternate color to this adjacent v of u
          colorArr[v] = 1 - colorArr[u];
          q.add(v);
        }

        // An edge from u to v exists and destination
        //  v is colored with same color as u
        else if (G[u][v] == 1 && colorArr[v] == colorArr[u]) {
          return false;
        }
      }
    }
    return true;
  }

}
