package com.problem.solving.algorithms.graphs.adjacencylist;

public class Runner {

  public static void main(String[] args) {
    AdjList adjList = new AdjList();
    adjList.addEdge(0, 1);
    adjList.addEdge(0, 2);
    adjList.addEdge(1, 2);
    adjList.addEdge(2, 0);
    adjList.addEdge(2, 3);
    adjList.addEdge(3, 3);

    Operations operations = new Operations();
    operations.setV(4);
    operations.setGraphAdjList(adjList.getAdjListMap());
    // BFS with queue
    operations.breadthFirstSearchTraverse(2);
    // DFS with recursion
    // Time complexity: O(V + E),
    // Space Complexity: O(V).
    operations.depthFirstTraverse(2, null);

    /*
    Algorithm:
Create the graph using the given number of edges and vertices.
Create a recursive function that initializes the current index or
vertex, visited, and recursion stack.
Mark the current node as visited and also mark the index in
recursion stack.
Find all the vertices which are not visited and are adjacent
to the current node. Recursively call the function for those
vertices, If the recursive function returns true, return true.
If the adjacent vertices are already marked in the recursion
stack then return true.
Create a wrapper class, that calls the recursive function
for all the vertices and if any function returns true return true.
Else if for all vertices the function returns false return false.
     */
    DetectCycle detectCycle = new DetectCycle();
    detectCycle.setAdjListMap(adjList.getAdjListMap());
    detectCycle.setV(4);
    boolean isCycle = detectCycle.isCyclic(1, null, null);
    System.out.println(isCycle ? "Graph has cycle " : "No cycle found");

    PathFinder pathFinder = new PathFinder();
    pathFinder.setAdjListMap(adjList.getAdjListMap());
    pathFinder.setV(4);
    // Time Complexity: O(V+E)
    // Space Compelxity: O(V).
    System.out.println(pathFinder.isReachable(3, 1) ? "Connected" : "No path");
    System.out.println(pathFinder.isReachable(1, 3) ? "Connected" : "No path");

    // Topological sort
    AdjList directedGraph = new AdjList();
    directedGraph.addEdge(5, 2);
    directedGraph.addEdge(5, 0);
    directedGraph.addEdge(4, 0);
    directedGraph.addEdge(4, 1);
    directedGraph.addEdge(2, 3);
    directedGraph.addEdge(3, 1);
    TopologicalSorting topologicalSorting = new TopologicalSorting();
    topologicalSorting.setAdjMap(directedGraph.getAdjListMap());
    topologicalSorting.setV(6);
    // Sort and print 5 4 2 3 1 0
    topologicalSorting.topologicalSortedGraph();
    // Strongly connected component
    AdjList g = new AdjList();
    g.addEdge(1, 0);
    g.addEdge(0, 2);
    g.addEdge(2, 1);
    g.addEdge(0, 3);
    g.addEdge(3, 4);
    StronglyConnectedComponent scc = new StronglyConnectedComponent();
    scc.setStronglyConnectedG(g.getAdjListMap());
    scc.setVertices(5);
    System.out.println("SCC");
    // Kusaraju's not best use tarjan
    scc.printStronglyConnectedComponents();
    StronglyConnected sc = new StronglyConnected();
    // Kusaraju's not best use tarjan
    sc.getStronglyConnected(g.getAdjListMap());
    // Tarjan Algo to find strongly connected components
    System.out.println("Tarjan Algo to find strongly connected components");
    System.out.println();
    int[][] graphAdjMatrix = new int[][]{
        {0, 1, 0, 1},
        {0, 0, 1, 0},
        {1, 0, 0, 1},
        {0, 0, 0, 0}
    };
    StronglyConnectedTarjan sct = new StronglyConnectedTarjan(graphAdjMatrix, 4);
    sct.scTarjanAlgo();

    // Shortest path for unweighted graph
    System.out.println();
    System.out.println("Shortest path for unweighted graph");
    AdjList unweightedGraph = new AdjList();
    unweightedGraph.addEdge(0, 1);
    unweightedGraph.addEdge(1, 2);
    unweightedGraph.addEdge(2, 3);
    unweightedGraph.addEdge(3, 4);

    ShortestPathUnWeightedGraph sug = new ShortestPathUnWeightedGraph(8, 0,
        unweightedGraph.getAdjListMap());
    sug.shortestPathUnweightedGraph();

    System.out.println();
    System.out.println("Shortest path with Dijkstra");
    Dijkstra dijkstra = new Dijkstra();
    dijkstra.shortestPath();

  }
}
