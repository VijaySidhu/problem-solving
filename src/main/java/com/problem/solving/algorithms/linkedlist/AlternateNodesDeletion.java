package com.problem.solving.algorithms.linkedlist;

/**
 * Created by VijaySidhu on 1/29/2018.
 */
public class AlternateNodesDeletion {

    public static Node recursiveDelete(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        node.next = node.next.next;
        recursiveDelete(node.next);
        return node;
    }
}
