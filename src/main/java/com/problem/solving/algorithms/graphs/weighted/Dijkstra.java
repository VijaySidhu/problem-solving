package com.problem.solving.algorithms.graphs.weighted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Used to find shortest path with weighted graph from source node to all other nodes
If Source node is not directly connected to any other node mark with infinity.
For next node from current node always select node with minimum distance with direct connection
For next value take minimum from Math.min((previousValue + weightEdge),nextNodeValue)
Do not consider node in path if it is already relaxed or visited
Sort data from distance of vertex to source
Time complexity O(E+V)
Space complexity O(ElogV)
 */
public class Dijkstra {

  public void computePath(Vertex sourceVertex) {
    sourceVertex.setMinDistance(0);
    PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(sourceVertex);

    while (!priorityQueue.isEmpty()) {
      Vertex vertex = priorityQueue.poll();

      for (Edge edge : vertex.getEdges()) {
        Vertex v = edge.getTargetVertex();
        //                Vertex u = edge.getStartVertex();
        double weight = edge.getWeight();
        double minDistance = vertex.getMinDistance() + weight;

        if (minDistance < v.getMinDistance()) {
          priorityQueue.remove(vertex);
          v.setPreviosVertex(vertex);
          v.setMinDistance(minDistance);
          priorityQueue.add(v);
        }
      }
    }
  }

  public List<Vertex> getShortestPathTo(Vertex targetVerte) {
    List<Vertex> path = new ArrayList<>();

    for (Vertex vertex = targetVerte; vertex != null; vertex = vertex.getPreviosVertex()) {
      path.add(vertex);
    }

    Collections.reverse(path);
    return path;
  }
}
