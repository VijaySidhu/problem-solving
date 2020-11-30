package com.problem.solving.algorithms.tries;

public class LongestCommonPrefix {

    static final int ALPHABET_SIZE = 26;

    static TrieNode rootNode;
    static int indexs;

    public static void main(String[] args) {

        String arr[] = {"geeksforgeeks", "geeks",
                "geek", "geezer"};
        int n = arr.length;

        String ans = commonPrefix(arr, n);

        if (ans.length() != 0)
            System.out.println("The longest common prefix is " + ans);
        else
            System.out.println("There is no common prefix");
    }

    // A Function to construct trie
    static void constructTrie(String arr[], int n) {
        for (int i = 0; i < n; i++)
            insert(arr[i]);
        return;
    }

    // A Function that returns the longest common prefix
    // from the array of strings
    static String commonPrefix(String arr[], int n) {
        rootNode = new TrieNode();
        constructTrie(arr, n);

        // Perform a walk on the trie
        return walkTrie();
    }

    // Perform walk on trie and return the longest common prefix string
    static String walkTrie() {
        TrieNode pCrawl = rootNode;
        indexs = 0;
        String prefix = "";
        while (countChildren(pCrawl) == 1 && pCrawl.isLeaf == false) {
            pCrawl = pCrawl.childrens[indexs];
            prefix = prefix + (char) ('a' + indexs);
        }
        return prefix;
    }

    static void insert(String key) {
        int length = key.length();
        int index;
        TrieNode pCrawl = rootNode;

        for (int level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.childrens[index] == null) {
                pCrawl.childrens[index] = new TrieNode();
            }
            pCrawl = pCrawl.childrens[index];
        }
        pCrawl.isLeaf = true;
    }

    static int countChildren(TrieNode node) {
        int count = 0;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (node.childrens[i] != null) {
                count++;
                indexs = i;
            }
        }
        return (count);
    }

    static class TrieNode {
        TrieNode[] childrens = new TrieNode[ALPHABET_SIZE];
        boolean isLeaf;

        public TrieNode() {
            isLeaf = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                childrens[i] = null;
            }
        }
    }

}
