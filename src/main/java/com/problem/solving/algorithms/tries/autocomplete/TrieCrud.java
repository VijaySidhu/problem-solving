package com.problem.solving.algorithms.tries.autocomplete;

import java.util.ArrayList;
import java.util.List;

public class TrieCrud {


    // Insert word into trie
    public static void insert(String word, TrieNode root) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            // If key is not found create new node and insert in trie node
            if (!currentNode.getChildren().containsKey(ch)) {
                TrieNode trieNode = new TrieNode(word.substring(0, i + 1));
                currentNode.getChildren().put(ch, trieNode);
            }
            // Move pointer to next element
            currentNode = currentNode.getChildren().get(ch);
        }
        currentNode.setEndOfWord(true);
    }

    // Search word in Trie. Returns node if found else return null
    public static TrieNode searchInTrie(String word, TrieNode root) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            // Return false if key is missing
            if (!currentNode.getChildren().containsKey(ch)) {
                return null;
            }
            // Move pointer to next node
            currentNode = currentNode.getChildren().get(ch);
        }
        return currentNode;
    }

    // search if word exist by prefix
    public static TrieNode startsWithPrefix(String prefix, TrieNode root) {
        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character ch = prefix.charAt(i);
            if (!currentNode.getChildren().containsKey(ch)) {
                return null;
            }
            currentNode = currentNode.getChildren().get(ch);
        }
        return currentNode;
    }

    // Find all words that starts with prefix
    public List<String> findAllForPrefix(String prefix, TrieNode root) {
        TrieNode currentNode = startsWithPrefix(prefix, root);
        List<String> result = new ArrayList<>();
        findAllChildren(currentNode, result);
        return result;
    }

    // Helper method to find all children
    private void findAllChildren(TrieNode node, List<String> result) {
        if (node.isEndOfWord()) {
            result.add(node.getPrefix());
        }
        for (Character ch : node.getChildren().keySet()) {
            findAllChildren(node.getChildren().get(ch), result);
        }
    }

}
