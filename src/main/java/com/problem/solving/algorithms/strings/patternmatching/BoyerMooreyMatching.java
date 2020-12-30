package com.problem.solving.algorithms.strings.patternmatching;

/*In case of mismatch algorithm calculates shift index of pattern  two cases

    Case 1 : If there is mismatch, It finds an index of last occurence
             of mismatch character in pattern. If mismatch char exists in
             pattern.It shifts pattern in such way that char in pattern
             aligns with character in text. In below example A mismatches with
             G. We will look last occurence of A in pattern which exists
                        NM M M
                   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
              e.g  G C A A T G C C T A T   G  T  G  A C  C
                   T A T G T G

              We aligned char A by shifting
                       NM M M
                   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
              e.g  G C A A T G C C T A T   G  T  G  A C  C
                       T A T G T G
    Case 2: If character doesn't exist in pattern. We will shift pattern
            past the mismatching character e.g below

                                NM
                   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
              e.g  G C A A T G C C T A T   G  T  G  A C  C
                       T A T G T G

                   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
              e.g  G C A A T G C C T A T   G  T  G  A C  C
                                   T A T   G T G

 */
public class BoyerMooreyMatching {

  /*
   How to build bad character heuristic ?
   1. Initialize bad char array with -1 (NUMBER_OF_CHARS)
   2. Fill the last occurrence of character in bad char array.
  */
  private static final int NO_CHARS = 256;

  // Preprocessing , build bad character heuristic
  static void badCharHeuristic(char[] str, int pattLength, int badChar[]) {

    // Initialize bad character array with -1
    for (int i = 0; i < NO_CHARS; i++) {
      badChar[i] = -1;
    }
    // Fill the actual value of last occurrence of character
    for (int i = 0; i < pattLength; i++) {
      badChar[(int) str[i]] = i;
    }
  }

  static void search(char[] text, char[] pattern) {
    int patternLength = pattern.length;
    int textLength = text.length;
    // Create bad char array
    int[] badChar = new int[NO_CHARS];
    // Fill badChar Array. m is length of pattern
    badCharHeuristic(text, patternLength, badChar);
    int shift = 0;
    int numberOfShifts = textLength - patternLength;
    while (shift <= (numberOfShifts)) {
      // Pointer that points to last char of pattern we will keep decrementing this in case of char match
      int j = patternLength - 1;

      // If last char of pattern matches with aligned char then shift pattern pointer to left
      while (j >= 0 && pattern[j] == text[shift + j]) {
        j--;
      }
      // If pattern traverse is finished then it means we found pattern match index
      if (j < 0) {
        System.out.println("Pattern occurs at shift " + shift);
        shift = shift + ((shift + patternLength < textLength) ? patternLength - badChar[text[
                shift + patternLength]] : 1);

      }
      // find index to shift pattern refers to badChar table
      else {
        shift = shift + (max(1, j - badChar[text[shift + j]]));
      }
    }

  }

  public static void main(String[] args) {
    char[] str = "ABAAABCD".toCharArray();
    char[] pttrn = "ABC".toCharArray();
    search(str, pttrn);
  }

  //A utility function to get maximum of two integers
  static int max(int a, int b) {
    return (a > b) ? a : b;
  }
}
