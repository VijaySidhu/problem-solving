package com.problem.solving.algorithms.arrays;

/**
 * Created by VijaySidhu on 2/7/2018.
 */
public class ReplaceWithGreatestOnRightSide {

    /**
     * TC : O(N)
     * A tricky method is to replace all elements using one traversal of the array.
     * The idea is to start from the rightmost element, move to the left side one by one,
     * and keep track of the maximum element. Replace every element with the maximum element.
     */
    public static int[] replaceWithGreatestElementOnRightSide(int arr[]) {

        int n = arr.length;
        int greatest = arr[n - 1];
        arr[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            int temp = arr[i]; //check eack element i greater than greatest or not
            arr[i] = greatest; //replace element with greatest.
            if (temp > greatest) {
                greatest = temp; //update greatest
            }
        }

        return arr;
    }
}
