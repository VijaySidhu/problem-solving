package com.problem.solving.algorithms.linkedlist;

import java.util.Objects;

/**
 * Created by VijaySidhu on 1/28/2018.
 * This is Floyd's Cycle Algorithm
 * Complexity O(n)
 * Space O(n)
 * Take two pointer slow and fast move slow pointer by 1 and faster pointer by 2 if slow and fast pointer meet then there is loop
 */
public class LoopDetector {

    public static Node removeLoopIfExist(Node head) {
        Node slowPointer = head;
        Node fastPointer = head.next;
        while (Objects.nonNull(slowPointer) && Objects.nonNull(fastPointer) && Objects.nonNull(fastPointer.next)) {
            if (slowPointer == fastPointer) {
                return removeLoop(slowPointer, fastPointer, head);
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return head;
    }

    public static Node createLoop(Node head) {
        Node start = head;
        while (Objects.nonNull(head.next)) {
            head = head.next;
        }
        head.next = start;
        return start;
    }

    public static Node removeLoop(Node slowPointer, Node fastPointer, Node head) {
        if (slowPointer == fastPointer) {
            slowPointer = head;
            while (slowPointer != fastPointer.next) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
            fastPointer.next = null;
        }

        return head;
    }

    public static void printer(Node head) {
        while (Objects.nonNull(head)) {
            System.out.print(head.getData());
            head = head.next;
            if (Objects.nonNull(head)) {
                System.out.print("-->");
            }
        }
    }
}
