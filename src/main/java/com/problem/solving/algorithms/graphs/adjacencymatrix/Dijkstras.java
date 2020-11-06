package com.problem.solving.algorithms.graphs.adjacencymatrix;


public class Dijkstras {


  /*
  1. Create an array (SPT) that keeps track of nodes who distance is calculated and finalized
  2. Create distance array and initialize with MAX value.
      i. Assign ZERO distance value to source vertex
  3. Do the following for all vertices
      i.  Pick vertex u which is not in SPT and has minimum distance value
      ii. Include u to SPT (Shortest path tree).
      iii.Update distance value of all adjacents vertices (v) of u.
              a. Loop over all adjacents
              b. if distance of v is greater than distance of u plus weight
                      dist[v] > dist[u]+weight;
                      dist[v] = dist[u]+weight;
   4. Print distance array
   */

  private int numberOfVertices;

  public Dijkstras(int numberOfVertices) {
    this.numberOfVertices = numberOfVertices;
  }

  public static void main(String[] args) {
    Dijkstras dijkstras = new Dijkstras(9);
    /* Let us create the example graph discussed above */
    int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
        {4, 0, 8, 0, 0, 0, 0, 11, 0},
        {0, 8, 0, 7, 0, 4, 0, 0, 2},
        {0, 0, 7, 0, 9, 14, 0, 0, 0},
        {0, 0, 0, 9, 0, 10, 0, 0, 0},
        {0, 0, 4, 14, 10, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 1, 6},
        {8, 11, 0, 0, 0, 0, 1, 0, 7},
        {0, 0, 2, 0, 0, 0, 6, 7, 0}};
    dijkstras.dijkstra(graph, 0);
  }

  public void dijkstra(int[][] graph, int source) {
    // Create distance array
    int[] distance = new int[numberOfVertices];
    // create shortest path tree to keep track of all addressed nodes
    Boolean[] spt = new Boolean[numberOfVertices];
    // Initialize all distance to INFINITE and spt to false
    for (int i = 0; i < numberOfVertices; i++) {
      distance[i] = Integer.MAX_VALUE;
      spt[i] = false;
    }
    // Set source node distance to zero
    distance[source] = 0;

    // Find shortest path of all vertices
    for (int count = 0; count < numberOfVertices - 1; count++) {
      // Always pick minimum distance vertex (Not processed)
      int u = minDistace(distance, spt);
      // Mark picked vertex as processed
      spt[u] = true;
      // Update distance value of all neighbours
      //  if neighbour is not addressed and distance of neighbour is > distance of parent+weight
      for (int neighbour = 0; neighbour < numberOfVertices; neighbour++) {
        int weight = graph[u][neighbour];
        if (spt[neighbour] == false && distance[neighbour] > distance[u] + weight
            && distance[neighbour] != Integer.MAX_VALUE
            && weight != 0) {
          distance[neighbour] = distance[u] + weight;
        }
      }

    }
    // Print distance array to get shortest path
    printShortestPath(distance);
  }

  private void printShortestPath(int[] distance) {
    System.out.println("Vertex distance from source");
    for (int i = 0; i < numberOfVertices; i++) {
      System.out.println(i + "\t\t" + distance[i]);
    }

  }

  // Utility function to find the vertex with minimum distance value,
  // from the set of vertices not yet included in shortest path
  private int minDistace(int[] distance, Boolean[] spt) {
    // Initialize min value
    int min = Integer.MAX_VALUE, min_index = -1;
    for (int v = 0; v < numberOfVertices; v++) {
      if (spt[v] == false && distance[v] <= min) {
        min = distance[v];
        min_index = v;
      }
    }
    return min_index;
  }


}
