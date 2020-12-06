package com.problem.solving.algorithms.linkedlist;

import java.util.List;
import java.util.Objects;

/**
 * Created by VijaySidhu on 1/29/2018.
 * This will merge two sorted linked list without taking extra space
 */
public class MergeSortedList {

    public static void main(String[] args) {

        Node node1 = new Node(1, new Node(4, new Node(5, null)));
        Node node2 = new Node(1, new Node(3, new Node(4, null)));
        Node node3 = new Node(2, new Node(6, null));
        Node[] nodes = new Node[]{node1, node2, node3};
        Node node = mergeKSortedList(nodes);
        while (node != null) {
            System.out.println(node.getData());
            node = node.next;
        }
    }

    public static Node mergeKSortedList(Node[] nodes) {
        int end = nodes.length - 1;
        while (end > 0) {
            int begin = 0;
            while (begin < end) {
                nodes[begin] = mergeSortedList(nodes[begin], nodes[end]);
                begin++;
                end--;
            }
        }
        return nodes[0];
    }

    public static Node mergeSortedList(Node l1, Node l2) {
        Node dummy = new Node(0, null);
        Node prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null) prev.next = l1;
        if (l2 != null) prev.next = l2;
        return dummy.next;
    }

}
