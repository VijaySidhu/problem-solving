package com.problem.solving.algorithms.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VijaySidhu on 1/29/2018.
 * Get Middle of linked list
 * Reverse Second half
 * Compare both
 * Reverse Second half again and construct orignal list
 */
public class IsPalindrome {

    /**
     * TC O(n)
     * TC O(n)
     * We can split this approach into 2 steps:
     * Copying the Linked List into an Array.
     * Checking whether or not the Array is a palindrome.
     */
    public static boolean isPalindrome(Node head) {
        List<Integer> vals = new ArrayList<>();

        // Convert LinkedList into ArrayList.
        Node currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.data);
            currentNode = currentNode.next;
        }

        // Use two-pointer technique to check for palindrome.
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    /*
        Advanced with recursion but same TC and SC
     */
    private Node frontPointer;

    private boolean recursivelyCheck(Node currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false;
            if (currentNode.data != frontPointer.data) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindromeRec(Node head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    /*
     TC O(n)
     SC O(1)
     Find the end of the first half.
     Reverse the second half.
     Determine whether or not there is a palindrome.
     Restore the list.
     Return the result.
     */

    public boolean isPalindromeO_1_space(Node head) {

        if (head == null) return true;

        // Find the end of first half and reverse second half.
        Node firstHalfEnd = endOfFirstHalf(head);
        Node secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        Node p1 = head;
        Node p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.data != p2.data) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
    private Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private Node endOfFirstHalf(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
