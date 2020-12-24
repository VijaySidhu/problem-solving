package com.problem.solving.algorithms.trees;

/**
 * Created by VijaySidhu on 2/5/2018.
 */
public class LCA {

    /*
       The idea is to traverse the tree starting from the root.
        If any of the given keys (n1 and n2) matches with the root, then the root is LCA (assuming that both keys are present).
        If the root doesn’t match with any of the keys, we recur for the left and right subtree.
        The node which has one key present in its left subtree and the other key present in the right subtree
        is the LCA.
        If both keys lie in the left subtree, then the left subtree has LCA also, otherwise, LCA lies in
        the right subtree.
     */
    //Time complexity of the above solution is O(n)
    public static Node lcaBinaryTree(Node root, int value1, int value2) {
        // Base case
        if (root == null) {
            return root;
        }
        // If value1 and value2 matches with root key just return node
        if (root.getData() == value1) {
            return root;
        }
        if (root.getData() == value2) {
            return root;
        }
        // Recurse Left and right subtrees and look for value1 and value2
        Node leftLCA = lcaBinaryTree(root.getLeft(), value1, value2);
        Node rightLCA = lcaBinaryTree(root.getRight(), value1, value2);
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    // Time Complexity is O(h) where h is height of tree. I am not using recursive solution because it takes O(h) extra space
    public static Node lcaBinarySearchTree(Node root, int value1, int value2) {

        while (root != null) {
            if (root.getData() > value1 && root.getData() > value2) {
                root = root.getLeft();
            } else if (root.getData() < value1 && root.getData() < value2) {
                root = root.getRight();
            } else {
                break;
            }

        }
        return root;
    }

    // Print Common nodes on path from root
    // find LCA and print all common ancestors
    public static void printAncestorNodes(Node root, int val1, int val2) {
        Node lca = lcaBinaryTree(root, val1, val2);
        if (lca == null) {
            return;
        }
        printAncestorNodes(root, lca.getData());
    }

    public static boolean printAncestorNodes(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (root.getData() == data) {
            System.out.println(root.getData() + " ");
            return true;
        }
        //recurse right and left subtree for data
        if (printAncestorNodes(root.getLeft(), data) || printAncestorNodes(root.getRight(), data)) {
            System.out.println(root.getData() + "  ");
            return true;
        }
        return false;

    }
}
