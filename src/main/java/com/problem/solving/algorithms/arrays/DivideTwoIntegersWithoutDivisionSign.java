package com.problem.solving.algorithms.arrays;

// Given a two integers say a and b. Find the quotient after dividing a by b without using multiplication, division and mod operator.
public class DivideTwoIntegersWithoutDivisionSign {

    /*
    Approach : Keep subtracting the divisor from dividend until dividend becomes less than divisor.
    The dividend becomes the remainder, and the number of times subtraction is done becomes
    the quotient. Below is the implementation of above approach
     */
    // Function to divide a by b and
    // return floor value it
    static int divide(int dividend, int divisor) {

        // Calculate sign of divisor i.e.,
        // sign will be negative only iff
        // either one of them is negative
        // otherwise it will be positive
        int sign = ((dividend < 0) ^
                (divisor < 0)) ? -1 : 1;

        // Update both divisor and
        // dividend positive
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        // Initialize the quotient
        int quotient = 0;

        while (dividend >= divisor) {
            dividend -= divisor;
            ++quotient;
        }

        return sign * quotient;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        System.out.println(divide(a, b));

        a = 43;
        b = -8;

        System.out.println(divide(a, b));
    }
}
