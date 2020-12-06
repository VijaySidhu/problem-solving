package com.problem.solving.algorithms.arrays;

public class RemoveGivenElement {

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 2, 3, 4, 4, 5, 6};
        System.out.println(removeKSorted(array, 4));
    }

    /*
    TC O(N)
      O(1) extra memory
     */

    public static int removeKSorted(int[] array, int k) {
        int len = array.length;
        int i = 0;
        for (int j = 1; j < len; j++) {
            if (array[j] != k) {
                i++;
                array[i] = array[j];
            }
        }
        return i;
    }
}
