package com.problem.solving.algorithms.linkedlist;

import java.util.Objects;

/**
 * Created by VijaySidhu on 1/28/2018.
 */
public class MiddleElementDetector {

    public static Node middleDetector(Node head) {
        Node slowPointer = head;
        Node fastPointer = head.next;
        while (Objects.nonNull(fastPointer) && Objects.nonNull(fastPointer.next)) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }
}
