package com.problem.solving.algorithms.tries;

/**
 * Given a dictionary of words and an input string, find the longest prefix of the string which is
 * also a word in dictionary. Examples:
 * <p>
 * Let the dictionary contains the following words: {are, area, base, cat, cater, children,
 * basement}
 * <p>
 * Below are some input/output examples: ------------------------------------
 * -- Input String Output
 * -----------------------------------
 * --- caterer                 cater basemexy base child < Empty
 * >
 */
public class LongestPrefixMatching {

    /*
    1. Implement Trie and insert all words in Trie.
    2. Perform walk on trie from root node and find deepest path from root that satisfies below conditions
        i)   It is prefix of query string q.
        ii)  Each node along the path must contain only one child element.Otherwise found path will not be common prefix among all strings
        iii) Path doesn't comprise of nodes which are marked as end of key.Otherwise path couldn't be prefix a of key which
             is shorter than itself.

    Complexity Analysis
     In the worst case query q has length m and it is equal to all n strings of the array.

     Time complexity :
           i.) Preprocessing O(S). S is number of all characters in an array. LCP query O(m).
     Space complexity :
           i.) We only used additional SS extra space for the Trie.

     */


}
