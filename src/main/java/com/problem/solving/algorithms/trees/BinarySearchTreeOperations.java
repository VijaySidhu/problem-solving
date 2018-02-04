package com.problem.solving.algorithms.trees;

/**
 * Created by VijaySidhu on 2/3/2018.
 * The left subtree of a node contains only nodes with keys less than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * The left and right subtree each must also be a binary search tree.
 * There must be no duplicate nodes.
 */
public class BinarySearchTreeOperations {

    // Insert into binary search tree at first position available
    public static Node insertIntoBinarySearchTree(Node root, int data) {

        return null;
    }

    // Seach from binary Search tree
    public static Node searchBinarySearchTree(Node root, int data) {

        if (root == null || root.getData() == data) {
            return root;
        }

        if (root.getData() > data) {
            return searchBinarySearchTree(root.getLeft(), data);
        }
        return searchBinarySearchTree(root.getRight(), data);
    }

    // delete from  binary Search tree
    public static Node deleteFromBinarySearchTree(Node root, int data) {

        return null;
    }
}
