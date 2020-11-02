package com.problem.solving.algorithms.tries;

import java.util.Map;

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
   * https://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/ We build a
   * Trie of all dictionary words. Once the Trie is built, traverse through it using characters of
   * input string. If prefix matches a dictionary word, store current length and look for a longer
   * match. Finally, return the longest match.
   */


  public static void main(String[] args) {
    Trie dict = new Trie();
    dict.insertRecursive("are");
    dict.insertRecursive("area");
    dict.insertRecursive("base");
    dict.insertRecursive("cat");
    dict.insertRecursive("cater");
    dict.insertRecursive("basement");
    String input = "caterer";
    System.out.print(input + ":   ");
    System.out.println(getMatchingPrefix(dict.getRoot(), input));

    input = "basement";
    System.out.print(input + ":   ");
    System.out.println(getMatchingPrefix(dict.getRoot(), input));

    input = "are";
    System.out.print(input + ":   ");
    System.out.println(getMatchingPrefix(dict.getRoot(), input));

    input = "arex";
    System.out.print(input + ":   ");
    System.out.println(getMatchingPrefix(dict.getRoot(), input));

    input = "basemexz";
    System.out.print(input + ":   ");
    System.out.println(getMatchingPrefix(dict.getRoot(), input));

    input = "xyz";
    System.out.print(input + ":   ");
    System.out.println(getMatchingPrefix(dict.getRoot(), input));

  }

  // The main method that finds out the longest string 'input'
  public static String getMatchingPrefix(TrieNode root, String input) {
    String result = ""; // Initialize resultant string
    int length = input.length();  // Find length of the input string

    // Initialize reference to traverse through Trie
    TrieNode crawl = root;

    // Iterate through all characters of input string 'str' and traverse
    // down the Trie
    int level, prevMatch = 0;
    for (level = 0; level < length; level++) {
      // Find current character of str
      char ch = input.charAt(level);

      // HashMap of current Trie node to traverse down
      Map<Character, TrieNode> child = crawl.getChildren();

      // See if there is a Trie edge for the current character
      if (child.containsKey(ch)) {
        result += ch;          //Update result
        crawl = child.get(ch); //Update crawl to move down in Trie

        // If this is end of a word, then update prevMatch
        if (crawl.isEndOfWord()) {
          prevMatch = level + 1;
        }
      } else {
        break;
      }
    }

    // If the last processed character did not match end of a word,
    // return the previously matching prefix
    if (!crawl.isEndOfWord()) {
      return result.substring(0, prevMatch);
    } else {
      return result;
    }
  }
}
