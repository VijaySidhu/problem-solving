package com.problem.solving.algorithms.trees;

/**
 * Created by VijaySidhu on 1/30/2018.
 */
public class RunnerClass {


    public static void main(String[] args) {
        /**
         * BST or Level Order Traverse with queue
         */
        BreadFirstTraversal.bst(createTree());
        /**
         * InOrder
         */
        System.out.println("");
        System.out.println("InOrder");
        DepthFirstTraversal.inOrder(createTree());
        /**
         * Pre Order
         */
        System.out.println("");
        System.out.println("PreOrder");
        DepthFirstTraversal.preOrder(createTree());
        /**
         * Post Order
         */
        System.out.println("");
        System.out.println("PostOrder");
        DepthFirstTraversal.postOrder(createTree());
    }

    private static Node createTree() {
        Node rightOfRightOfRight = new Node(7, null, null);
        Node leftOfLeftOfLeft = new Node(6, null, null);
        Node rightOfRight = new Node(5, null, null);
        Node leftOfLeft = new Node(4, null, null);
        Node right = new Node(3, leftOfLeftOfLeft, rightOfRightOfRight);
        Node left = new Node(2, leftOfLeft, rightOfRight);
        Node root = new Node(1, left, right);
        return root;
    }
}
