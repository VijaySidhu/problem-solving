package com.problem.solving.algorithms.arrays;

public class PlusOne {

    /*
    Approach : To add one to number represented by digits, follow the below steps :

    Parse the given array from end like we do in school addition.
    If the last elements 9, make it 0 and carry = 1.
    For the next iteration check carry and if it adds to 10, do same as step 2.
    After adding carry, make carry = 0 for the next iteration.
    If the vectors add and increase the vector size, append 1 in the beginning.
     */

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }

}
