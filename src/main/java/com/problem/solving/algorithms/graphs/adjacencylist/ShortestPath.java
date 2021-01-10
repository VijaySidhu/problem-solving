package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.*;

/*
        Dijkstra Time complexity is O(E logV)
        Node B : A –> B (total distance = 10)
        Node C : A –> C (total distance = 15)
        Node D : A –> B –> D (total distance = 22)
        Node E : A –> B –> D –> E (total distance = 24)
        Node F : A –> B –> D –> F (total distance = 23

 */
public class ShortestPath {

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {

        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, edgeWeigh, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static void CalculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static class Graph {

        private Set<Node> nodes = new HashSet<>();

        public void addNode(Node nodeA) {
            nodes.add(nodeA);
        }

        public Set<Node> getNodes() {
            return nodes;
        }

        public void setNodes(Set<Node> nodes) {
            this.nodes = nodes;
        }
    }

    private static class Node {

        private String name;

        private LinkedList<Node> shortestPath = new LinkedList<>();

        private Integer distance = Integer.MAX_VALUE;

        private Map<Node, Integer> adjacentNodes = new HashMap<>();

        public Node(String name) {
            this.name = name;
        }

        public void addDestination(Node destination, int distance) {
            adjacentNodes.put(destination, distance);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map<Node, Integer> getAdjacentNodes() {
            return adjacentNodes;
        }

        public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
            this.adjacentNodes = adjacentNodes;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }

        public List<Node> getShortestPath() {
            return shortestPath;
        }

        public void setShortestPath(LinkedList<Node> shortestPath) {
            this.shortestPath = shortestPath;
        }

    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("c");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        // Set Adjacent Nodes of A
        Map<Node, Integer> adjacentNodesOfA = new HashMap<>();
        adjacentNodesOfA.put(nodeB, 10);
        adjacentNodesOfA.put(nodeC, 15);
        nodeA.setAdjacentNodes(adjacentNodesOfA);

        // Set Adjacent Nodes of B
        Map<Node, Integer> adjacentNodesOfB = new HashMap<>();
        adjacentNodesOfB.put(nodeD, 12);
        adjacentNodesOfB.put(nodeF, 15);
        nodeB.setAdjacentNodes(adjacentNodesOfB);

        // Set Adjacent Nodes of C
        Map<Node, Integer> adjacentNodesOfC = new HashMap<>();
        adjacentNodesOfC.put(nodeE, 10);
        nodeC.setAdjacentNodes(adjacentNodesOfC);

        // Set Adjacent Nodes of D
        Map<Node, Integer> adjacentNodesOfD = new HashMap<>();
        adjacentNodesOfD.put(nodeE, 2);
        adjacentNodesOfD.put(nodeF, 1);
        nodeD.setAdjacentNodes(adjacentNodesOfD);

        // Set Adjacent Nodes of F
        Map<Node, Integer> adjacentNodesOfF = new HashMap<>();
        adjacentNodesOfF.put(nodeE, 5);
        nodeF.setAdjacentNodes(adjacentNodesOfF);


        Set<Node> nodes = new HashSet<>();
        nodes.add(nodeA);
        nodes.add(nodeB);
        nodes.add(nodeC);
        nodes.add(nodeD);
        nodes.add(nodeE);
        nodes.add(nodeF);
        graph.setNodes(nodes);
        Graph g = calculateShortestPathFromSource(graph, nodeA);
        System.out.println(g);
    }
}
