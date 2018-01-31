package com.problem.solving.algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by VijaySidhu on 1/30/2018.
 * We will use Queue for BST. Time Complexity will be O(n)
 */
public class BreadFirstTraversal {

    public static void bst(Node node) {
        if (null == node) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node queueNode = queue.remove();
            System.out.print(queueNode.getData() + " ");
            if (queueNode.getLeft() != null) {
                queue.add(queueNode.getLeft());

            }
            if (queueNode.getRight() != null) {
                queue.add(queueNode.getRight());
            }

        }

    }
}
