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
        /**
         * Create Tree from Parent Array
         */
        System.out.println("");
        System.out.println("Tree from Parent Arrays");
        int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5};
        DepthFirstTraversal.inOrder(TreeFromArray.createTree(parent, parent.length));
        /**
         * Build From Given InOrder and PreOrder
         */
        System.out.println("");
        System.out.println("Build From Given InOrder and PreOrder");
        int[] inOrder = {2, 5, 6, 10, 12, 14, 15};
        int[] preOrder = {10, 5, 2, 6, 14, 12, 15};

        DepthFirstTraversal.inOrder(CreateFromGivenInorderPreOrder.buildTree(inOrder, preOrder, 0, inOrder.length - 1));
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
