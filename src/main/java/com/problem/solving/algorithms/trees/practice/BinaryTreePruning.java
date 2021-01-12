package com.problem.solving.algorithms.trees.practice;

/*
We are given the head node root of a binary tree, where additionally every node's
value is either a 0 or a 1.
Return the same tree where every subtree (of the given tree) not containing a 1 has
been removed.

 */
public class BinaryTreePruning {

    /*
    TC O(N)
    SC O(H)
    We'll use a function containsOne(node) that does two things:
    it tells us whether the subtree at this node contains a 1, and it also prunes all
    subtrees not containing 1.
    If for example, node.left does not contain a one, then we should prune it via
    node.left = null.
    Also, the parent needs to be checked. If for example the tree is a single node 0,
    the answer is an empty tree.
     */
    public static TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    public static boolean containsOne(TreeNode node) {
        if (node == null) return false;
        boolean a1 = containsOne(node.left);
        boolean a2 = containsOne(node.right);
        if (!a1) node.left = null;
        if (!a2) node.right = null;
        return node.val == 1 || a1 || a2;
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode left = new TreeNode();
        left.val = 1;
        TreeNode right = new TreeNode();
        right.val = 0;
        root.val = 0;
        root.left = left;
        root.right = right;
        TreeNode prunedTree = pruneTree(root);
        printTreeInOrder(prunedTree);

    }

    static void printTreeInOrder(TreeNode root) {
        if (root != null) {
            printTreeInOrder(root.left);
            System.out.println(root.val);
            printTreeInOrder(root.right);
        }

    }


}
