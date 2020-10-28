package com.problem.solving.algorithms.graphs;

/**
 * Created by VijaySidhu on 6/24/2018.
 */
public class MotherVertex {


  /**
   * Do DFS while traversal keep track of last finished vertex. O(v+E) If there exist mother vertex
   * then v must be one of them. Check if V is a mother vertex by doing DFS/BFS from V. This also
   * takes O(V+E)
   */


  public static void motherVertextWithDFS(Graph graph) {
    boolean visited[] = new boolean[graph.getVertices()];
  }


}
