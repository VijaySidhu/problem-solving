package com.problem.solving.algorithms.arrays;

public class Pow {

    public static void main(String[] args) {
        int x = 2;
        int y = 3;

        //System.out.println(power(x, y));
        System.out.println("Below is efficient O(logN)");

        System.out.println(powerEfficient(x, y));
    }

    /*
    Approach 1
    power(x, n) = power(x, n / 2) * power(x, n / 2);        // else n is even
    power(x, n) = x * power(x, n / 2) * power(x, n / 2);   // if n is odd
    Time Complexity: O(n)
    Space Complexity: O(1)
    Problem with this is each sub problem is computed twice for each recursive call.
    We can optimize this by computing the solution of sub problem once only.
     */
    static int power(int x, int y) {
        if (y == 0)
            return 1;
        else if (y % 2 == 0)
            return power(x, y / 2) * power(x, y / 2);
        else
            return x * power(x, y / 2) * power(x, y / 2);
    }

    /*
    Approach 2  Divide and conquer.

    TC  O(logn)
     */
    static int powerEfficient(int x, int y) {
        int temp;
        if (y == 0)
            return 1;
        temp = powerEfficient(x, y / 2);

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
