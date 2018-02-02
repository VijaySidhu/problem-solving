package com.problem.solving.algorithms.trees;

/**
 * Created by VijaySidhu on 2/1/2018.
 */
public class SpecialTree {

    // Give Pre Order and array of L and N that tell Leaf or Non Leaf Node

    /**
     * First Element in Pre Order is always root
     * Time Complexity: O(n)
     */
    public static Node specialTreeOfGivenScenario(int preOrder[], char preLN[], int index, int n, Node root) {

        if (index == n) {
            return root;
        }

        root = new Node(preOrder[index], null, null);
        index++;

        // If this is non leaf node create left and right
        if (preLN[index] == 'N') {
            root.setLeft(specialTreeOfGivenScenario(preOrder, preLN, index, n, root.getLeft()));
            root.setRight(specialTreeOfGivenScenario(preOrder, preLN, index, n, root.getRight()));
        }
        return root;
    }
}
