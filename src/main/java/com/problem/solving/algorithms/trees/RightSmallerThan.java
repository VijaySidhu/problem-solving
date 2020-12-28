package com.problem.solving.algorithms.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightSmallerThan {

    public static void main(String[] args) {
        rightSmallerThan(Arrays.asList(8, 5, 11, -1, 3, 4, 2)).stream().forEach(e -> {
            System.out.print(e);
        });
    }

    // Average case: when the created BST is balanced
    // O(nlog(n)) time | O(n) space - where n is the length of the array
    // ---
    // Worst case: when the created BST is like a linked list
    // O(n^2) time | O(n) space
    public static List<Integer> rightSmallerThan(List<Integer> array) {
        if (array.size() == 0) return new ArrayList<>();
        List<Integer> rightSmallerCounts = new ArrayList<Integer>(array);
        int lastIdx = array.size() - 1;
        SpecialBST bst = new SpecialBST(array.get(lastIdx));
        rightSmallerCounts.set(lastIdx, 0);
        for (int i = array.size() - 2; i >= 0; i--) {
            bst.insert(array.get(i), i, rightSmallerCounts);
        }
        return rightSmallerCounts;
    }

    static class SpecialBST {
        public int value;
        public int leftSubtreeSize;
        public SpecialBST left;
        public SpecialBST right;

        public SpecialBST(int value) {
            this.value = value;
            leftSubtreeSize = 0;
            left = null;
            right = null;
        }

        public void insert(int value, int idx, List<Integer> rightSmallerCounts) {
            insertHelper(value, idx, rightSmallerCounts, 0);
        }

        public void insertHelper(int value, int idx, List<Integer> rightSmallerCounts, int numSmallerAtInsertTime) {
            if (value < this.value) {
                leftSubtreeSize++;
                if (value < this.value) {
                    leftSubtreeSize++;
                    if (left == null) {
                        left = new SpecialBST(value);
                        rightSmallerCounts.set(idx, numSmallerAtInsertTime);
                    } else {
                        left.insertHelper(value, idx, rightSmallerCounts, numSmallerAtInsertTime);
                    }
                } else {
                    numSmallerAtInsertTime += leftSubtreeSize;
                    if (value > this.value) numSmallerAtInsertTime++;
                    if (right == null) {
                        right = new SpecialBST(value);
                        rightSmallerCounts.set(idx, numSmallerAtInsertTime);
                    } else {
                        right.insertHelper(value, idx, rightSmallerCounts, numSmallerAtInsertTime);
                    }
                }
            }
        }

    }
}
