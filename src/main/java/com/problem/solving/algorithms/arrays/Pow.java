package com.problem.solving.algorithms.arrays;

public class Pow {

    public static void main(String[] args) {
        int x = 2;
        int y = 4;

        //System.out.println(power(x, y));
        System.out.println("Below is efficient O(logN)");

        System.out.println(fastPower(x, y));
    }


    /*
    Approach 2  Divide and conquer.
    Assume we have got the result of x^n/2 and now we want to get result of x^n.
    Let A be result of x^n/2, we can talk about x^n based on the parity of n respectively.
    If n is even we can use the formula (x^n)^2=x^(2*n) to get x^n=A*A
    If n is odd A*A=x^(n-1) we need to multiply another x to the result so x^n=A*A*x

    TC  O(logn)
     */
    static int fastPower(int x, int y) {
        int temp;
        if (y == 0)
            return 1;
        temp = fastPower(x, y / 2);

        if (y % 2 == 0)
            return temp * temp;
        else {
            if (y > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }

    /*
    Same as second approach but iterative solution with binary operators
     */
    // Iterative solution to calculate pow(x, n) using binary operators
    public static int powerIterative(int x, int n) {
        int pow = 1;

        // do till n is zero
        while (n > 0) {
            // if n is odd, multiply result by x
            if ((n & 1) == 1) {
                pow *= x;
            }

            // divide n by 2
            n = n >> 1;

            // multiply x by itself
            x = x * x;
        }

        // return result
        return pow;
    }
}
