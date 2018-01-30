package com.problem.solving.algorithms.linkedlist;

import java.util.Objects;

/**
 * Created by VijaySidhu on 1/28/2018.
 */
public class RunnerClass {

    public static void main(String[] args) {

        /**
         * Reverse Linked List
         */
        System.out.println("");
        printer(ReverseList.reverseList(createLinkedList()));


        /**
         * Middle Detector
         */
        System.out.println(" ");
        System.out.println("Middle Element is " + (MiddleElementDetector.middleDetector(createLinkedList()).getData()));

        /**
         * Loop Detector with Floyd's cycle
         */
        printer(LoopDetector.removeLoopIfExist(createLinkedList()));
        System.out.println("");
        System.out.println("Creating and Removing loop.........");
        printer(LoopDetector.removeLoopIfExist(LoopDetector.createLoop(createLinkedList())));

        /**
         * Nth Node Search
         */
        System.out.println("");
        System.out.println("Search nth node");
        printer(NthNodeSearch.searchNthNode(createLinkedList(), 2));
        /**
         * Search kth from last
         */
        System.out.println("");
        printer(SearchKthFromLast.searchKthFromLast(createLinkedList(), 2));

        /**
         * Reverse Pairs
         */
        System.out.println("");
        System.out.println("Reverse Pairs");
        printer(ReversePairs.reversePairs(createLinkedList()));

        /**
         * Merge two sorted linked list
         */
        System.out.println("");
        System.out.println("Merge Linked List");
        printer(MergeSortedList.mergeSortedList(createLinkedList(), createLinkedList()));

        /**
         * Swap Given nodes
         */
        System.out.println("");
        System.out.println("Swap given nodes");
        printer(SwapGivenNodes.swapGivenNodes(createLinkedList(), 2, 3));
        /**
         * Alternate delete
         */
        System.out.println("");
        System.out.println("Alternate Node deletion");
        printer(AlternateNodesDeletion.recursiveDelete(createLinkedList()));
    }

    private static Node createLinkedList() {
        Node nextNextNext = new Node(4, null);
        Node nextNext = new Node(3, nextNextNext);
        Node headNext = new Node(2, nextNext);
        Node head = new Node(1, headNext);
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
