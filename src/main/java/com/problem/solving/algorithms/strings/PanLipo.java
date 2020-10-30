package com.problem.solving.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * If all the letters of the alphabet are present then its a pangram If only one letter is omitted
 * then it’s a pangrammatic lipogram otherwise it can be just a lipogram. Efficient Approach: An
 * efficient approach will be instead of iterating through all the letters of the alphabet we can
 * maintain a hashed array or map to store the count of occurrences of each letter of alphabet in
 * the input string. Initially count of all the letters will be initialized to zero. We will start
 * traversing the string and increment the count of characters. Once we have completed traversing
 * the string then we will iterate over the map or hashed array to look for how many characters have
 * count as zero.
 */
public class PanLipo {

  public static void main(String[] args) {
    String s;
    char[] str = "a quick brown fox jumps over the lazy do".toLowerCase().toCharArray();
    Map<Integer, Integer> map = new HashMap<>();
    for (Character character : str) {
      // If we have character increment count
      if (map.containsKey(character - 'a')) {
        int count = map.get(character - 'a');
        count = count + 1;
        map.put(character - 'a', count);
      } else {
        // Character is not in map put in map
        map.put(character - 'a', 1);
      }
    }
    // Stream over map and see if any char has count zero
    int counter = 0;
    for (int i = 0; i < 26; i++) {
      if (map.containsKey(i) == false) {
        counter++;
      }
    }
    if (counter == 1) {
      System.out.println("LIPPO");
    }
  }
}
