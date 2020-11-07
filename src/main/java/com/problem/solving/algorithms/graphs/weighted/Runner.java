package com.problem.solving.algorithms.graphs.weighted;

import java.util.Arrays;
import java.util.List;

public class Runner {

  public static void main(String[] args) {
    Vertex v1 = new Vertex("A");
    Vertex v2 = new Vertex("B");
    Vertex v3 = new Vertex("C");

    v1.addNeighbour(new Edge(1, v1, v2));
    v1.addNeighbour(new Edge(10, v1, v2));

    v2.addNeighbour(new Edge(1, v2, v3));

    // Bellman ford
    System.out.println("Bellman ford");
    Vertex vertexA = new Vertex("A");
    Vertex vertexB = new Vertex("B");
    Vertex vertexC = new Vertex("C");
    Vertex vertexD = new Vertex("D");
    Vertex vertexE = new Vertex("E");
    Edge edgeA = new Edge(1, vertexB, vertexC);
    Edge edgeB = new Edge(1, vertexA, vertexC);
    Edge edgeC = new Edge(1, vertexA, vertexB);
    vertexA.addNeighbour(edgeB);
    vertexA.addNeighbour(edgeC);
    vertexB.addNeighbour(edgeA);
    vertexB.addNeighbour(edgeC);
    vertexC.addNeighbour(edgeA);
    vertexC.addNeighbour(edgeB);

    List<Vertex> vertices = Arrays.asList(vertexA, vertexB, vertexC);
    List<Edge> edges = Arrays.asList(edgeA, edgeB, edgeC);

    BellmanFord bmf = new BellmanFord(vertices, edges);
    bmf.shortestPath(vertexA, vertexC);
    bmf.printDistance();
  }
}
