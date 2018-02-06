package com.problem.solving.algorithms.arrays;

/**
 * Created by VijaySidhu on 2/5/2018.
 */
public class Rotation {
    /**
     * Rotates given array of size n by d
     * Juggling Algo rotates array in sets
     * First find  GCD and let loop iterate < = GCD(Total number of Sets)
     */
    public static int[] rotateWithJugglingAlgorithm(int array[], int n, int d) {
        int i, j, k, temp;
        // Loop upto GCD
        for (i = 0; i < GCD.gcd(d, n); i++) {
            temp = array[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n) {
                    k = k - n;
                }
                if (k == i) {
                    break;
                }
                array[j] = array[k];
                j = k;
            }
            array[j] = temp;
        }
        return array;
    }
}
