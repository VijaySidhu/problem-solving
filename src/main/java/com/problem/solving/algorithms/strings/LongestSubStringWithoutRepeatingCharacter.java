package com.problem.solving.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

/*
Leetcode 3
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
 */
public class LongestSubStringWithoutRepeatingCharacter {

  public static void main(String[] args) {

    System.out.println(longestSubString("abcabcabcdabcdbb"));
  }

  /*
  define a mapping of the characters to its index.
  Then we can skip the characters immediately when
  we found a repeated character.
  The reason is that if s[j] have a duplicate in
  the range [i,j) with index j'
 we don't need to increase i little by little.
 We can skip all the elements in the range [i, j']
 and let i to be j' + 1 directly.
   Time complexity : O(n) Index j will iterate n times.
   Space complexity (HashMap) : O(min(m, n)). Same as the previous approach.
   */
  private static int longestSubString(String str) {
    int length = str.length();
    int ans = 0;
    int i = 0;
    Map<Character, Integer> mapOfCharToIndex = new HashMap<>();
    for (int j = 0; j < length; j++) {
      if (mapOfCharToIndex.containsKey(str.charAt(j))) {
        i = Math.max(mapOfCharToIndex.get(str.charAt(j)), i);
      }
      // Compare previous length with current and get maximum
      ans = Math.max(ans, j - i + 1);
      // Character to index mapping
      mapOfCharToIndex.put(str.charAt(j), j + 1);
    }
    return ans;
  }
}
