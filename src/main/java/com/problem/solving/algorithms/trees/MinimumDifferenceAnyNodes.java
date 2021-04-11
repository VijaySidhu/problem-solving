package com.problem.solving.algorithms.trees;

public class MinimumDifferenceAnyNodes {

    static Integer previous;
    static Integer ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        TreeNode tnL = new TreeNode();
        tnL.data = 2;
        TreeNode tnR = new TreeNode();
        tnR.data = 3;
        tn.data = 1;
        tn.left = tnL;
        tn.right = tnR;


        dfs(tn);

    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (previous != null) {
            ans = Math.min(ans, root.data - previous);

        }
        previous = root.data;

        dfs(root.right);
    }


}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

}
