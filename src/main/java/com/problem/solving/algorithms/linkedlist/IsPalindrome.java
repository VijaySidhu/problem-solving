package com.problem.solving.algorithms.linkedlist;

/**
 * Created by VijaySidhu on 1/29/2018.
 * Get Middle of linked list
 * Reverse Second half
 * Compare both
 * Reverse Second half again and construct orignal list
 */
public class IsPalindrome {

    public static boolean isPalindrome(Node node) {
        if (node != null && node.next != null) {
            Node middleNode = MiddleElementDetector.middleDetector(node);
            Node previousOfMiddle = MiddleElementDetector.getPreviousOfSlowPointer();
            // Reverse Second Half
            Node secondHalf = ReverseList.reverseList(middleNode);
            previousOfMiddle.next = null;
            //Compare two Lists
            CompareTwoLists.IsSame(node,secondHalf);
        }

        return false;
    }

}