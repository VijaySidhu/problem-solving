package com.problem.solving.algorithms.trees;

public class SameTree {

    /*
       Time complexity : O(N), where N is a number of nodes in the tree,
                    since one visits each node exactly once.
                    SC : O(LogN) is best case of completly balance tree and O(N) in worst case
     */
    public static boolean isSameTree(Node nodeOne, Node nodeTwo) {
        if (nodeOne == null && nodeTwo == null) {
            return true;
        }
        if (nodeOne.getData() != nodeTwo.getData()) {
            return false;
        }
        return isSameTree(nodeOne.getRight(), nodeTwo.getRight()) && isSameTree(nodeOne.getLeft(), nodeTwo.getLeft());
    }
}
