package com.problem.solving.algorithms;

import com.problem.solving.algorithms.linkedlist.Node;

import java.util.Objects;

/**
 * Created by VijaySidhu on 2/1/2018.
 */
public class ProblemSolverUtils {

    public static Node createLinkedList() {
        Node nextNextNext = new Node(4, null);
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

    public static com.problem.solving.algorithms.trees.Node createTree() {
        com.problem.solving.algorithms.trees.Node rightOfRightOfRight = new com.problem.solving.algorithms.trees.Node(7, null, null);
        com.problem.solving.algorithms.trees.Node leftOfLeftOfLeft = new com.problem.solving.algorithms.trees.Node(6, null, null);
        com.problem.solving.algorithms.trees.Node rightOfRight = new com.problem.solving.algorithms.trees.Node(5, null, null);
        com.problem.solving.algorithms.trees.Node leftOfLeft = new com.problem.solving.algorithms.trees.Node(4, null, null);
        com.problem.solving.algorithms.trees.Node right = new com.problem.solving.algorithms.trees.Node(3, leftOfLeftOfLeft, rightOfRightOfRight);
        com.problem.solving.algorithms.trees.Node left = new com.problem.solving.algorithms.trees.Node(2, leftOfLeft, rightOfRight);
        com.problem.solving.algorithms.trees.Node root = new com.problem.solving.algorithms.trees.Node(1, left, right);
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
            System.out.print(i+" ");
        }
    }
}
