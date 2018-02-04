package com.problem.solving.algorithms.trees;

import com.problem.solving.algorithms.linkedlist.NodeDoubly;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VijaySidhu on 2/3/2018.
 */
public class DoublyFromTernary {

    /**
     * Left pointer of ternary tree should act as prev pointer of doubly linked list.
     * Middle pointer of ternary tree should not point to anything.
     * Right pointer of ternary tree should act as next pointer of doubly linked list.
     * Each node of ternary tree is inserted into doubly linked list before its subtrees and for any node, its left child
     * will be inserted first, followed by mid and right child (if any).
     */
    public static NodeDoubly triToDoubly(NodeTri root) {
        if (root == null) {
            return null;
        }
        NodeDoubly rootDoubly = new NodeDoubly();
        List<Integer> values = DepthFirstTraversal.preOrderTri(root, new ArrayList<Integer>());

        for (Integer val : values) {
            rootDoubly = push(val, rootDoubly);
        }


        return rootDoubly;
    }

    // Push Current node at end of doubly linked list

    private static NodeDoubly push(int data, NodeDoubly nodeDoubly) {
        if (data == 0) {
            return nodeDoubly;
        }
        NodeDoubly current = nodeDoubly;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        // Create New Node
        NodeDoubly newNode = new NodeDoubly(data);
        // Last Node of Doubly holds address of new Node
        current.setRight(newNode);
        // End of List set new node next will be null
        newNode.setRight(null);
        // Hold Address of Last Node
        newNode.setLeft(current);
        return nodeDoubly;
    }


}

