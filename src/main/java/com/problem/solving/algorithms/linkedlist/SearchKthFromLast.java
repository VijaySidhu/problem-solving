package com.problem.solving.algorithms.linkedlist;

import java.util.Objects;

/**
 * Created by VijaySidhu on 1/28/2018.
 * Time Complexity: O(n) where n is the length of linked list.
 */
public class SearchKthFromLast {

    public static Node searchKthFromLast(Node head, int k) {
        Node slowPointer = head;
        Node fastPointer = head.next;
        /**
         * Move fast pointer to k nodes from head
         */
        while (k > 0) {
            fastPointer = fastPointer.next;
            k--;
        }
        /**
         * Now move both pointers until fast pointer reaches at the end
         */
        while (Objects.nonNull(fastPointer)) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return slowPointer;
    }
}
