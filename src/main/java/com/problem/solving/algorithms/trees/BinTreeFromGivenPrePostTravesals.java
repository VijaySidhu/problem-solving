package com.problem.solving.algorithms.trees;

/**
 * Created by VijaySidhu on 2/1/2018.
 * explaination
 * Let us consider the two given arrays as pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7} and post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
 * In pre[], the leftmost element is root of tree. Since the tree is full and array size is more than 1.
 * The value next to 1 in pre[], must be left child of root. So we know 1 is root and 2 is left child.
 * How to find the all nodes in left subtree? We know 2 is root of all nodes in left subtree. All nodes before 2 in post[] must be in left subtree.
 * Now we know 1 is root, elements {8, 9, 4, 5, 2} are in left subtree, and the elements {6, 7, 3} are in right subtree.
 */
public class BinTreeFromGivenPrePostTravesals {


    private static int preIndex = 0;

    public static Node binaryTreeFromGivenPrePostTraversal(int pre[], int post[], int low, int high, int size) {
        // Base case
        if (preIndex >= size || low > high)
            return null;

        // First Element in Pre is root of tree
        Node root = new Node(pre[preIndex], null, null);
        preIndex++;
        // If Current Subarray has only one element no need to recurse return root
        if (low == high || preIndex >= size) {
            return root;
        }
        // Search next element of pre in post. All the left elements of Index of element found is left subtree and on
        // right is right subtree
        int i;
        for (i = low; i <= high; i++) {
            if (post[i] == pre[preIndex]) {
                break;
            }
        }
        if (i <= high) {
            root.setLeft(binaryTreeFromGivenPrePostTraversal(pre, post, low, i, size));
            root.setRight(binaryTreeFromGivenPrePostTraversal(pre, post, i + 1, high, size));
        }
        return root;
    }
}
