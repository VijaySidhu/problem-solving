package com.problem.solving.algorithms.graphs.weighted;

import java.util.Arrays;
import java.util.List;

public class Runner {

  public static void main(String[] args) {
   /* Vertex v1 = new Vertex("A");
    Vertex v2 = new Vertex("B");
    Vertex v3 = new Vertex("C");

    v1.addNeighbour(new Edge(1, v1, v2));
    v1.addNeighbour(new Edge(1, v1, v3));
    v2.addNeighbour(new Edge(1, v2, v3));*/

    // Bellman ford
    System.out.println("Bellman ford");
    Vertex vertexA = new Vertex("A");
    Vertex vertexB = new Vertex("B");
    Vertex vertexC = new Vertex("C");
    Vertex vertexD = new Vertex("D");
    Vertex vertexE = new Vertex("E");
    Edge edgeAB = new Edge(-1, vertexA, vertexB);
    Edge edgeAC = new Edge(4, vertexA, vertexC);
    Edge edgeBC = new Edge(3, vertexB, vertexC);
    Edge edgeBD = new Edge(2, vertexB, vertexD);
    Edge edgeBE = new Edge(2, vertexB, vertexE);
    Edge edgeDC = new Edge(5, vertexD, vertexC);
    Edge edgeDB = new Edge(2, vertexD, vertexB);
    Edge edgeED = new Edge(-3, vertexE, vertexD);
   /* vertexA.addNeighbour(edgeB);
    vertexA.addNeighbour(edgeC);
    vertexB.addNeighbour(edgeA);
    vertexB.addNeighbour(edgeC);
    vertexC.addNeighbour(edgeA);
    vertexC.addNeighbour(edgeB);*/
    List<Vertex> vertices = Arrays.asList(vertexA, vertexB, vertexC, vertexD, vertexE);
    List<Edge> edges = Arrays
        .asList(edgeAB, edgeAC, edgeBC, edgeBD, edgeBE, edgeDC, edgeBD, edgeDB, edgeED);

    BellmanFord bmf = new BellmanFord(vertices, edges);
    bmf.shortestPath(vertexA, vertexC);
    bmf.printDistance();
  }
}
