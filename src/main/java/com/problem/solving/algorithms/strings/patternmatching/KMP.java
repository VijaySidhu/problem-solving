package com.problem.solving.algorithms.strings.patternmatching;

/*https://www.youtube.com/watch?v=OY5ZUNC6hx8
The basic idea behind KMP’s algorithm is: whenever we detect a mismatch
(after some matches), we already know some of the characters in the text
 of the next window. We take advantage of this information to avoid
 matching the characters that we know will anyway match.
 Works on Proper prefix and proper prefix
 No back tracking of text
 Time complexity
      O(M) is preprocessing time O(N) is matching time
so TC =       O(M+N) M is length of text and N is length of pattern
   Space = O(M)
 */

public class KMP {

  /*  https://www.youtube.com/watch?v=gtAPdVHCSQA&ab_channel=UnacademyComputerScience
        Preprocessing of pattern is required. We prepare integer array (LPS)
        that tell us how many characters to be skipped. We prepare
        an auxiliary array lps (Longest proper prefix) size of pattern.
        Use LPS to decide next position if mismatch

        https://www.youtube.com/watch?v=gtAPdVHCSQA&ab_channel=UnacademyComputerScience
        Match char at i and j in pattern assign 0 if mistmach if match increment and assign first index

        We start comparison of pat[j] with j = 0 with characters of current window of text.
          1. We keep matching characters txt[i] and pat[j] and keep incrementing i and j while pat[j] and txt[i] keep matching.
          2. When we see a mismatch
              *. We know that characters pat[0..j-1] match with txt[i-j…i-1] (Note that j starts with 0 and increment it only when there is a match).
              *. We also know (from above definition) that lps[j-1] is count of characters of pat[0…j-1] that are both proper prefix and suffix.
              *. From above two points, we can conclude that we do not need to match these lps[j-1] characters with txt[i-j…i-1] because we know that these characters will anyway match. Let us consider above example to understand this.
   */
  public static void main(String[] args) {
    KMP kmp = new KMP();
    kmp.search("AABA", "AABAACAADAABAABA");
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
    int j = 0;
    int i = 1;
    int lengthOfPatten = pattern.length();
    int[] lps = new int[lengthOfPatten];
    // LPS of first character is always ZERO
    lps[0] = 0;
    // Calculate lps for remaining characters in pattern.
    // Note lps of first char is ZERO so thats why we are starting i from 1
    while (i < lengthOfPatten) {
      // Compare first two characters of pattern
      if (pattern.charAt(i) == pattern.charAt(j)) {
        j++;
        lps[i] = j; // lps of i will be index previous char
        i++;
      } else {

        // If there is no match and
        if (j != 0) { // TODO understand this
          j = lps[j - 1];

        } else {
          lps[i] = j; // If length is zero then lps of next char is zero and increment next
          i++;
        }
      }
    }
    return lps;
  }


}
