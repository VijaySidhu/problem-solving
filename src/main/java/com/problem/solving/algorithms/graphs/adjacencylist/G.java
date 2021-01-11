package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class G {

    Map<Integer, List<Integer>> graph;
    int V;

    public G(int v) {
        graph = new HashMap<>();
        this.V = v;
    }

    public void addEdge(int u, int v) {
        if (graph.containsKey(u)) {
            List<Integer> neighbors = graph.get(u);
            if (neighbors == null) {
                neighbors = new ArrayList<>();
                neighbors.add(v);
                graph.put(u, neighbors);
            } else {
                graph.get(u).add(v);
            }
        } else {
            List<Integer> neighbors = new ArrayList<>();
            neighbors.add(v);
            graph.put(u, neighbors);
        }

    }


}
