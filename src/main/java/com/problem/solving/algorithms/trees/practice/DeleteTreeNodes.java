package com.problem.solving.algorithms.trees.practice;

import java.util.LinkedList;
import java.util.Queue;

/*
A tree rooted at node 0 is given as follows:

The number of nodes is nodes;
The value of the i-th node is value[i];
The parent of the i-th node is parent[i].
Remove every subtree whose sum of values of nodes is zero.

After doing so, return the number of nodes remaining in the tree.
 */
public class DeleteTreeNodes {

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        int[] d = new int[nodes]; // degree array
        int[] s = new int[nodes]; // size array
        for (int i = 1; i < nodes; ++i) { // init
            ++d[parent[i]];
            s[i] = 1;
        }
        s[0] = 1;

        int cnt = 0; // delted nodes number
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nodes; ++i)  // added all the leaves into que
            if (d[i] == 0)
                q.offer(i);

        while (!q.isEmpty()) {
            int i = q.poll();
            if (i == 0) {  // if it is root, break
                if (value[0] == 0)
                    cnt += s[0];
                break;
            }
            if (value[i] == 0) // delete node
                cnt += s[i];
            else
                s[parent[i]] += s[i];
            value[parent[i]] += value[i];
            --d[parent[i]];
            if (d[parent[i]] == 0)
                q.offer(parent[i]);

        }

        return nodes - cnt; // the number of nodes remaining
    }
}
