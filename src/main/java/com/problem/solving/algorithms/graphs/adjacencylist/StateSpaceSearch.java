package com.problem.solving.algorithms.graphs.adjacencylist;

import java.util.Map;
import java.util.HashMap;

import java.util.Set;
import java.util.HashSet;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;

public class StateSpaceSearch {
    public static void main(String args[]) {
        // Just makin' a scanner.
        Scanner scan = new Scanner(System.in);

        // Say we know there are n vertices
        // labeled as integers 0 to n - 1.
        int n = scan.nextInt();

        // And we're going to be passed in
        // m edges, which are two integers
        // per line showing connectivity
        // in an undirected graph. So, the
        // connection basically goes both ways.
        int m = scan.nextInt();

        // We're going to want to store all of
        // our edges in an Adjacency List.
        //
        // Remember, we use a Map of vertices
        // to a List or Set of their connected
        // vertices (basically, edges).
        //
        // Our vertices (nodes) are simply labeled
        // integers, so we have a map of Integer
        // to a List of Integer. We use a List
        // for simplicity's sake.
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();

        // To make some other logic simpler, let's store
        // an empty list for every vertex.
        for (int i = 0; i < n; ++i) {
            // Remember, our vertices are labeled from 0
            // to n - 1, so we can just use ints as keys.
            adjList.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < m; ++i) {
            // Read in the edge (x, y) or (y, x)
            // for each line of input.
            int x = scan.nextInt();
            int y = scan.nextInt();

            // We need to store the relationship
            // in our adjacency list. So, get
            // the reference to the edges of
            // x and y, and add the relationship.
            adjList.get(x).add(y);
            adjList.get(y).add(x); // remove this line to
            // get a directed graph.
        }

        // Okay, now we have all of the edges stored
        // in our map. We can do BFS or DFS now!

        // Let's assume the user tells us both a
        // start and end node, and asks us if there
        // exists a path between them. We can use
        // BFS or DFS to determine connectivity
        // between these vertices.

        // These will range from 0 to n - 1, and
        // match one of the labeled vertices.
        int start = scan.nextInt();
        int end = scan.nextInt();

        // So, start off your search by throwing the
        // start node onto your data structure, and
        // let it search away!

        boolean connected = false; // This is our return value
        // from our function.

        // Let's do BFS first... Which requires a Queue.
        // It'll store all of our nodes.

        // We'll want to know what we visited, so we
        // don't make the same trip twice. We can use
        // a set for this and store what we've seen.
        Set<Integer> visited = new HashSet<Integer>();

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visited.add(start); // Before you add a node,
        // we will say you visited it.

        // Keep going until you visit everything, or run
        // out of nodes to expand (search).
        while (!q.isEmpty()) {
            int nextVertex = q.poll();

            if (nextVertex == end) {
                connected = true; // We found it!
                break;
            }

            for (Integer edge : adjList.get(nextVertex)) {
                // If we haven't visited this node yet,
                // let's search it!
                if (!visited.contains(edge)) {
                    q.add(edge); // 'queue' it up to be searched!
                    visited.add(edge); // remember to say you visited it now.
                }
            }
        }

        // That's basically BFS. Our algorithm threw some
        // stuff onto the visited set, so let's clear it
        // out for the DFS.
        visited.clear();

        // The only difference with BFS vs. DFS is that
        // we use a Stack, instead of a Queue, which
        // means that some of the function calls are different.
        Stack<Integer> s = new Stack<Integer>();
        s.push(start);
        visited.add(start);

        while (!s.isEmpty()) {
            int nextVertex = s.pop();

            if (nextVertex == end) {
                connected = true; // We found it!
                break;
            }

            for (Integer edge : adjList.get(nextVertex)) {
                // If we haven't visited this node yet,
                // let's search it!
                if (!visited.contains(edge)) {
                    s.push(edge); // 'stack' it up to be searched!
                    visited.add(edge); // remember to say you visited it now.
                }
            }
        }

        // As you can see, it's practically the
        // same exact code!

        // Clearing it up one last time...
        visited.clear();

        // Now time to do recursive DFS...
        connected = recursiveDFS(start, end, adjList, visited);
    }

    // We pass in the mapping and visited set so that each
    // recursive call can have the same reference and also
    // update the visited set over time.
    //
    // This looks a lot simpler, but it's dangerous to do
    // the recursive method. It can often stack overflow
    // if you have > 10,000 vertices.
    static boolean recursiveDFS(int node, int end, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        if (node == end) {
            return true;
        }

        for (Integer edge : adjList.get(node)) {
            if (!visited.contains(edge)) {
                // Add the edge before recursing, otherwise
                // future recursive calls won't know that
                // you visited this node, until it backtracks.
                visited.add(edge);

                // Calling the recursive function is
                // essentially the same as adding this
                // item on the stack.
                boolean connected = recursiveDFS(edge, end, adjList, visited);

                // If we found something, let's terminate everything
                // now. Don't wait any longer.. But we should only
                // terminate if we are connected. If we aren't
                // connected, we might be able to find another path.
                if (connected) {
                    return true;
                }
            }
        }

        // If nothing was connected for this call, then
        // go ahead and say nothing was connected.
        return false;
    }
}