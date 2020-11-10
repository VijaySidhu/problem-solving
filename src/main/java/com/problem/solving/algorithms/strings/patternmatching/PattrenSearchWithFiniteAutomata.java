package com.problem.solving.algorithms.strings.patternmatching;

/*
   https://www.geeksforgeeks.org/finite-automata-algorithm-for-pattern-searching/?ref=lbp
   https://www.geeksforgeeks.org/pattern-searching-set-5-efficient-constructtion-of-finite-automata/?ref=lbp
    Input: text = "ahishers"
       arr[] = {"he", "she", "hers", "his"}

Output:
   Word his appears from 1 to 3
   Word he appears from 4 to 5
   Word she appears from 3 to 5
   Word hers appears from 4 to 7
https://www.geeksforgeeks.org/pattern-searching-set-5-efficient-constructtion-of-finite-automata/?ref=lbp
   First build Trie of given words
    https://www.youtube.com/watch?v=ecQmot8262k&ab_channel=MUNIRATOPIA
1. Build finite automata of pattern (LPS). Total number of states in FA is length pattern
   How to build FA state table ?
     i.)   Fill all the entries in first row with ZERO except first index [0][0]. Set it to 1.
     ii.)  Initialize LPS as ZERO.
     iii.) Do the following for rows at index=1 to M (Pattern length)
              1) Copy the entries from the row at index equal to lps.
              2) update entry for pattern[i] character to i+1.
              3) Update lps=TF[lps][pat[i]] where TF is 2D array being constructed
 */
public class PattrenSearchWithFiniteAutomata {

  static int NUMBER_OF_CHARACTERS = 256;

  public static void main(String[] args) {
    char txt[] = "GEEKS FOR GEEKS".toCharArray();
    char pat[] = "GEEKS".toCharArray();
    searchWithFA(pat, txt);
  }

  static int[][] computeStateMachine(char[] pat) {
    int i, lps = 0, x;
    int lengthOfPattern = pat.length;
    int[][] finiteAutomata = new int[lengthOfPattern + 1][NUMBER_OF_CHARACTERS];

    // Fill all entries in first row with 0 except first ( set 1)
    for (int j = 0; j < NUMBER_OF_CHARACTERS; j++) {
      finiteAutomata[0][j] = 0;
    }

    // Set first entry to 1. Represent initial state
    finiteAutomata[0][pat[0]] = 1;

    // Fill all the entries in other rows
    for (i = 1; i < lengthOfPattern; i++) {
      // Copy values from row at index lps
      for (x = 0; x < NUMBER_OF_CHARACTERS; x++) {
        finiteAutomata[i][x] = finiteAutomata[lps][x];
      }

      // update entry corresponding to character
      finiteAutomata[i][pat[i]] = i + 1;

      // update lps for next row to be filled
      if (i < lengthOfPattern) {
        lps = finiteAutomata[lps][pat[i]];
      }
    }
    return finiteAutomata;
  }

  static void searchWithFA(char[] pat, char[] txt) {
    int lengthOfPattern = pat.length;
    int lengthOfText = txt.length;
    int[][] fa = computeStateMachine(pat);
    int j = 0;
    // Process text over FA
    for (int i = 0; i < lengthOfText; i++) {
      j = fa[j][txt[i]];
      if (j == lengthOfPattern) {
        System.out.println("Pattern found at " + (i - lengthOfPattern + 1));
      }
    }
  }

}
