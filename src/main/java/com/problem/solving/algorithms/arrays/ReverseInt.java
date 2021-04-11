package com.problem.solving.algorithms.arrays;

public class ReverseInt {

    /*
    TC O(log(x)
    SC O(1)
     */
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) res;
        }
    }
}
