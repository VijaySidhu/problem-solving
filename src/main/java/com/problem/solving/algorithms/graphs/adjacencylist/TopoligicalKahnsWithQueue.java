package com.problem.solving.algorithms.graphs.adjacencylist;

/*
Approach
i.  Compute in-degree (Incoming edges) for each vertex present in DAG.
    initialize count of visited node to 0
ii. Pick all vertices with in-degree ZERO and add them in Queue (EnQueue)
iii.Remove vertex from Queue (Dqueue) and then
    1. Increment count of visited node by 1.
    2. Decrease in-degree by 1 for all its neighboring nodes.
    3. If in-degree of neighboring nodes is reduced to 0, then add it to Queue
 iv. Repeat step 3 until queue is empty.
 v. If count of visited nodes is not equal to the number of nodes in graph
    then the topological sort is not possible for given graph.

How to calculate in-degree ?
Take an in-degree array which will keep track of
Traverse the array of edges and simply increase the counter of the destination node by 1.
for each node in Nodes
    indegree[node] = 0;
for each edge(src, dest) in Edges
    indegree[dest]++
Time Complexity: O(V+E).

    The outer for loop will be executed V number of times and the inner for loop will be executed E number of times.
    Auxillary Space: O(V).
    The queue needs to store all the vertices of the graph. So the space required is O(V)
 */
public class TopoligicalKahnsWithQueue {

}
