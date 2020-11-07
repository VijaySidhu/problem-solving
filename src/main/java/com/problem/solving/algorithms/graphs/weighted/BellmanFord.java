package com.problem.solving.algorithms.graphs.weighted;

import java.util.List;

public class BellmanFord {

  /*
  Bellman-Ford's Algorithm
  Slower than Dijkstra's but more robust; since this can handle negative weights
  Run time O(V*E)
  PsuedoCode ::
      Initialization Phase:
        Set the distance of source to 0
        other vertices distances to INF
          for at most |V-1| times, repeat
            for all e = edges(u,v) (read as from (u) to (v))
            update(e)
            update(u, v):
        distance(v) = min{distance(v), distance(u) + edge-weight(u,v)}
   */
  private List<Vertex> vertices;

  private List<Edge> edges;

  public BellmanFord(List<Vertex> vertices,
      List<Edge> edges) {
    this.vertices = vertices;
    this.edges = edges;
  }

  public void shortestPath(Vertex sourceVertex, Vertex targetVertex) {
    sourceVertex.setMinDistance(0);

    // v-1 iteration
    for (int i = 0; i < this.vertices.size() - 1; i++) {
      for (Edge edge : this.edges) {
        if (edge.getStartVertex().getMinDistance() == Double.MAX_VALUE) {
          continue;
        }
        Vertex v = edge.getStartVertex();
        Vertex u = edge.getTargetVertex();

        double newDistance = v.getMinDistance() + edge.getWeight();
        if (newDistance < u.getMinDistance()) {
          u.setMinDistance(newDistance);
          u.setPreviosVertex(v);
        }
      }
    }

    // Check for negative cycle
    for (Edge edge : this.edges) {
      if (edge.getStartVertex().getMinDistance() != Double.MAX_VALUE) {
        if (hasCycle(edge)) {
          System.out.println("There is negative cycle");
        }
      }
    }
    printDistance();
  }

  private boolean hasCycle(Edge edge) {
    return (edge.getStartVertex().getMinDistance() + edge.getWeight()) < edge.getTargetVertex()
        .getMinDistance();
  }

  public void printDistance() {
    for (Vertex v : vertices) {
      System.out.println(v.getMinDistance());
    }
  }
}
