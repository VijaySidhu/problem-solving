package com.problem.solving.algorithms.tries;

import java.util.*;

public class WordSearch {

    public WordSearch(String[] dict) {

        TrieOperations trieOperations = new TrieOperations();
        // Insert all words
        for (String word : dict) {
            trieOperations.insertWord(word);
        }
        // Check if word is in Trie
        System.out.println(trieOperations.searchInTrie("abc"));
        System.out.println(trieOperations.searchInTrie("bd"));
        System.out.println(trieOperations.searchInTrie("bsd"));
        System.out.println(trieOperations.searchInTrie("ab"));
        System.out.println(trieOperations.startsWithPrefix("cat"));

    }

    public static void main(String[] args) {
        WordSearch a = new WordSearch(new String[]{"abc", "bd", "cater", "cat", "catering"});
    }


    class TrieOperations {
        TrieNode root;

        public TrieOperations() {
            root = new TrieNode("");
        }

        // Insert
        public void insertWord(String word) {
            TrieNode current = root;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                Character ch = word.charAt(i);
                // If key is not in trie insert it
                if (!current.getChildren().containsKey(ch)) {
                    TrieNode trieNode = new TrieNode(word.substring(0, i + 1));
                    current.getChildren().put(ch, trieNode);
                }
                // Move current pointer to next node if key is in trie already
                current = current.getChildren().get(ch);
            }
            // Set end of word to true after word iteration
            current.isEndOfWord = true;
        }

        // Search
        public boolean searchInTrie(String word) {
            TrieNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                if (!currentNode.getChildren().containsKey(ch)) {
                    return false;
                }
                // Move pointer to next node
                currentNode = currentNode.children.get(ch);
            }
            if (currentNode.isEndOfWord) {
                return true;
            }
            return false;
        }

        // Return true if there is word in trie that starts with prefix
        public boolean startsWithPrefix(String prefix) {
            TrieNode currentNode = root;
            for (int i = 0; i < prefix.length(); i++) {
                Character ch = prefix.charAt(i);
                if (!currentNode.getChildren().containsKey(ch)) {
                    return false;
                }
                currentNode = currentNode.children.get(ch);
            }
            // Put all the word that starts with prefix in list
            List<String> results = new ArrayList<>();
            findAllChildWords(currentNode, results);
            return true;
        }

        void findAllChildWords(TrieNode node, List<String> results) {
            if (node.isEndOfWord) {
                results.add(node.prefix);
            }
            for (Character c : node.children.keySet()) {
                findAllChildWords(node.children.get(c), results);
            }
        }


    }

    class TrieNode {
        private Map<Character, TrieNode> children;
        private String prefix;
        private boolean isEndOfWord;

        public TrieNode(String prefix) {
            children = new HashMap<>();
            this.prefix = prefix;
            this.isEndOfWord = false;
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }

        public String getPrefix() {
            return prefix;
        }
    }

}
