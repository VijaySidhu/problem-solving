package com.problem.solving.algorithms.linkedlist;

import com.problem.solving.algorithms.ProblemSolverUtils;

/*Given the head of a linked list, rotate the list to the right by k places.
Input: head = [1,2,3,4,5], k = 2
        Output: [4,5,1,2,3]
 */
public class RotateLinkedListByK {
    public static void main(String[] args) {
        Node head = ProblemSolverUtils.createLinkedList();
        rotate(head, 2);
        ProblemSolverUtils.printer(head);
    }


    /* Solution
    To rotate a linked list by k, we can first make the linked list circular
     and then moving k-1 steps forward from head node, making it null and make kth node as head.
     */
    static Node rotate(Node head, int k) {
        if (k == 0)
            return null;

        // Let us understand the below
        // code for example k = 4 and
        // list = 10.20.30.40.50.60.
        Node current = head;

        // Traverse till the end.
        while (current.next != null)
            current = current.next;

        current.next = head;
        current = head;

        // traverse the linked list to k-1 position which
        // will be last element for rotated array.
        for (int i = 0; i < k - 1; i++)
            current = current.next;

        // update the head_ref and last element pointer to null
        head = current.next;
        current.next = null;
        return head;
    }

}
