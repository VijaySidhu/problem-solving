package com.problem.solving.algorithms.trees;

/**
 * Created by VijaySidhu on 2/5/2018.
 */
public class DistanceBetweenGiveNodes {

    /**
     * Find LCA first of given nodes
     * Find Level of both nodes
     * Distance = level1 + level2
     */
    public static int findDistance(Node root, int a, int b) {
        Node lca = LCA.lcaBinaryTree(root, a, b);
        int d1 = levelFinder(lca, a, 0);
        int d2 = levelFinder(lca, b, 0);
        return d1 + d2;
    }

    // Find level
    public static int levelFinder(Node root, int k, int level) {
        if (root == null) {
            return -1;
        }
        if (root.getData() == k) {
            return level;
        }
        int left = levelFinder(root.getLeft(), k, level + 1);
        if (left == -1) {
            return levelFinder(root.getRight(), k, level + 1);
        }
        return left;
    }
}
