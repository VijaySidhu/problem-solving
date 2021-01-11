package com.problem.solving.algorithms.graphs.adjacencymatrix;

import java.util.*;

/*
In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)

Intuition

Conceptually, our method is very straightforward: find both islands, then for one of the islands, keep "growing" it by 1 until we touch the second island.

We can use a depth-first search to find the islands, and a breadth-first search to "grow" one of them. This leads to a verbose but correct solution.

Algorithm

To find both islands, look for a square with a 1 we haven't visited, and dfs to get the component of that region. Do this twice. After, we have two components source and target.

To find the shortest bridge, do a BFS from the nodes source. When we reach any node in target, we will have found the shortest distance.

 */
public class ShortestBridge {
    /*
    Time Complexity: O(A)

Space Complexity: O(A).
     */
    public int shortestBridge(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] colors = getComponents(A);

        Queue<Node> queue = new LinkedList<>();
        Set<Integer> target = new HashSet<>();

        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                if (colors[r][c] == 1) {
                    queue.add(new Node(r, c, 0));
                } else if (colors[r][c] == 2) {
                    target.add(r * C + c);
                }
            }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (target.contains(node.r * C + node.c))
                return node.depth - 1;
            for (int nei : neighbors(A, node.r, node.c)) {
                int nr = nei / C, nc = nei % C;
                if (colors[nr][nc] != 1) {
                    queue.add(new Node(nr, nc, node.depth + 1));
                    colors[nr][nc] = 1;
                }
            }
        }

        throw null;
    }

    public int[][] getComponents(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] colors = new int[R][C];
        int t = 0;

        for (int r0 = 0; r0 < R; ++r0)
            for (int c0 = 0; c0 < C; ++c0)
                if (colors[r0][c0] == 0 && A[r0][c0] == 1) {
                    // Start dfs
                    Stack<Integer> stack = new Stack();
                    stack.push(r0 * C + c0);
                    colors[r0][c0] = ++t;

                    while (!stack.isEmpty()) {
                        int node = stack.pop();
                        int r = node / C, c = node % C;
                        for (int nei : neighbors(A, r, c)) {
                            int nr = nei / C, nc = nei % C;
                            if (A[nr][nc] == 1 && colors[nr][nc] == 0) {
                                colors[nr][nc] = t;
                                stack.push(nr * C + nc);
                            }
                        }
                    }
                }

        return colors;
    }

    public List<Integer> neighbors(int[][] A, int r, int c) {
        int R = A.length, C = A[0].length;
        List<Integer> ans = new ArrayList<>();
        if (0 <= r - 1) ans.add((r - 1) * R + c);
        if (0 <= c - 1) ans.add(r * R + (c - 1));
        if (r + 1 < R) ans.add((r + 1) * R + c);
        if (c + 1 < C) ans.add(r * R + (c + 1));
        return ans;
    }
}

class Node {
    int r, c, depth;

    Node(int r, int c, int d) {
        this.r = r;
        this.c = c;
        depth = d;
    }
}
