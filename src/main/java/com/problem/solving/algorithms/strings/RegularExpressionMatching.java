package com.problem.solving.algorithms.strings;

//  Regular Expression Matching
/*
Given an input string (s) and a pattern (p), implement regular expression matching with support
for '.' and '*' where:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".GM
*/
public class RegularExpressionMatching {

    /*
    Case 1: If The char is *
              i. We can ignore * char and move to next char in the pattern
              ii.'*' char matches with one or more char in Text. Here we will move to next char in the
                  string.


    Case 2: The character is ?
             i. We can ignore current char in text and move to next char in the pattern and text.

    Case 3: The character is not wild card
             i. If current character in Text matches with current character in pattern, we move to next char
             in the pattern and text.If they do not match, wildcard pattern and text do not match.

     */

    static boolean match(char[] txt, char[] pat, int n, int m) {

        // If Pattern and Text is empty return true
        // m is length of pattern and n is length of text
        if (m == 0) {
            return (n == 0);
        }
        // Initalize Markers
        int i = 0, j = 0, index_txt = -1, index_pat = -1;

        while (i < n) {

            // characters in text and pattern are matching increment index
            if (j < m && txt[i] == pat[j]) {
                i++;
                j++;
            } else if (j < m && pat[j] == '.') {
                i++;
                j++;
            } else if (j < m && pat[j] == '*') {
                index_txt = i;
                index_pat = j;
                j++;
            } else if (index_pat != -1) {
                j = index_pat + 1;
                i = index_txt + 1;
                index_txt++;
            } else {
                return false;
            }

        }
        while (j < m && pat[j] == '*') {
            j++;
        }

        // Final Check
        if (j == m) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        char str[] = "baaabab".toCharArray();
        char pattern[] = "*****ba*****ab".toCharArray();
        // char pattern[] = "ba*****ab";
        // char pattern[] = "ba*ab";
        // char pattern[] = "a*ab";

        if (match(str, pattern, str.length,
                pattern.length))
            System.out.println("Yes");
        else
            System.out.println("No");

        char pattern2[] = "a*****ab".toCharArray();
        if (match(str, pattern2, str.length,
                pattern2.length))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

