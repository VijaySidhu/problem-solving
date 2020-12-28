package com.problem.solving.algorithms.trees;


public class MinHeightBSTFromArray {


    public static void main(String[] args) {

        int[] sortedArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        BST bst = constructMinHeightBST(sortedArray, 0, sortedArray.length - 1);


    }

    /*
    Write a function that takes in a non-empty sorted array of distinct integers,
    constructs a BST from the integers, and returns the root of the BST.
    The function should minimize the height of the BST*/

    public static BST constructMinHeightBST(int[] sortedArray, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            return null;
        }
        // Calculate Mid
        int midIndex = (startIndex + endIndex) / 2;
        // Build root node from middle element
        BST bst = new BST(sortedArray[midIndex]);
        // Recurse and build left nodes
        bst.left = constructMinHeightBST(sortedArray, startIndex, midIndex - 1);
        // Recurse and build right nodes
        bst.right = constructMinHeightBST(sortedArray, midIndex + 1, endIndex);
        return bst;
    }

    static class BST {
        int value;
        BST left;
        BST right;

        public BST(int value) {
            this.value = value;
        }
    }

}
