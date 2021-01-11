package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
TOPOLOGICAL Sort Algo
Time Complexity O(E+V)
SC O(E+V)
 */
public class CourseSchedule {

    public static Map<Integer, Integer> inDegree = new HashMap<>();

    public static void main(String[] args) {
        int[][] prequesites = new int[][]{
                {1, 0},
        };
        Graph g = new Graph(2, prequesites);
        Map<Integer, List<Integer>> graph = g.graph;

        // Count In degree
        countIndegrees(graph);
        // Start from course that has zero in degree lets call current node and remove outgoing edges. In this case 0


        // Update In degree of neighbors of current node
        // If any vertex has 0 in degree remove the vertex
    }

    private static void countIndegrees(Map<Integer, List<Integer>> graph) {
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int u = entry.getKey();
            List<Integer> neis = entry.getValue();
            for (int i : neis) {
                int count = inDegree.get(u);
                count = count + 1;
                inDegree.put(u, count);
            }
        }
    }

    private static class Graph {

        static Map<Integer, List<Integer>> graph;
        int vertices;

        public Graph(int vertices, int[][] preqs) {
            graph = new HashMap<>();
            this.vertices = vertices;
            for (int i = 0; i < vertices; i++) {
                graph.put(i, new ArrayList<>());
                inDegree.put(i, 0);
            }
            addEdges(preqs);

        }

        public static void addEdges(int[][] edges) {
            for (int[] ed : edges) {
                addEdge(ed[0], ed[1]);
                //   addEdge(ed[1], ed[0]);
            }
        }

        public static void addEdge(int u, int v) {
            if (graph.containsKey(u)) {
                List<Integer> adjacents = graph.get(u);
                if (adjacents != null) {
                    adjacents.add(v);
                    graph.put(u, adjacents);
                }
               /* // Set Indegree
                if (!inDegree.containsKey(v)) {
                    inDegree.put(v, 0);
                }else {
                    int count = inDegree.get(v);
                    count = count+1;
                    inDegree.put(v,count);
                }*/
            } else {
                List<Integer> neighbors = new ArrayList<>();
                neighbors.add(v);
                graph.put(u, neighbors);
            }
        }

    }


}
