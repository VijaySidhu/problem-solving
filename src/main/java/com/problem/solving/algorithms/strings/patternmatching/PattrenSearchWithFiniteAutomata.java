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

}
