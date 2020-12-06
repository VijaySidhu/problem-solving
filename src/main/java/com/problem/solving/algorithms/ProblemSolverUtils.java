package com.problem.solving.algorithms;

import com.problem.solving.algorithms.linkedlist.Node;
import com.problem.solving.algorithms.linkedlist.NodeDoubly;
import com.problem.solving.algorithms.trees.NodeTri;

import java.util.Objects;

/**
 * Created by VijaySidhu on 2/1/2018.
 */
public class ProblemSolverUtils {

    public static Node createLinkedList() {
        Node nextNextNext5 = new Node(5, null);
        Node nextNextNext = new Node(4, nextNextNext5);
        Node nextNext = new Node(3, nextNextNext);
        Node headNext = new Node(2, nextNext);
        Node head = new Node(1, headNext);
        return head;
    }

    public static Node palindromeList() {
        Node nextNext = new Node(1, null);
        Node headNext = new Node(2, nextNext);
        Node head = new Node(1, headNext);
        return head;
    }

    public static void printer(Node head) {
        while (Objects.nonNull(head)) {
            System.out.print(head.getData());
            head = head.getNext();
            if (Objects.nonNull(head)) {
                System.out.print("-->");
            }
        }
    }

    // Binary Tree is Tree in which each node has two children except leaf node
    public static com.problem.solving.algorithms.trees.Node createBinaryTree() {
        com.problem.solving.algorithms.trees.Node rightOfRightOfRight = new com.problem.solving.algorithms.trees.Node(7, null, null);
        com.problem.solving.algorithms.trees.Node leftOfLeftOfLeft = new com.problem.solving.algorithms.trees.Node(6, null, null);
        com.problem.solving.algorithms.trees.Node rightOfRight = new com.problem.solving.algorithms.trees.Node(5, null, null);
        com.problem.solving.algorithms.trees.Node leftOfLeft = new com.problem.solving.algorithms.trees.Node(4, null, null);
        com.problem.solving.algorithms.trees.Node right = new com.problem.solving.algorithms.trees.Node(3, leftOfLeftOfLeft, rightOfRightOfRight);
        com.problem.solving.algorithms.trees.Node left = new com.problem.solving.algorithms.trees.Node(2, leftOfLeft, rightOfRight);
        com.problem.solving.algorithms.trees.Node root = new com.problem.solving.algorithms.trees.Node(1, left, right);
        return root;
    }

    public static com.problem.solving.algorithms.trees.Node createBinarySearchTree() {
        com.problem.solving.algorithms.trees.Node rootNode = new com.problem.solving.algorithms.trees.Node(30, null, null);
        com.problem.solving.algorithms.trees.Node node10 = new com.problem.solving.algorithms.trees.Node(10, null, null);
        com.problem.solving.algorithms.trees.Node node20 = new com.problem.solving.algorithms.trees.Node(20, null, null);
        com.problem.solving.algorithms.trees.Node node25 = new com.problem.solving.algorithms.trees.Node(25, null, null);
        com.problem.solving.algorithms.trees.Node node35 = new com.problem.solving.algorithms.trees.Node(35, null, null);
        com.problem.solving.algorithms.trees.Node node40 = new com.problem.solving.algorithms.trees.Node(40, null, null);
        com.problem.solving.algorithms.trees.Node node50 = new com.problem.solving.algorithms.trees.Node(50, null, null);
        com.problem.solving.algorithms.trees.Node node45 = new com.problem.solving.algorithms.trees.Node(45, null, null);
        com.problem.solving.algorithms.trees.Node node60 = new com.problem.solving.algorithms.trees.Node(60, null, null);
        rootNode.setLeft(node20);
        rootNode.setRight(node40);
        node20.setLeft(node10);
        node20.setRight(node25);
        node40.setLeft(node35);
        node40.setRight(node50);
        node50.setRight(node60);
        node50.setLeft(node45);
        return rootNode;
    }


    public static NodeTri creatTernaryTree() {
        NodeTri root = new NodeTri(30);
        NodeTri rootLeft = new NodeTri(5);
        NodeTri rootMiddle = new NodeTri(11);
        NodeTri rootRight = new NodeTri(63);
        NodeTri rootLeftOfLeft = new NodeTri(1);
        NodeTri rootMiddleOfMiddle = new NodeTri(4);
        NodeTri rootRightOfRight = new NodeTri(8);
        NodeTri rootLeftOfLeftOfLeft = new NodeTri(6);
        NodeTri rootMiddleOfMiddleOfMiddle = new NodeTri(7);
        NodeTri rootRightOfRightOfRight = new NodeTri(15);
        NodeTri rootLeftOfLeftOfLeftOfLeft = new NodeTri(31);
        NodeTri rootMiddleOfMiddleOfMiddleOfMiddle = new NodeTri(55);
        NodeTri rootRightOfRightOfRightOfRight = new NodeTri(65);
        root.setLeft(rootLeft);
        root.setMiddle(rootMiddle);
        root.setRight(rootRight);
        rootLeft.setLeft(rootLeftOfLeft);
        rootLeft.setMiddle(rootMiddleOfMiddle);
        rootLeft.setRight(rootRightOfRight);
        rootMiddle.setLeft(rootLeftOfLeftOfLeft);
        rootMiddle.setMiddle(rootMiddleOfMiddleOfMiddle);
        rootMiddle.setRight(rootRightOfRightOfRight);
        rootRight.setLeft(rootLeftOfLeftOfLeftOfLeft);
        rootRight.setMiddle(rootMiddleOfMiddleOfMiddleOfMiddle);
        rootRight.setRight(rootRightOfRightOfRightOfRight);
        return root;
    }

    public static NodeDoubly createDoublyList() {
        NodeDoubly root = new NodeDoubly(1);
        NodeDoubly rootLeft = new NodeDoubly(2);
        NodeDoubly rootRight = new NodeDoubly(3);
        NodeDoubly rootLeftOfLeft = new NodeDoubly(4);
        NodeDoubly rootRightOfRight = new NodeDoubly(5);
        NodeDoubly rootLeftOfLeftOfLeft = new NodeDoubly(6);
        NodeDoubly rootRightOfRightOfRight = new NodeDoubly(7);
        root.setLeft(rootLeft);
        root.setRight(rootRight);
        rootLeft.setLeft(rootLeftOfLeft);
        rootRight.setLeft(rootRightOfRight);
        rootLeftOfLeft.setLeft(rootLeftOfLeftOfLeft);
        rootLeftOfLeft.setLeft(rootRightOfRightOfRight);
        return root;
    }

    public static int[] swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

    public static void printSingleDimArray(int array[]) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void doublyTraverse(NodeDoubly root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            System.out.println(root.getData());
            root = root.getRight();
        }
    }
}
