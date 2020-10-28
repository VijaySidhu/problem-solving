package com.problem.solving.algorithms.strings;

import java.util.ArrayList;
import java.util.List;
//   Time Complexity: O(n)
//   Auxiliary Space: O(1)

public class MissingCharPanagramMake {

  // Returns true if the string
  // is pangram else false
  public static List<Character> checkPangram(String str) {
    // Create a hash table to mark the
    // characters present in the string
    // By default all the elements of
    // mark would be false.
    boolean[] mark = new boolean[26];
    List<Character> characterList = new ArrayList<>();

    // For indexing in mark[]
    int index = 0;

    // Traverse all characters
    for (int i = 0; i < str.length(); i++) {
      // If uppercase character, subtract 'A'
      // to find index.
      if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
        index = str.charAt(i) - 'A';
      }

      // If lowercase character, subtract 'a'
      // to find index.
      else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
        index = str.charAt(i) - 'a';
      }

      // If this character is other than english
      // lowercase and uppercase characters.
      else {
        continue;
      }
      mark[index] = true;
    }

    // Track missing character
    for (int i = 0; i <= 25; i++) {
      if (mark[i] == false) {
        characterList.add((char) (i + 'a'));
      }
    }
    return characterList;
  }

  public static void main(String[] args) {
    String nonPanagram = " Quick brown fox jumps over the lay do";
    List<Character> missingCharacters = checkPangram(nonPanagram);
    for (Character ch : missingCharacters) {
      System.out.println(ch);
    }
  }
}
