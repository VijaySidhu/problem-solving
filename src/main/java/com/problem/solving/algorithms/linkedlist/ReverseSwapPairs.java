package com.problem.solving.algorithms.linkedlist;

import com.problem.solving.algorithms.ProblemSolverUtils;

import java.util.Objects;

/**
 * Created by VijaySidhu on 1/28/2018.
 */
public class ReverseSwapPairs {
    /*
    i. Start traversing list and swap each node while traversing
    Time Complexity O(n)

     */
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

    public static void main(String[] args) {
        Node node = pairWiseSwap(ProblemSolverUtils.createLinkedList());
        while (node != null) {
            System.out.println(node.getData());
            node = node.next;
        }
    }
    /*
        Recursive solution
        i. If there are two or more than two nodes in linked list then swap first two nodes and recursivly
           call for rest of the list
           TC O(n)
     */

    static Node pairWiseSwap(Node head) {

        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }

        // Swapping first and second
        Node first = new Node(head.next.getData(), null);
        Node second = new Node(head.getData(), null);
        first.next = second;


        // recursivly swap remaining items in the list till end of list
        Node recursedList = pairWiseSwap(head.next.next);
        first.next.next = recursedList;

        return first;
    }


}
