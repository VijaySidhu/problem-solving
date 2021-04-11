package com.problem.solving.algorithms.arrays;

import java.util.*;

public class LetterCombinationOfPhoneNumber {

    public static void main(String[] args) {

        // Funciton call
        List<String> result = letterCombinations("23");
        for (String s : result) {
            System.out.println(s);
        }

    }


    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        Map<Character, String> letters = new HashMap<>();
        letters.put('2', "abc");
        letters.put('3', "def");
        letters.put('4', "ghi");
        letters.put('5', "jkl");
        letters.put('6', "mno");
        letters.put('7', "pqrs");
        letters.put('8', "tuv");
        letters.put('9', "wxyz");
        String phoneDigits;
        // If the input is empty, immediately return an empty answer array
        if (digits.length() == 0) {
            return combinations;
        }

        // Initiate backtracking with an empty path and starting index of 0
        backtrack(0, new StringBuilder(), digits, combinations, letters);
        return combinations;
    }


    private static void backtrack(int index, StringBuilder path, String phoneDigits, List<String> combinations, Map<Character, String> letters) {
        // If the path is the same length as digits, we have a complete combination
        if (path.length() == phoneDigits.length()) {
            combinations.add(path.toString());
            return; // Backtrack
        }

        // Get the letters that the current digit maps to, and loop through them
        String possibleLetters = letters.get(phoneDigits.charAt(index));
        for (char letter : possibleLetters.toCharArray()) {
            // Add the letter to our current path
            path.append(letter);
            // Move on to the next digit
            backtrack(index + 1, path, phoneDigits, combinations, letters);
            // Backtrack by removing the letter before moving onto the next
            path.deleteCharAt(path.length() - 1);
        }
    }
}
