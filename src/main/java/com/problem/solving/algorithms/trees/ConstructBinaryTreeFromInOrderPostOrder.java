package com.problem.solving.algorithms.trees;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/987878/Java-1ms-faster-than-96
public class ConstructBinaryTreeFromInOrderPostOrder {

    public static BinTreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || postorder.length != inorder.length)
            return null;


        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static BinTreeNode buildTree(int[] post, int start1, int end1, int[] in, int start2, int end2) {
        if (start1 > end1 || start2 > end2)
            return null;
        // Get element from post order that will be root node because is post order root is at the end
        int val = post[end1];
        // off set represents index of root node in inOrder array
        int offset = start2;
        // Build root node
        BinTreeNode cur = new BinTreeNode(val);
        // search index of val in inorder
        for (; offset < end2; offset++) {
            if (in[offset] == val)
                break;
        }
        cur.left = buildTree(post, start1, start1 + offset - start2 - 1, in, start2, offset - 1);
        cur.right = buildTree(post, start1 + offset - start2, end1 - 1, in, offset + 1, end2);
        return cur;
    }

    static class BinTreeNode {
        int data;
        BinTreeNode left;
        BinTreeNode right;

        public BinTreeNode(int data) {
            this.data = data;
        }
    }
}
