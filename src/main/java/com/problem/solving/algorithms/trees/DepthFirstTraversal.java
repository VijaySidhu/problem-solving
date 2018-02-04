package com.problem.solving.algorithms.trees;

import java.util.List;

/**
 * Created by VijaySidhu on 1/30/2018.
 */
public class DepthFirstTraversal {

    // Pre Order of BinaryTree
    public static void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    // In Order of BinaryTree
    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.println(root.getData());
            inOrder(root.getRight());
        }
    }

    // Post Order of BinaryTree
    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    /**
     * Ternary Tree
     */
    public static List<Integer> preOrderTri(NodeTri root, List<Integer> values) {
        if (root != null) {
            values.add(root.getData());
            preOrderTri(root.getLeft(), values);
            preOrderTri(root.getMiddle(), values);
            preOrderTri(root.getRight(), values);
        }
        return values;
    }
}
