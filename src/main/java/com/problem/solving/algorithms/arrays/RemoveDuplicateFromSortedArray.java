package com.problem.solving.algorithms.arrays;

public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 2, 3, 4, 4, 5, 6};
        System.out.println(removeDuplicateSorted(array));
    }

    public static int removeDuplicateSorted(int[] array) {
        int len = array.length;
        int i = 0;
        for (int j = 1; j < len; j++) {
            if (array[j] != array[i]) {
                i++;
                array[i] = array[j];
            }
        }
        return i + 1;
    }
}
