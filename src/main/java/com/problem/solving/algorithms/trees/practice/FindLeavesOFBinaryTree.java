package com.problem.solving.algorithms.trees.practice;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOFBinaryTree {
    /*

    Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

     */
    List<List<Integer>> solution;

    public List<List<Integer>> findLeaves(TreeNode root) {
        solution = new ArrayList<>();
        if (root == null) {
            return null;
        }

        // Calculate height of tree
        int currHeight = getHeight(root);

        if (solution.size() == currHeight) {
            solution = new ArrayList<>();
        }
        this.solution.get(currHeight).add(root.val);

        return solution;
    }

    private static int getHeight(TreeNode root) {
        int leftHeight = root.left != null ? getHeight(root.left) : 0;
        int rightHeight = root.right != null ? getHeight(root.right) : 0;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String[] args) {
        FindLeavesOFBinaryTree f = new FindLeavesOFBinaryTree();
        TreeNode root = f.new TreeNode();
        TreeNode left = f.new TreeNode();
        left.val = 1;
        TreeNode right = f.new TreeNode();
        right.val = 2;
        root.val = 0;
        root.left = left;
        root.right = right;

        f.findLeaves(root);
    }

}
