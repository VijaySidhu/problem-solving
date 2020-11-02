package com.problem.solving.algorithms.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by VijaySidhu on 6/23/2018. An array of linked lists is used. Size of the array is equal
 * to the number of vertices. Let the array be array[]. An entry array[i] represents the linked list
 * of vertices adjacent to the ith vertex. The weights of edges can be stored in nodes of linked
 * lists.
 */
public class Graph {

    private int vertices;
    private List<Integer> adjArrayList[];

    public Graph(int vertices) {
        // Total number of vertices
        this.vertices = vertices;
        // Size of array is equal to number of vertices
        adjArrayList = new LinkedList[vertices];

        // Create new list of for each vertex such that adjacent nodes can be stored

        for (int i = 0; i < vertices; i++) {
            adjArrayList[i] = new LinkedList<>();
        }

    }

    public List<Integer>[] getAdjArrayList() {
        return adjArrayList;
    }

    public int getVertices() {
        return vertices;
    }
}
