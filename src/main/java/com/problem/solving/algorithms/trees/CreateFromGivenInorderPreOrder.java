package com.problem.solving.algorithms.trees;

/**
 * Created by VijaySidhu on 1/31/2018.
 */
public class CreateFromGivenInorderPreOrder {


    static int preIndex = 0;
    static Node root;

    /**
     * Pick an element from PreOrder and increment index
     * Create new Node with data as picked element
     * Search picked element's index(InIndex) in Inorder
     * Recursive call method for element just before InIndex and make it as left subtree node
     * Recursive call method for element just after InIndex and make it as right subtree node
     * return first node created
     */


    public static Node buildTree(int inOrder[], int preOrder[], int start, int end) {
        if (start > end)
            return null;
        // Pick an element from Pre Order and create root node
        Node treeNode = null;
        treeNode = new Node(preOrder[preIndex++], null, null);
        // If this node has no children
        if (start == end) {
            return treeNode;
        }
        // Find index of this node in given inOrder Travesal
        int inIndex = search(inOrder, start, end, treeNode.getData());
        // Use this index and construct left and right subtrees
        treeNode.setLeft(buildTree(inOrder, preOrder, start, inIndex - 1));
        treeNode.setRight(buildTree(inOrder, preOrder, inIndex + 1, end));
        return treeNode;
    }

    // Method to find index of given value in an array
    public static int search(int arr[], int start, int end, int value) {
        int i;

        for (i = start; i <= end; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return i;
    }
}
