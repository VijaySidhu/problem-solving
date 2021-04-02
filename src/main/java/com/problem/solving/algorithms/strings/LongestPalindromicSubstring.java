package com.problem.solving.algorithms.strings;

/* Leetcode 5
Given a string s, find the longest palindromic substring in s.
You may assume that the maximum length of s is 1000.
O(n*n) time using only constant space.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String res = longestPalindrome("babad");
        System.out.println(res);
    }

    /*
      we first initialize the one and two letters palindromes, and
      work our way up finding all three letters palindromes,
      and so on...
      We observe that a palindrome mirrors around its center.
      Therefore, a palindrome can be expanded from its center,
      and there are only 2n - 1 such centers. Why 2n-1 ? palindrome can be in between two letters
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        // Boundaries of final substring from where we will return result and we will adjust these boundaries while we expand around center
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // Case 1 handle middle char e.g "racecar" compare e with e matches then compare c with c mathces and so on..
            int len1 = expandAroundCenter(s, i, i);
            // Case 2 where every char has match e.g "aabbaa" compare bb then aa and so on
            int len2 = expandAroundCenter(s, i, i + 1);
            // We are looking for longest palindrome so take max length
            int len = Math.max(len1, len2);
            // If len is greater than boundary of substring means we found new length so adjust boundaries ( Set new MAX)
            // We found new palindromic subtring which is larger than previous one set new boundaries
            if (len > end - start) {
                start = i - (len - 1) / 2; // i is middle of string take left side
                end = i + len / 2; // take right side for end
            }
        }
        return s.substring(start, end + 1);
    }

    /* e.g
           s =  ababa

     */
    private static int expandAroundCenter(String s, int left, int right) {
        if (s == null || left > right) {
            return 0;
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
