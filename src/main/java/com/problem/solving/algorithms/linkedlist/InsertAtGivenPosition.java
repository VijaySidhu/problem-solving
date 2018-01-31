package com.problem.solving.algorithms.linkedlist;

/**
 * Created by VijaySidhu on 1/30/2018.
 */
public class InsertAtGivenPosition {

    public static Node insertAtGivenPosition(Node node, int position, int data) {
        if (node == null) {
            return node;
        }
        Node toInsert = new Node(data, null);
        if (position == 0) {
            toInsert.next = node;
            return toInsert;
        }
        Node temp = node;

        int counter = 0;
        while (counter < position - 1 && node.next != null) {
            node = node.next;
            counter++;
        }
        Node nextToPrevious = node.getNext();
        node.next = toInsert;
        toInsert.next = nextToPrevious;
        return temp;

    }
}
