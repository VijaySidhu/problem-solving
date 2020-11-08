package com.problem.solving.algorithms.strings.patternmatching;

/*
The basic idea behind KMP’s algorithm is: whenever we detect a mismatch
(after some matches), we already know some of the characters in the text
 of the next window. We take advantage of this information to avoid
 matching the characters that we know will anyway match.
 Works on Proper prefix and proper prefix
 No back tracking of text
 Time complexity O(M+N) M is length of text and N is length of pattern
 */

public class KMP {

  /*
        Preprocessing of pattern is required. We prepare integer array
        that tell us how many characters to be skipped. We prepare
        an auxiliary array lps (Longest proper prefix) size of pattern.
        Use LPS to decide next position if mismatch
        if char from pattern and char from text is matching increment
        index in pattern and char
        Find prefix and suffix and in case of mismatch skip prefix suffix(Refer to LPS)
        https://www.youtube.com/watch?v=gtAPdVHCSQA&ab_channel=UnacademyComputerScience
        Match char at i and j in pattern assign 0 if mistmach if match increment and assign first index
   */
  public static void main(String[] args) {
    KMP kmp = new KMP();
    kmp.search("ABABCABAB", "ABABDABACDABABCABAB");
  }

  public void search(String pattern, String text) {
    // Length of pattern
    int m = pattern.length();
    // Length of text
    int n = text.length();
    // Create LPS that will hold longest prefix suffix values for pattern
    int i = 0;
    int j = 0;
    int[] lps = computeLPS(pattern);
    while (i < n) {
      if (pattern.charAt(j) == text.charAt(i)) {
        i++;
        j++;
      }
      // Pattern traverse complete
      if (j == m) {
        System.out.println("Found pattern at index" + (i - j));
        j = lps[j - 1];
      }
      // If not matching refer lps table and change indexes accordingly
      // To skip prefix suffix
      else if (i < n && pattern.charAt(j) != text.charAt(i)) {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          i = i + 1;
        }
      }
    }
  }

  private int[] computeLPS(String pattern) {
    int len = 0;
    int i = 1;
    int lengthOfPatten = pattern.length();
    int[] lps = new int[lengthOfPatten];
    // LPS of first character is always ZERO
    lps[0] = 0;
    // Calculate lps for remaining characters in pattern.
    // Note lps of first char is ZERO so thats why we are starting i from 1
    while (i < lengthOfPatten) {
      // Compare first two characters of pattern
      if (pattern.charAt(i) == pattern.charAt(len)) {
        len++;
        lps[i] = len; // lps of i will be index previous char
        i++;
      } else {

        if (len != 0) { // TODO understand this
          len = lps[len - 1];

        } else {
          lps[i] = len; // If length is zero then lps of next char is zero and increment next
          i++;
        }
      }
    }
    return lps;
  }


}
