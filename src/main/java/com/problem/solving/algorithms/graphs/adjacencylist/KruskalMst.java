package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalMst {

  /*
     Alway select least weight edge to sart with and go in same fashion
     Any edge that creates cycle ignore that edge this approach minimum spanning tree for graph
     Time complexity (O(E log V))
     First, the edge having minimum cost/weight is found in the given graph.
The two initial vertices (vertex A, B of minimum cost edge) is added to visited/added set.
Now, all the connected edges with newly added vertex are added to priority queue.
The least cost vertex (add all the connected edges of pop vertex to priority queue) is popped from the priority queue and repeat until number of edges is equal to vertices-1.
By using priority queue time complexity will be reduced to (O(E log V)) where E is the number of edges and V is the number of vertices.
Pair class is also used to store the weights.
   */
  public static void main(String[] args) {

    int noOfVertices = 7;

    List<int[]> adj = new ArrayList<>();
    //int[] = {source, destination, weight}
    adj.add(new int[]{1, 2, 28});
    adj.add(new int[]{1, 6, 10});
    adj.add(new int[]{2, 7, 14});
    adj.add(new int[]{2, 3, 16});
    adj.add(new int[]{3, 2, 16});
    adj.add(new int[]{3, 4, 12});
    adj.add(new int[]{4, 7, 18});
    adj.add(new int[]{4, 3, 12});
    adj.add(new int[]{4, 5, 22});
    adj.add(new int[]{5, 7, 24});
    adj.add(new int[]{5, 6, 25});
    adj.add(new int[]{5, 4, 22});
    adj.add(new int[]{6, 1, 10});
    adj.add(new int[]{6, 5, 25});
    adj.add(new int[]{7, 4, 18});
    adj.add(new int[]{7, 5, 24});
    adj.add(new int[]{7, 2, 14});

    PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);

    for (int[] edges : adj) {
      q.add(edges);
    }

    List<int[]> mst = new ArrayList<>();

    while (!q.isEmpty() && mst.size() < noOfVertices - 1) {
      int[] edge = q.poll();

      int source = edge[0];
      int destination = edge[1];

      if (!isCycle(source, destination, mst, new boolean[mst.size()])) {
        mst.add(edge);
      }
    }

    System.out.println("MST formed by edges :");
    for (int[] edge : mst) {
      System.out
          .println((char) (edge[0] + 'A') + " - " + (char) (edge[1] + 'A') + " --> " + edge[2]);
    }
  }

  static boolean isCycle(int source, int destination, List<int[]> mst, boolean[] visited) {
    if (source == destination) {
      return true;
    }
    boolean flag = false;
    for (int i = 0; i < mst.size(); i++) {
      int[] edge = mst.get(i);
      if (!visited[i]) {
        if (source == edge[0]) {
          visited[i] = true;
          flag = flag || isCycle(edge[1], destination, mst, visited);
          visited[i] = false;
        }
        if (source == edge[1]) {
          visited[i] = true;
          flag = flag || isCycle(edge[0], destination, mst, visited);
          visited[i] = false;
        }
      }
    }
    return flag;
  }

}
