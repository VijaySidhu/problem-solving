package com.problem.solving.algorithms.linkedlist;

import java.util.Objects;

/**
 * Created by VijaySidhu on 1/28/2018.
 */
public class NthNodeSearch {

    public static Node searchNthNode(Node node, int n) {
        if (Objects.isNull(node)) {
            return node;
        }
        int counter = 0;

        while (Objects.nonNull(node)) {
            if (counter == n) {
                return node;
            }
            counter++;
            node = node.next;
        }
        /**
         * If Come at this line means caller is asking for non existence index
         */
        return null;
    }
}
