package com.problem.solving.algorithms.trees;

public class SymmetricTree {


    /*
        TC O(N) we traverse entire input tree once
        SC O(N) number of recursive call bound by height of tree
     */
    public boolean isMirror(Node t1, Node t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.getData() == t2.getData())
                && isMirror(t1.getRight(), t2.getLeft())
                && isMirror(t1.getLeft(), t2.getRight());
    }

    public boolean isSymmetric(Node root) {
        return isMirror(root, root);
    }

}
