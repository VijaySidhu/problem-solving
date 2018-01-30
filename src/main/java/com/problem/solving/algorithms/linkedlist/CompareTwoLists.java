package com.problem.solving.algorithms.linkedlist;

/**
 * Created by VijaySidhu on 1/29/2018.
 */
public class CompareTwoLists {

    public static boolean IsSame(Node first, Node second) {
        if (first == null && second == null) {
            return true;
        }
        while (first != null && second != null) {
            if (first.getData() == second.getData()) {
                first = first.next;
                second = second.next;
            } else {
                return false;
            }

        }
        return false;
    }
}
