package com.problem.solving.algorithms.practice;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node nodeFirst = new Node();
        nodeFirst.data = 1;
        Node nodeSecond = new Node();
        nodeSecond.data = 2;
        nodeFirst.next = nodeSecond;
        Node nodeThird = new Node();
        nodeThird.data = 3;
        nodeSecond.next = nodeThird;
    }


    private static Node reverseList(Node head) {
        if (head == null) {
            return new Node();
        }
        Node current = head;
        Node previous = null;
        while (current != null) {
            // Save next node of current node
            Node currentNext = current.next;
            // Set next to previous
            current.next = previous;
            previous = current;
            current = currentNext;


        }
        return head;
    }

}

class Node {
    Node next;
    int data;
}
