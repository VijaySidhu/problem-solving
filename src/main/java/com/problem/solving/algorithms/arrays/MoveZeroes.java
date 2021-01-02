package com.problem.solving.algorithms.arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 0, 0, 3, 4, 0, 5};
        for (int i : moveZerios(input)) {
            System.out.println(i);
        }
    }

    private static int[] moveZerios(int[] input) {
        int lastNonZeroIndex = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0) {
                input[lastNonZeroIndex++] = input[i];
            }
        }

        // Now fill remaining indexes with Zeroes
        for (int i = lastNonZeroIndex; i < input.length; i++) {
            input[i] = 0;
        }

        return input;
    }
}
