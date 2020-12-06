package com.problem.solving.algorithms.linkedlist;

import com.problem.solving.algorithms.ProblemSolverUtils;

public class ReverseKGroup {

    public static void main(String[] args) {
        Node n = reverseKGroup(ProblemSolverUtils.createLinkedList(), 2);
        ProblemSolverUtils.printer(n);
    }

    public static Node reverseKGroup(Node head, int k) {
        int count = 0;
        Node current = head;
        Node next = null;
        Node prev = null;
        // Reverse first K nodes of linked list
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }
}
