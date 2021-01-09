package com.problem.solving.algorithms.arrays;

/*
    Given two strings s and t , write a function to determine
    if t is an anagram of s.
    Input: s = "anagram", t = "nagaram"
    Output: true
 */
public class ValidAnagram {


    // Iterate over first word and count character in table, increment counter value
    // Iterate over second word and decrement counter if it is less than zero at any point return false
    // return true
    public static boolean isAnagram(String wordOne, String wordTwo) {
        // table to count characters
        int[] table = new int[26];
        // If length is different return false
        if (wordOne.length() != wordTwo.length()) {
            return false;
        }
        // Count characters in word one and increment index
        for (int i = 0; i < wordOne.length(); i++) {
            table[wordOne.charAt(i) - 'a']++;
        }

        // Iterate on word two char by char and decrement index
        for (int i = 0; i < wordTwo.length(); i++) {
            table[wordTwo.charAt(i) - 'a']--;
            // If it goes below zero then it means it has extra character
            if (table[wordTwo.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        // At this point table should have 0 at all indexes as we decrement count in second iteration
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
