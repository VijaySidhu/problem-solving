package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.*;

public class CloneGraph {

    public static void main(String[] args) {

    }

    /*
        TC O(M+N)
        SC O(N)
     */
    public Node clone(Node node) {
        // BFS with queue
        if (node == null) {
            return node;
        }
        // Create Hashmap to save visited nodes. This helps avoids cycle
        Map<Node, Node> visited = new HashMap<>();

        //Create queue
        Queue<Node> queue = new LinkedList<>();
        //Put the first node in queue
        queue.add(node);

        // Iterate over queue until it's not empty
        while (!queue.isEmpty()) {
            // Remove node from queue and iterate over all it's neighbours
            Node current = queue.remove();

            if (current.neighbors != null) {

                for (Node neighbor : current.neighbors) {

                    // If this node is not visited add it in the queue
                    if (!visited.containsKey(neighbor)) {
                        // Clone node and put it to visited
                        visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                        queue.add(neighbor);
                    }
                    // Add the clone of the neighbor to the neighbors of the clone node "n".
                    visited.get(neighbor).neighbors.add(visited.get(neighbor));
                }


            }
        }
        return visited.get(node);
    }


    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }
}