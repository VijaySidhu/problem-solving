package com.problem.solving.algorithms.trees;

import com.problem.solving.algorithms.ProblemSolverUtils;

/**
 * Created by VijaySidhu on 1/30/2018.
 */
public class RunnerTree {


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
        /**
         * Create Tree from Given Pre and Post Orders
         */
        System.out.println("");
        System.out.println("Create Binary Tree from Given Pre and Post Orders");
        int pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int post[] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
        DepthFirstTraversal.inOrder(BinTreeFromGivenPrePostTravesals.binaryTreeFromGivenPrePostTraversal(pre, post, 0, pre.length - 1, pre.length));

        /**
         * Special Tree from Given Pre Order and Leaf and Non Leaf Nodes // TODO Below is not working yet
         */
        System.out.println("");
        System.out.println("Special Tree from Given Pre Order and Leaf and Non Leaf Node array indexes");
        int index = 0;
        Node root = null;
        int preOrderGiven[] = new int[]{10, 30, 20, 5, 15};
        char preLN[] = new char[]{'N', 'N', 'L', 'L', 'L'};
        DepthFirstTraversal.preOrder(SpecialTree.specialTreeOfGivenScenario(preOrder, preLN, index, preOrderGiven.length, root));

        /**
         * Sprial Print Tree
         */
        System.out.println("");
        System.out.println("");
        SpiralForm.zigZagPrinter(ProblemSolverUtils.createTree());

    }


}
