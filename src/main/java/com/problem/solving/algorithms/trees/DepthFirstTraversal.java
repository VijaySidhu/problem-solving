package com.problem.solving.algorithms.trees;

/**
 * Created by VijaySidhu on 1/30/2018.
 */
public class DepthFirstTraversal {

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.println(root.getData());
            inOrder(root.getRight());
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getData());
        }
    }
}
