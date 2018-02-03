package com.problem.solving.algorithms.trees;

/**
 * Created by VijaySidhu on 2/2/2018.
 */
public class MirrorTree {

    /**
     * Create mirror tree of given tree
     */
    public static Node mirrorCoversion(Node root) {
        if (root == null) {
            return root;
        }
        Node left = mirrorCoversion(root.getLeft());
        Node right = mirrorCoversion(root.getRight());
        root.setLeft(right);
        root.setRight(left);
        return root;
    }

}
