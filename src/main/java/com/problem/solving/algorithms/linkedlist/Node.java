package com.problem.solving.algorithms.linkedlist;

/**
 * Created by VijaySidhu on 1/28/2018.
 */
public class Node {

    int data;

    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public int getData() {
        return data;
    }
}
