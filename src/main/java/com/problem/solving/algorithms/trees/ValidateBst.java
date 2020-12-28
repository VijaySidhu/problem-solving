package com.problem.solving.algorithms.trees;

import com.problem.solving.algorithms.ProblemSolverUtils;

public class ValidateBst {

    /*
        Write function to validate binary search tree.
        // O(n) time | O(d) space
     */
    public static boolean validateBst(Node node, int minVal, int maxVal) {
        if (node == null) {
            return true;
        }
        if (node.getData() <= minVal || node.getData() >= maxVal) {
            return false;
        }
        if (node.getLeft() != null && !validateBst(node.getLeft(), minVal, node.getData())) {
            return false;
        }
        if (node.getRight() != null && !validateBst(node.getRight(), node.getData(), maxVal)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Node bst = ProblemSolverUtils.createBinarySearchTree();
        System.out.println(validateBst(bst, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
