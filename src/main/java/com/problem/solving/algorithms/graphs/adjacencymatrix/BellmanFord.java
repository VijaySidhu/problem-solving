package com.problem.solving.algorithms.graphs.adjacencymatrix;

/*
Calculate shortest path in BellmanFord with negative weights
It can detect if negative cycles are present in BellmanFord
Always consider previous state of BellmanFord while handling current state
If in last iteration all weight values are same then no negative cycle otherwise negative cycle algorithm will not work if there is negative cycle but will work if there is negative edge
https://www.youtube.com/watch?v=eoT31ZKjbUA&ab_channel=5MinutesEngineering
Time complexity O(VE)
https://github.com/dineshappavoo/BellmanFordShortestPath/blob/master/src/shortestpath/BellmanFordAlgorithm.java
 */
public class BellmanFord {

  /*
  1. Initialize all distances from source to all vertices as inifinte and distance of source to itself is zero.Create an array dist[] of size |V| with all values as infinite except dist[src] where src is source vertex.
  2. Repeat following steps V-1 times where v is number of vertices
      Do following for each edge u-v
      if dist[v] > dis[u] + weight of edge (uv) then update dist[v]
        dist[v] = dis[u]+weight

  3. This steps reports if there is negative cycle in BellmanFord. Do following
      for each u-v edge
      if dist[v]>dis[u]+weight (BellmanFord contains negative cycle)
      The idea of step 3 is, step 2 guarantees shortest distances if BellmanFord doesn't
      contain negative cycle. If we iterate through all edges one more time
      and get shorter path of any vertex (Updated distance for any vertex) means
      there is negative cycle.
   */

  int V, E;

  Edge edge[];

  // Creates a BellmanFord with V vertices and E edges
  BellmanFord(int v, int e) {
    V = v;
    E = e;
    edge = new Edge[e];
    for (int i = 0; i < e; ++i) {
      edge[i] = new Edge();
    }
  }

  // Driver method to test above function
  public static void main(String[] args) {
    int V = 5; // Number of vertices in BellmanFord
    int E = 8; // Number of edges in BellmanFord

    BellmanFord BellmanFord = new BellmanFord(V, E);

    // add edge 0-1 (or A-B in above figure)
    BellmanFord.edge[0].src = 0;
    BellmanFord.edge[0].dest = 1;
    BellmanFord.edge[0].weight = -1;

    // add edge 0-2 (or A-C in above figure)
    BellmanFord.edge[1].src = 0;
    BellmanFord.edge[1].dest = 2;
    BellmanFord.edge[1].weight = 4;

    // add edge 1-2 (or B-C in above figure)
    BellmanFord.edge[2].src = 1;
    BellmanFord.edge[2].dest = 2;
    BellmanFord.edge[2].weight = 3;

    // add edge 1-3 (or B-D in above figure)
    BellmanFord.edge[3].src = 1;
    BellmanFord.edge[3].dest = 3;
    BellmanFord.edge[3].weight = 2;

    // add edge 1-4 (or A-E in above figure)
    BellmanFord.edge[4].src = 1;
    BellmanFord.edge[4].dest = 4;
    BellmanFord.edge[4].weight = 2;

    // add edge 3-2 (or D-C in above figure)
    BellmanFord.edge[5].src = 3;
    BellmanFord.edge[5].dest = 2;
    BellmanFord.edge[5].weight = 5;

    // add edge 3-1 (or D-B in above figure)
    BellmanFord.edge[6].src = 3;
    BellmanFord.edge[6].dest = 1;
    BellmanFord.edge[6].weight = 1;

    // add edge 4-3 (or E-D in above figure)
    BellmanFord.edge[7].src = 4;
    BellmanFord.edge[7].dest = 3;
    BellmanFord.edge[7].weight = -3;

    BellmanFord.BellmanFord(BellmanFord, 0);
  }

  // The main function that finds shortest distances from src
  // to all other vertices using Bellman-Ford algorithm. The
  // function also detects negative weight cycle
  void BellmanFord(BellmanFord BellmanFord, int src) {
    int V = BellmanFord.V, E = BellmanFord.E;
    int dist[] = new int[V];

    // Step 1: Initialize distances from src to all other
    // vertices as INFINITE
    for (int i = 0; i < V; ++i) {
      dist[i] = Integer.MAX_VALUE;
    }
    dist[src] = 0;

    // Step 2: Relax all edges |V| - 1 times. A simple
    // shortest path from src to any other vertex can
    // have at-most |V| - 1 edges
    for (int i = 1; i < V; ++i) {
      for (int j = 0; j < E; ++j) {
        int u = BellmanFord.edge[j].src;
        int v = BellmanFord.edge[j].dest;
        int weight = BellmanFord.edge[j].weight;
        if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
          dist[v] = dist[u] + weight;
        }
      }
    }

    // Step 3: check for negative-weight cycles. The above
    // step guarantees shortest distances if BellmanFord doesn't
    // contain negative weight cycle. If we get a shorter
    // path, then there is a cycle.
    for (int j = 0; j < E; ++j) {
      int u = BellmanFord.edge[j].src;
      int v = BellmanFord.edge[j].dest;
      int weight = BellmanFord.edge[j].weight;
      if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
        System.out.println("BellmanFord contains negative weight cycle");
        return;
      }
    }
    printArr(dist, V);
  }

  // A utility function used to print the solution
  void printArr(int dist[], int V) {
    System.out.println("Vertex Distance from Source");
    for (int i = 0; i < V; ++i) {
      System.out.println(i + "\t\t" + dist[i]);
    }
  }

  // A class to represent a weighted edge in BellmanFord
  class Edge {

    int src, dest, weight;

    Edge() {
      src = dest = weight = 0;
    }
  }
}
