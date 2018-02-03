package com.problem.solving.algorithms.trees;

/**
 * Created by VijaySidhu on 2/2/2018.
 */
public class HeightOfTree {

    /**
     * Calculate  height of left and right subtree
     * Pick the maximum from both add 1 and return
     */
    public static int height(Node root) {

        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.getLeft());
        int rightHeight = height(root.getRight());
        int max = Math.max(leftHeight, rightHeight) + 1;
        return max;

    }
}

