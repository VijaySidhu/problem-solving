package com.problem.solving.algorithms.linkedlist;

/**
 * Created by VijaySidhu on 1/30/2018.
 */
public class InsertIntoSorted {

    public static Node insertIntoSorted(Node node, int data) {
        Node newNode = new Node(data, null);
        Node temp = node;
        if (data == 0) {
            newNode.next = node;
            return newNode;
        }
        while (node.next != null && node.getData() < data) {
            node = node.next;
        }
        newNode.next = node.next;
        node.next = newNode;
        return temp;
    }
}
