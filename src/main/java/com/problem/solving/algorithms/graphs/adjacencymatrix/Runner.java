package com.problem.solving.algorithms.graphs.adjacencymatrix;

public class Runner {

  public static void main(String[] args) {
    AdjacencyMatrixRepresentation adjacencyMatrixRepresentation = new AdjacencyMatrixRepresentation(
        4);
    adjacencyMatrixRepresentation.addEdge(0, 1);
    adjacencyMatrixRepresentation.addEdge(0, 3);
    adjacencyMatrixRepresentation.addEdge(1, 0);
    adjacencyMatrixRepresentation.addEdge(1, 2);
    adjacencyMatrixRepresentation.addEdge(2, 1);
    adjacencyMatrixRepresentation.addEdge(2, 3);
    adjacencyMatrixRepresentation.addEdge(3, 0);
    adjacencyMatrixRepresentation.addEdge(3, 2);
    Bipatrite bipatrite = new Bipatrite();
    bipatrite.setG(adjacencyMatrixRepresentation.getGraph());
    bipatrite.setV(adjacencyMatrixRepresentation.getNumVertices());
    System.out.println(bipatrite.isBipartite(0) ? "Bipartite" : "Not bipartite");
  }

}
