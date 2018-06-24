package com.problem.solving.algorithms.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by VijaySidhu on 6/23/2018.
 */
public class BreadthFirstTraverse {

    // from given source
    public static void breadthFirst(Graph graph, int source) {

        // boolean array to represent visited vertices
        boolean visited[] = new boolean[graph.getVertices()];
        // create queue for BFS
        Queue<Integer> queue = new LinkedList<Integer>();

        // mark the current node visited
        visited[source] = true;
        queue.add(source);

        while (queue.size() != 0) {
            // dqueue vertex from queue and print it
            source = queue.remove();
            System.out.println(source + " ");
            // get all adjacent vertices for source
            List<Integer> adjVertices = graph.getAdjArrayList()[source];
            for (int vertex : adjVertices) {
                if (visited[vertex] == false) {
                    visited[vertex] = true;
                    queue.add(vertex);
                }
            }

        }


    }
}
