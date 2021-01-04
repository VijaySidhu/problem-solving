package com.problem.solving.algorithms.arrays;

public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 2, 3, 4, 4, 5, 6};
        System.out.println(removeDuplicateSorted(array));
    }

    /*
      O(1) extra memory
      O(n) Each of slow and fast pointer traverses at most n steps.
      1. Create two pointers,
                Initialize slow pointer with 0 (First index)
                Initialize fast pointer with 1 (Next Index)
      2. Iterate from fast pointer to length of array
                if element at slow pointer and fast pointer are not equal
                 Increment slow pointer
                 Just populate element at slow pointer with fast pointer
      3. Return new length. (Slow pointer +1)


     */

    public static int removeDuplicateSorted(int[] array) {
        int len = array.length;
        int slowPointer = 0;
        for (int fastPointer = 1; fastPointer < len; fastPointer++) {
            if (array[fastPointer] != array[slowPointer]) {
                slowPointer++;
                array[slowPointer] = array[fastPointer];
            }
        }
        return slowPointer + 1;
    }
}
