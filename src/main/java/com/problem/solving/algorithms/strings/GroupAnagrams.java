package com.problem.solving.algorithms.strings;

import java.util.*;

/*
Two strings are anagram if their sorted strings are equal
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] str = new String[]{"cat", "dog", "tac", "god", "act"};
        groupAnagrams(str).stream().forEach(l -> l.stream().forEach(e -> {
            System.out.print(e + " ");
        }));
        System.out.println("");
        System.out.println("Below is Efficient Approach with TC O(nk) SC O(nk)");
        groupAnagramsWithCharCount(str).stream().forEach(l -> l.stream().forEach(e -> {
            System.out.print(e + " ");
        }));
    }

    /*
    Approach 1 not efficient. Efficient approach is below
    Complexity Analysis
    Time Complexity: O(N K log K), where N is the length of strs, and K is the maximum length of a string in strs. The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in O(K log K) time.
    Space Complexity: O(N K), the total information content stored in ans.
    Maintain a map ans : {String -> List} where each key \text{K}K is a sorted string, and each value is the list of strings from the initial input that when sorted, are equal to \text{K}K.
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        // Sort all strings in array
        Arrays.sort(strs);
        for (String s : strs) {
            char[] characters = s.toCharArray();
            // Sort all character of string
            Arrays.sort(characters);
            // Build key from sorted characters
            String key = String.valueOf(characters);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);

        }
        return new ArrayList(map.values());
    }

    // Approach 2
    /*
      1. We can transform each string s into a character count, count, consiting of 26 non negative integers representing the number of a's
         b's.. etc. We use these counts as the basis for our hash map.
      2. In Java, the hashable representation of our count will be a string delimited with '#' characters.
         For example, abbccc will be #1#2#3#0#0#0...#0 where there are 26 entries total.
         TC : O(nk) where n is length of strs and k is the maximum length of string in sts. Counting each string is linear in the size of the string and we count every string
         SC : O(nk) total information content stores in ans.
     */
    public static List<List<String>> groupAnagramsWithCharCount(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

}
