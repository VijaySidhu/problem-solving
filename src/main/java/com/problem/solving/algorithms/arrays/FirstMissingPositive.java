package com.problem.solving.algorithms.arrays;

public class FirstMissingPositive {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 0};
        System.out.println(firstMissingPositive(arr));
    }

    /*
        1. Check if 1 is present in array if not return 1
        2. if nums = [1] the answer is 2
        3. Replace negative numbers, zeros and numbers larger than n by 1s.
        4. Walk along array. Change the sign of a-th element if you meet number a. Be careful with duplicates
           do sign change only once.Use index 0 to save an information about presence of number n since index n is not available.
        5. Walk again along the array. Return the index of the first positive element.
        6. If nums[0] > 0 return n.
        7. If on the previous step you didn't find the positive element in nums, that means that the answer is n + 1.

     Time Complexity: O(n) since we do here is four walks along the array of length N
     Space Complxity: O(1) since this is constant space solution

     */
    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // Base case.
        int contains = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] == 1) {
                contains++;
                break;
            }

        if (contains == 0)
            return 1;

        // nums = [1]
        if (n == 1)
            return 2;

        // Replace negative numbers, zeros,
        // and numbers larger than n by 1s.
        // After this convertion nums will contain
        // only positive numbers.
        for (int i = 0; i < n; i++)
            if ((nums[i] <= 0) || (nums[i] > n))
                nums[i] = 1;

        // Use index as a hash key and number sign as a presence detector.
        // For example, if nums[1] is negative that means that number `1`
        // is present in the array.
        // If nums[2] is positive - number 2 is missing.
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            // If you meet number a in the array - change the sign of a-th element.
            // Be careful with duplicates : do it only once.
            if (a == n)
                nums[0] = -Math.abs(nums[0]);
            else
                nums[a] = -Math.abs(nums[a]);
        }

        // Now the index of the first positive number
        // is equal to first missing positive.
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }

        if (nums[0] > 0)
            return n;

        return n + 1;
    }

}
