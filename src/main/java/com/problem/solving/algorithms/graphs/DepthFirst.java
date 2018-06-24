package com.problem.solving.algorithms.graphs;

import java.util.List;

/**
 * Created by VijaySidhu on 6/23/2018.
 */
public class DepthFirst {


    public static void dfs(Graph graph, int vertices) {
        // take boolean array and mark all vertices unvisited
        boolean visited[] = new boolean[graph.getVertices()];

        dfsUtil(vertices, visited, graph);

    }

    private static void dfsUtil(int v, boolean visited[], Graph graph) {
        visited[v] = true;
        System.out.print(v + " ");
        List<Integer> adjList = graph.getAdjArrayList()[v];
        for (int vertex : adjList) {
            if (visited[vertex] == false) {
                dfsUtil(vertex, visited, graph);
            }
        }
    }
}
