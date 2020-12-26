package com.problem.solving.algorithms.tries.autocomplete;

public class WordSearch {

    public WordSearch(String[] dict) {
        TrieCrud tc = new TrieCrud();
        TrieNode root = new TrieNode("");
        // Insert all words
        for (String word : dict) {
            tc.insert(word, root);
        }
        // Check if word is in Trie
        System.out.println(tc.searchInTrie("abc", root) != null ? true : false);
        System.out.println(tc.searchInTrie("bd", root) != null ? true : false);
        System.out.println(tc.searchInTrie("bsd", root) != null ? true : false);
        System.out.println(tc.searchInTrie("ab", root) != null ? true : false);
        System.out.println(tc.startsWithPrefix("cat", root));
        tc.findAllForPrefix("cat", root).stream().forEach(f -> {
            System.out.println(f);
        });


    }

    public static void main(String[] args) {
        WordSearch a = new WordSearch(new String[]{"abc", "bd", "cater", "cat", "catering"});
    }

}
