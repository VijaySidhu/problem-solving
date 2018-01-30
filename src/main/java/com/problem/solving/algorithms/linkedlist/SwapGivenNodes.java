package com.problem.solving.algorithms.linkedlist;

import java.util.Objects;

/**
 * Created by VijaySidhu on 1/29/2018.
 */
public class SwapGivenNodes {

    public static Node swapGivenNodes(Node node, int x, int y) {
        Node previousOfX = null;
        Node previousOfY = null;
        Node currentX = node;
        Node currentY = node;
        // Nothing to Swap
        if (x == y) {
            return node;
        }
        // find previous of X
        while (Objects.nonNull(currentX) && currentX.getData() != x) {
            previousOfX = currentX;
            currentX = currentX.next;
        }
        // find previous of y
        while (Objects.nonNull(currentY) && currentY.getData() != y) {
            previousOfY = currentY;
            currentY = currentY.next;
        }
        // if X or Y is not present  , nothing to do
        if (Objects.isNull(currentX) && Objects.isNull(currentY)) {
            return node;
        }
        // if X is not the first element
        if (previousOfX != null) {
            previousOfX.next = currentY;
        } else {
            node = currentY;
        }
        // if y is not the first element
        if (previousOfY != null) {
            previousOfY.next = currentX;
        } else {
            node = currentX;
        }

        // Swap next pointers
        Node temp = currentX.next;
        currentX.next = currentY.next;
        currentY.next = temp;
        
        return node;
    }
}
