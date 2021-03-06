package com.problem.solving.algorithms.linkedlist;

import com.problem.solving.algorithms.ProblemSolverUtils;

public class ReverseKGroup {

    public static void main(String[] args) {
        Node n = reverseKGroup(ProblemSolverUtils.createLinkedList(), 2);
        ProblemSolverUtils.printer(n);
    }

    /*
            Time Complexity: O(n).
            Traversal of list is done only once and it has ‘n’ elements.
            Auxiliary Space: O(n/k).
            For each Linked List of size n, n/k or (n/k)+1 calls will be made during the recursion.
     */
    public static Node reverseKGroup(Node head, int k) {
        int count = 0;
        Node current = head;
        Node second = null;
        Node first = null;
        // Reverse first K nodes of linked list
        while (count < k && current != null) {
            second = current.next;
            current.next = first;
            first = current;
            current = second;
            count++;
        }
         /* next is now a pointer to (k+1)th node
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
        if (second != null) {
            head.next = reverseKGroup(second, k);
        }

        return first;
    }
}
