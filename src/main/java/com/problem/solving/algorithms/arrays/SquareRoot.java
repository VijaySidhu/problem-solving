package com.problem.solving.algorithms.arrays;

public class SquareRoot {

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int left = 1;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If mid is square root return it
            if (mid == x / mid) {
                return mid;
            }
            // If mid is greater than decrement right
            else if (mid > x / mid) {
                right = mid - 1;
            }
            // If mid is less than increment left
            else if (mid < x / mid) {
                left = mid + 1;
            }
        }

        return right;
    }
}
