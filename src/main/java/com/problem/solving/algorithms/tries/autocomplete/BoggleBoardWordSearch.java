package com.problem.solving.algorithms.tries.autocomplete;

import java.util.*;

//https://www.programcreek.com/2014/06/leetcode-word-search-ii-java/
public class BoggleBoardWordSearch {

    /*
    Given a 2D board and a list of words from the dictionary, find all words in the board.
    Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
    or vertically neighboring. The same letter cell may not be used more than once in a word.
     */


    public static void main(String[] args) {
        Set<String> result = new HashSet<>();
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'},
        };
        findWordInBoggleBoard(board, Arrays.asList("oath", "pea", "eat", "rain"), result);
        System.out.println(result);


    }

    public static void findWordInBoggleBoard(char[][] board, List<String> words, Set<String> result) {

        // Insert all words into try
        TrieNode root = new TrieNode("");
        for (String word : words) {
            TrieCrud.insert(word, root);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, root, result);
            }
        }
    }

    private static void dfs(char[][] board, boolean[][] visited, String str, int i, int j, TrieNode trieNode, Set<String> result) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j >= n || i >= m || j < 0) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        // Append next char to string
        str = str + board[i][j];
        // Search for prefix in Trie Return if word is not in trie
        if (Objects.isNull(TrieCrud.startsWithPrefix(str, trieNode))) {
            return;
        }

        // If string is in trie add it in result list
        if (TrieCrud.searchInTrie(str, trieNode)) {
            result.add(str);
        }

        visited[i][j] = true;
        dfs(board, visited, str, i - 1, j, trieNode, result);
        dfs(board, visited, str, i + 1, j, trieNode, result);
        dfs(board, visited, str, i, j - 1, trieNode, result);
        dfs(board, visited, str, i, j + 1, trieNode, result);
        visited[i][j] = false;
    }

}
