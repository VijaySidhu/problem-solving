package com.problem.solving.algorithms.arrays;

/*
Implement next permutation which rearranges numbers into the lexicographically next greater
permutation of numbers.
https://leetcode.com/problems/next-permutation/solution/
 */
public class NextPermutations {

    /*
    Time complexity : O(n). In worst case, only two scans of the whole array are needed.
    Space complexity: O(1). No extra space is used. In place replacements are done.
    i. First observe that for any given sequence that is in descending order, no next larger permutation is possible.
    ii. We need to find first pair of successive numbers a[i] and a[i-1], from the right which satisfy a[i]>a[i-1]
    iii. Now, no rearrangements to the right of a[i-1] can create permutation since subarray is in
    descending order. Thus we need to rearrange the numbers to the right of a[i-i] including itself
    iv.  we need to replace the number a[i-1]a[i−1] with the number which is just larger than itself among the numbers lying to its right section, say a[j].
     */

    public static void nextPermutation(int[] nums) {

        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);

    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
