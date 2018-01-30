package com.problem.solving.algorithms.linkedlist;

import java.util.Objects;

/**
 * Created by VijaySidhu on 1/29/2018.
 * This will merge two sorted linked list without taking extra space
 */
public class MergeSortedList {

    public static Node mergeSortedList(Node list1, Node list2) {
        if (Objects.isNull(list1)) {
            return list1;
        }
        if (Objects.isNull(list2)) {
            return list2;
        }
        if ((list1.getData() < list2.getData())) {
            list1.next = mergeSortedList(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeSortedList(list2.next, list1);
            return list2;
        }
    }
}
