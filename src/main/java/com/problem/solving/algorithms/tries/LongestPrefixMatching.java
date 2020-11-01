package com.problem.solving.algorithms.tries;

/**
 * Given a dictionary of words and an input string, find the longest prefix of the string which is
 * also a word in dictionary. Examples:
 * <p>
 * Let the dictionary contains the following words: {are, area, base, cat, cater, children,
 * basement}
 * <p>
 * Below are some input/output examples: -------------------------------------- Input String Output
 * -------------------------------------- caterer                 cater basemexy base child < Empty
 * >
 */
public class LongestPrefixMatching {

/**
 * https://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/
 * We build a Trie of all dictionary words.
 * Once the Trie is built, traverse through it using
 * characters of input string. If prefix matches a dictionary word,
 * store current length and look for a longer match.
 * Finally, return the longest match.
 */


}
