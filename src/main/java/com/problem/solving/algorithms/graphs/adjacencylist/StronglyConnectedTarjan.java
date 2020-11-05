package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.Stack;

/*
Tarjan Algorithm is based on following facts:
1. DFS search produces a DFS tree/forest
2. Strongly Connected Components form subtrees of the DFS tree.
3. If we can find the head of such subtrees, we can print/store all the nodes in that subtree (including head) and that will be one SCC.
4. There is no back edge from one SCC to another (There can be cross edges, but cross edges will not be used while processing the graph).
https://www.youtube.com/watch?v=xCdIBaizWdc&ab_channel=AlgorithmsMadeEasy
https://github.com/Algorithms-Made-Easy/Graphs
     Pseudo Code
* A dfs is run over the nodes and the subtrees of SCCs are removed and recorded as they are encounered
* Two values dfs_num(u) and dfs_low(u) are maintained for each of the users. dfs_num(u) is the value of the counter when the node u is explored for the first time. dfs_low(u) stores the lowest dfs_num reachable from u which is not the part of another SCC.
* As the nodes are explored, they are pushed onto a stack.
* The unexplored children of a node are explored and dfs_low(u) is accordingly updated.
* A node is encountered with dfs_low(u) == dfs_num(u) is the first explored node in its strongly connected component and all the nodes above it in the stack are popped out and assigned the appropriate SCC number.
Complexity
Time : O(v+e)
Space O(v)

 */
public class StronglyConnectedTarjan {

  // Discovery time , Low value , visited and stack
  private int[][] adjMatrix;

  private int numberOfVertices;

  private boolean[] visited;

  private int[] disc, low;

  private int num = 0;

  public StronglyConnectedTarjan(int[][] adjMatrix, int numberOfVertices) {
    this.adjMatrix = adjMatrix;
    this.numberOfVertices = numberOfVertices;
  }

  public void scTarjanAlgo() {
    visited = new boolean[numberOfVertices];
    Stack<Integer> stack = new Stack<Integer>();
    disc = new int[numberOfVertices];
    low = new int[numberOfVertices];

    // Initialize disc and low
    for (int i = 0; i < numberOfVertices; i++) {
      disc[i] = -1;
      low[i] = -1;
    }

    // For all vertices find strongly connected if it disc is -1 ( Means we didn't visit node)
    for (int vertex = 0; vertex < numberOfVertices; vertex++) {
      if (disc[vertex] == -1) {
        // Call to find strongly connected component for current node
        findSc(vertex, stack);
      }
    }
  }

  public void findSc(int vertex, Stack<Integer> stack) {
    // Increment disc and low values;
    disc[vertex] = low[vertex] = num++;
    // push current node into stack that marks as back edge
    stack.push(vertex);
    // Mark node as visited
    visited[vertex] = true;

    // Traverse all vertieces
    for (int v = 0; v < numberOfVertices; v++) {
      if (adjMatrix[vertex][v] == 1) {
        if (disc[v] == -1) {
          findSc(v, stack);
          low[vertex] = Math.min(low[v], low[vertex]);
        } else if (visited[v]) {
          // Calculate low
          low[vertex] = Math.min(disc[v], low[vertex]);
        }
      }
    }
    int w = -1;
    if (low[vertex] == disc[vertex]) {
      while (w != vertex) {
        w = (int) stack.pop();
        System.out.println(w + " ");
      }
      System.out.println();
    }
  }
}