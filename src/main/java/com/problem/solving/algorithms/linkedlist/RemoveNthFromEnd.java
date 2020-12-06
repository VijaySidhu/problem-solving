package com.problem.solving.algorithms.linkedlist;

public class RemoveNthFromEnd {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node rs = removeNthFromEnd(head, 2);
        while (rs != null) {
            System.out.println(rs.getData());
            rs = rs.next;
        }

    }

    /*
        Time complexity O(L) and Space complexity O(1)
     */
    static Node removeNthFromEnd(Node head, int n) {
        // Create dummy node
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node first = dummyNode;
        Node second = dummyNode;
        // Advance first pointer so that gap between first and second is nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        // Move first node to end and maintain gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return dummyNode.next;
    }


    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
