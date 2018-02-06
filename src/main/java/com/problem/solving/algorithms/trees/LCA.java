package com.problem.solving.algorithms.trees;

/**
 * Created by VijaySidhu on 2/5/2018.
 */
public class LCA {

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
}
