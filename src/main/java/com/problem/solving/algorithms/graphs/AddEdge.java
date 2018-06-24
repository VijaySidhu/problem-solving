package com.problem.solving.algorithms.graphs;

import java.util.List;

/**
 * Created by VijaySidhu on 6/23/2018.
 */
public class AddEdge {

    public static void addEdge(Graph graph, int source, int destination) {

        // Add an edge from source to destination
        graph.getAdjArrayList()[source].add(destination);

        // since graph is unidirected add an edge between destination to source
        graph.getAdjArrayList()[destination].add(source);

    }
}
