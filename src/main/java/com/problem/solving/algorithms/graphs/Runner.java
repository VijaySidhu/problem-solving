package com.problem.solving.algorithms.graphs;

/**
 * Created by VijaySidhu on 6/23/2018.
 */
public class Runner {


    public static void main(String[] args) {
        Graph graph = buildGraph();
        printGraph(graph);

        System.out.println("Breadth First Traverse");
        // Breadth First
        BreadthFirstTraverse.breadthFirst(graph, 2);
        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");
        // DFS
        DepthFirst.dfs(graph, 2);
    }

    public static void printGraph(Graph graph) {
        for (int i = 0; i < graph.getVertices(); i++) {
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("head");
            for (Integer p : graph.getAdjArrayList()[i]) {
                System.out.print("-->" + p);
            }
            System.out.println("\n");
        }
    }

    public static Graph buildGraph() {
        int V = 4;
        Graph graph = new Graph(V);
        AddEdge.addEdge(graph, 0, 1);
        AddEdge.addEdge(graph, 0, 2);
        AddEdge.addEdge(graph, 1, 2);
        AddEdge.addEdge(graph, 2, 0);
        AddEdge.addEdge(graph, 2, 3);
        AddEdge.addEdge(graph, 3, 3);
        return graph;
    }
}
