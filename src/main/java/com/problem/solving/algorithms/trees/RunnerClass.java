package com.problem.solving.algorithms.trees;

import com.problem.solving.algorithms.ProblemSolverUtils;

/**
 * Created by VijaySidhu on 1/30/2018.
 */
public class RunnerClass {


    public static void main(String[] args) {
        /**
         * BST or Level Order Traverse with queue
         */
        BreadFirstTraversal.bst(ProblemSolverUtils.createTree());
        /**
         * InOrder
         */
        System.out.println("");
        System.out.println("InOrder");
        DepthFirstTraversal.inOrder(ProblemSolverUtils.createTree());
        /**
         * Pre Order
         */
        System.out.println("");
        System.out.println("PreOrder");
        DepthFirstTraversal.preOrder(ProblemSolverUtils.createTree());
        /**
         * Post Order
         */
        System.out.println("");
        System.out.println("PostOrder");
        DepthFirstTraversal.postOrder(ProblemSolverUtils.createTree());
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

        /**
         * Create Bin Tree from Linked list
         */
        System.out.println("");
        System.out.println("Bin Tree From Linked List");
        DepthFirstTraversal.inOrder(BinaryTreeFromLinkedList.binaryTreeFromLinkedList(ProblemSolverUtils.createLinkedList()));

    }


}
