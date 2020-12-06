package com.problem.solving.algorithms.linkedlist;

import com.problem.solving.algorithms.ProblemSolverUtils;

/**
 * Created by VijaySidhu on 1/28/2018.
 */
public class RunnerClass {

    public static void main(String[] args) {

        /**
         * Reverse Linked List
         */
        System.out.println("");
        ProblemSolverUtils.printer(ReverseList.reverseList(ProblemSolverUtils.createLinkedList()));


        /**
         * Middle Detector
         */
        System.out.println(" ");
        System.out.println("Middle Element is " + (MiddleElementDetector.middleDetector(ProblemSolverUtils.createLinkedList()).getData()));

        /**
         * Loop Detector with Floyd's cycle
         */
        ProblemSolverUtils.printer(LoopDetector.removeLoopIfExist(ProblemSolverUtils.createLinkedList()));
        System.out.println("");
        System.out.println("Creating and Removing loop.........");
        ProblemSolverUtils.printer(LoopDetector.removeLoopIfExist(LoopDetector.createLoop(ProblemSolverUtils.createLinkedList())));

        /**
         * Nth Node Search
         */
        System.out.println("");
        System.out.println("Search nth node");
        ProblemSolverUtils.printer(NthNodeSearch.searchNthNode(ProblemSolverUtils.createLinkedList(), 2));
        /**
         * Search kth from last
         */
        System.out.println("");
        ProblemSolverUtils.printer(SearchKthFromLast.searchKthFromLast(ProblemSolverUtils.createLinkedList(), 2));

        /**
         * Reverse Pairs
         */
        System.out.println("");
        System.out.println("Reverse Pairs");
        ProblemSolverUtils.printer(ReverseSwapPairs.reversePairs(ProblemSolverUtils.createLinkedList()));

        /**
         * Merge two sorted linked list
         */
        System.out.println("");
        System.out.println("Merge Linked List");
        ProblemSolverUtils.printer(MergeSortedList.mergeSortedList(ProblemSolverUtils.createLinkedList(), ProblemSolverUtils.createLinkedList()));

        /**
         * Swap Given nodes
         */
        System.out.println("");
        System.out.println("Swap given nodes");
        ProblemSolverUtils.printer(SwapGivenNodes.swapGivenNodes(ProblemSolverUtils.createLinkedList(), 2, 3));
        /**
         * Alternate delete
         */
        System.out.println("");
        System.out.println("Alternate Node deletion");
        ProblemSolverUtils.printer(AlternateNodesDeletion.recursiveDelete(ProblemSolverUtils.createLinkedList()));
        /**
         * Is Palindrome
         */
        System.out.println("");
        System.out.println("IsPalindrome");
        System.out.println(IsPalindrome.isPalindrome(ProblemSolverUtils.palindromeList()));
        /**
         * Insert Node at given position
         */
        System.out.println("");
        System.out.println("Insert node at given position");
        ProblemSolverUtils.printer(InsertAtGivenPosition.insertAtGivenPosition(ProblemSolverUtils.createLinkedList(), 2, 5));
        /**
         * Insert into Sorted list
         */
        System.out.println("");
        System.out.println("Insert into sorted list");
        ProblemSolverUtils.printer(InsertIntoSorted.insertIntoSorted(ProblemSolverUtils.createLinkedList(), 3));
    }


}
