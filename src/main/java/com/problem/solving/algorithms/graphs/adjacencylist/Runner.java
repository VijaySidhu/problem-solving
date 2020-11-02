package com.problem.solving.algorithms.graphs.adjacencylist;

public class Runner {

  public static void main(String[] args) {
    AdjList adjList = new AdjList();
    adjList.addVertex();
    adjList.addEdge(0, 1);
    adjList.addEdge(0, 2);
    adjList.addEdge(1, 2);
    adjList.addEdge(2, 0);
    adjList.addEdge(2, 3);
    adjList.addEdge(3, 3);

    Operations operations = new Operations();
    operations.setV(4);
    operations.setGraphAdjList(adjList.getAdjListMap());
    operations.breadthFirstSearchTraverse(2);

  }
}
