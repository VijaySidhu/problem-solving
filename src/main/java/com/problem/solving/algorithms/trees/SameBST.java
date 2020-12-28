package com.problem.solving.algorithms.trees;

/*
 Write function that takes two arrays of integers and determine whether these arrays represent same BST
    .You are not allowed to construct bst
 */
public class SameBST {

    public static void main(String[] args) {
        int[] arrayOne = new int[]{10, 15, 8, 12, 94, 81, 5, 2, 11};
        int[] arrayTwo = new int[]{10, 8, 5, 15, 2, 12, 11, 94, 81};
        System.out.println(areSameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public static boolean areSameBsts(int[] arrayOne, int[] arrayTwo, int rootIdxOne, int rootIdxTwo, int minVal, int maxVal) {
        if (rootIdxOne == -1 || rootIdxTwo == -1) {
            return rootIdxOne == rootIdxTwo;
        }
        if (arrayOne[rootIdxOne] != arrayTwo[rootIdxTwo]) {
            return false;
        }

        int leftRootIdxOne = getIdxOfFirstSmaller(arrayOne, rootIdxOne, minVal);
        int leftRootIdxTwo = getIdxOfFirstSmaller(arrayTwo, rootIdxTwo, minVal);
        int rightRootIdxOne = getIdxOfFirstBiggerOrEqual(arrayOne, rootIdxOne, maxVal);
        int rightRootIdxTwo = getIdxOfFirstBiggerOrEqual(arrayTwo, rootIdxTwo, maxVal);
        int currentValue = arrayOne[rootIdxOne];
        boolean leftAreSame =
                areSameBsts(arrayOne, arrayTwo, leftRootIdxOne, leftRootIdxTwo, minVal, currentValue);
        boolean rightAreSame =
                areSameBsts(arrayOne, arrayTwo, rightRootIdxOne, rightRootIdxTwo, currentValue, maxVal);
        return leftAreSame && rightAreSame;
    }

    public static int getIdxOfFirstSmaller(int[] array, int startingIdx, int minVal) {
        // Find the index of the first smaller value after the startingIdx.
        // Make sure that this value is greater than or equal to the minVal,
        // which is the value of the previous parent node in the BST. If it
        for (int i = startingIdx + 1; i < array.length; i++) {
            if (array[i] < array[startingIdx]
                    && array[i] >= minVal) return i;
        }
        return -1;
    }

    public static int getIdxOfFirstBiggerOrEqual(int[] array, int startingIdx, int maxVal) {
        // Find the index of the first bigger/equal value after the startingIdx.
        // Make sure that this value is smaller than maxVal, which is the value
        // of the previous parent node in the BST. If it isn't, then that value
        // is located in the right subtree of the previous parent node.
        for (int i = startingIdx + 1; i < array.length; i++) {
            if (array[i] >= array[startingIdx]
                    && array[i] < maxVal) return i;
        }
        return -1;
    }

}
