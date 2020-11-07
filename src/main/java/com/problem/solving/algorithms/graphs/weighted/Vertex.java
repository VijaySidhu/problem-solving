package com.problem.solving.algorithms.graphs.weighted;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

  private String name;

  private List<Edge> edges;

  private boolean visited;

  private Vertex previosVertex;

  private double minDistance = Double.MAX_VALUE;

  public Vertex(String name) {
    this.name = name;
    this.edges = new ArrayList<>();
  }

  public void addNeighbour(Edge edge) {
    this.edges.add(edge);
  }

  public List<Edge> getEdges() {
    return edges;
  }

  public void setEdges(List<Edge> edges) {
    this.edges = edges;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public Vertex getPreviosVertex() {
    return previosVertex;
  }

  public void setPreviosVertex(Vertex previosVertex) {
    this.previosVertex = previosVertex;
  }

  public double getMinDistance() {
    return minDistance;
  }

  public void setMinDistance(double minDistance) {
    this.minDistance = minDistance;
  }
}
