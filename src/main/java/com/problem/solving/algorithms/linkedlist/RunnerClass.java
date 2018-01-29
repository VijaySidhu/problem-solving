package com.problem.solving.algorithms.linkedlist;

/**
 * Created by VijaySidhu on 1/28/2018.
 */
public class RunnerClass {

    public static void main(String[] args) {
        LoopDetector.printer(LoopDetector.removeLoopIfExist(createLinkedList()));
        System.out.println("");
        System.out.println("Creating and Removing loop.........");
        LoopDetector.printer(LoopDetector.removeLoopIfExist(LoopDetector.createLoop(createLinkedList())));
    }

    private static Node createLinkedList() {
        Node nextNextNext = new Node(4, null);
        Node nextNext = new Node(3, nextNextNext);
        Node headNext = new Node(2, nextNext);
        Node head = new Node(1, headNext);
        return head;
    }
}
