package com.problem.solving.algorithms.tries;

import java.util.*;

/*
    Write an auto complete class that returns all dictionary words
 */
public class AutoComplete {

    private Node trie;

    public static void main(String[] args) {
        AutoComplete a = new AutoComplete(new String[]{"abc", "acd", "bcd", "def", "a", "aba"});

        assert compareArrays((String[]) a.getWordsForPrefix("").toArray(new String[6]),
                new String[]{"abc", "acd", "bcd", "def", "a", "aba"}) :
                "Empty string";
        assert compareArrays((String[]) a.getWordsForPrefix("a").toArray(new String[4]),
                new String[]{"abc", "acd", "a", "aba"}) :
                "Single character prefix";
        assert compareArrays((String[]) a.getWordsForPrefix("def").toArray(new String[1]),
                new String[]{"def"}) :
                "Prefix the length of the string";
        assert compareArrays((String[]) a.getWordsForPrefix("abcd").toArray(new String[0]),
                new String[]{}) :
                "No results";
        System.out.println("Passed all test cases");
    }

    private static boolean compareArrays(String[] s1, String[] s2) {
        if (s1.length != s2.length) return false;

        Arrays.sort(s1);
        Arrays.sort(s2);

        for (int i = 0; i < s1.length; i++) {
            if (!s1[i].equals(s2[i])) return false;
        }

        return true;
    }

    public AutoComplete(String[] dict) {
        trie = new Node("");
        for (String s : dict) {
            insertWord(s);
        }
    }

    private void insertWord(String s) {
        Node curr = trie;
        for (int i = 0; i < s.length(); i++) {
            // If Char is not in map insert it
            if (!curr.children.containsKey(s.charAt(i))) {
                curr.children.put(s.charAt(i), new Node(s.substring(0, i + 1)));
            }
            curr = curr.children.get(s.charAt(i));
            if (i == s.length() - 1) {
                curr.isWord = true;
            }
        }
    }

    // Find all words in trie that starts with prefix
    public List<String> getWordsForPrefix(String pre) {
        List<String> results = new ArrayList<>();
        // Iterate to the end of prefix
        Node curr = trie;
        for (char c : pre.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return results;
            }
        }
        return results;
    }


    // Find all child words
    private void findAllChildWords(Node n, List<String> results) {
        if (n.isWord) {
            results.add(n.prefix);
        }

        for (Character c : n.children.keySet()) {
            findAllChildWords(n.children.get(c), results);
        }
    }


    // Trie Node
    private class Node {

        String prefix;

        Map<Character, Node> children;

        boolean isWord;

        public Node(String prefix) {
            this.prefix = prefix;
            this.children = new HashMap<>();
        }
    }

}
