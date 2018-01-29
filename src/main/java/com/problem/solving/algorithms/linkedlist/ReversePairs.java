package com.problem.solving.algorithms.linkedlist;

import java.util.Objects;

/**
 * Created by VijaySidhu on 1/28/2018.
 */
public class ReversePairs {

    public static Node reversePairs(Node head) {
        Node temp = head;
        while (Objects.nonNull(temp) && Objects.nonNull(temp.next)) {
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
        }
        return head;
    }
}
