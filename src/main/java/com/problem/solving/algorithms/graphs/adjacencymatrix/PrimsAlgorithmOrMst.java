package com.problem.solving.algorithms.graphs.adjacencymatrix;

public class PrimsAlgorithmOrMst {

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
  private int numberOfVertices;

  public PrimsAlgorithmOrMst(int numberOfVertices) {
    this.numberOfVertices = numberOfVertices;
  }

  public static void main(String[] args) {
    PrimsAlgorithmOrMst mst = new PrimsAlgorithmOrMst(5);
    int graph[][] = new int[][]{{0, 2, 0, 6, 0},
        {2, 0, 3, 8, 5},
        {0, 3, 0, 0, 7},
        {6, 8, 0, 0, 9},
        {0, 5, 7, 9, 0}};
    mst.minimumSpanningTreeWithPrims(graph);
  }

  public void minimumSpanningTreeWithPrims(int[][] graph) {
    // Create an array to store minimum spanning tree
    int[] mst = new int[numberOfVertices];
    // Create an array to store key values
    int[] keyValues = new int[numberOfVertices];
    //Create tracker array to track if vertex is included in mst or not.
    boolean[] mstTrack = new boolean[numberOfVertices];

    // Initialize all key values to infinity and mst to false
    for (int i = 0; i < numberOfVertices; i++) {
      keyValues[i] = Integer.MAX_VALUE;
      mstTrack[i] = false;
    }

    // Initialize Key of source vertex to ZERO and set tracker to true in tracker array.
    keyValues[0] = 0;
    // First node is always root node of MST
    mst[0] = -1;

    // MST will have V vertices
    for (int count = 0; count < numberOfVertices - 1; count++) {
      // Pick minimum key vertex from set of vertices
      int u = minKey(keyValues, mstTrack);
      // Add picked vertex to set
      mstTrack[u] = true;

      // Traverse adjacents of picked vertext update keyValue and mst
      // if mstTrack of v is false and if weight (u-v) is smaller than key[v]
      for (int v = 0; v < numberOfVertices; v++) {
        int weight = graph[u][count];
        if (mstTrack[count] == false && weight < keyValues[count]) {
          mst[count] = u;
          keyValues[count] = weight;
        }
      }
    }
    printMinimumSpanningTree(mst, graph);
  }

  private void printMinimumSpanningTree(int[] mst, int[][] graph) {
    System.out.println("Edge \tWeight");
    for (int i = 1; i < numberOfVertices; i++) {
      System.out.println(mst[i] + " - " + i + "\t" + graph[i][mst[i]]);
    }
  }

  private int minKey(int[] keyValues, boolean[] mstTrack) {
    // Initialize min value
    int min = Integer.MAX_VALUE, min_index = -1;

    for (int v = 0; v < numberOfVertices; v++) {
      if (mstTrack[v] == false && keyValues[v] < min) {
        min = keyValues[v];
        min_index = v;
      }
    }
    return min_index;
  }
}
