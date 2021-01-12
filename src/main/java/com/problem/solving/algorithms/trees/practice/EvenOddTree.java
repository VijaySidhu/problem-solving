package com.problem.solving.algorithms.trees.practice;

import java.util.LinkedList;
import java.util.Queue;

/*
   Given the root of a binary tree, return true if
   the binary tree is Even-Odd, otherwise return false.
 */
public class EvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return true;
        q.add(root);
        int prev = 0;
        boolean even = false;
        while (!q.isEmpty()) {

            int s = q.size();
            if (even) {
                prev = Integer.MAX_VALUE;
            } else {
                prev = Integer.MIN_VALUE;
            }
            for (int i = 0; i < s; i++) {
                TreeNode temp = q.remove();
                if (even && (temp.val >= prev || temp.val % 2 != 0)) {
                    return false;
                }
                if (!even && (temp.val <= prev || temp.val % 2 == 0)) {
                    return false;
                }
                prev = temp.val;
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            even = !even;
        }

        return true;
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
