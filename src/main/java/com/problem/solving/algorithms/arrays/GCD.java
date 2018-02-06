package com.problem.solving.algorithms.arrays;

/**
 * Created by VijaySidhu on 2/5/2018.
 */
public class GCD {

    // Find Greatest Common Divisor
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else
            return gcd(b, a % b);
    }
}
