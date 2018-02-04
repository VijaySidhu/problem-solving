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
    // Complexity O(logn) Worst Case =    * O(n) Space O(n)

    public static Node insertIntoBinarySearchTree(Node root, int data) {

      /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(data, null, null);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (data < root.getData())
            root.setLeft(insertIntoBinarySearchTree(root.getLeft(), data));
        else if (data > root.getData())
            root.setRight(insertIntoBinarySearchTree(root.getRight(), data));

        /* return the (unchanged) node pointer */
        return root;
    }

    // Seach from binary Search tree O(log n) Worst Case O(n) Space O(n)
    public static Node searchBinarySearchTree(Node root, int data) {

        if (root == null || root.getData() == data) {
            return root;
        }
        if (root.getData() > data) {
            return searchBinarySearchTree(root.getLeft(), data);
        }
        return searchBinarySearchTree(root.getRight(), data);
    }

    /**
     * 1. If Node to be deleted is leaf node just remove
     * 2. If Node to be deleted has only one child : copy the child to the node and delete the child
     * 3. If Node to be deleted has two children: Find inorder successor of the node. Copy contents of the inorder
     * successor to the node and delete the inorder successor.
     */
    public static Node deleteFromBinarySearchTree(Node root, int data) {

        return null;
    }
}
