package com.problem.solving.algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by VijaySidhu on 2/1/2018.
 */
public class BinaryTreeFromLinkedList {

    /**
     * If root node is stored at index i, its left, and right children are stored at indices 2*i+1, 2*i+2 respectively.
     * Time complexity of the above solution is O(n) where n is the number of nodes.
     * @return
     */
    public static Node binaryTreeFromLinkedList(com.problem.solving.algorithms.linkedlist.Node head) {
        if (head == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<Node>();
        Node root = new Node(head.getData(), null, null);
        queue.add(root);
        head = head.getNext();
        while (head != null) {
            Node parent = queue.poll();
            Node leftChild = null, rightChild = null;
            leftChild = new Node(head.getData(), null, null);
            queue.add(leftChild);
            head = head.getNext();
            if (head != null) {
                rightChild = new Node(head.getData(), null, null);
                queue.add(rightChild);
                head = head.getNext();
            }
            parent.setLeft(leftChild);
            parent.setRight(rightChild);


        }
        return root;
    }
}
