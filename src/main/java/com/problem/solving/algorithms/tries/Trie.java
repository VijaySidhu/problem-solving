package com.problem.solving.algorithms.tries;

public class Trie {

  private final TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public TrieNode getRoot() {
    return root;
  }

  /**
   * Iterative implementation of insert into trie
   */
  public void insert(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode node = current.getChildren().get(ch);
      if (node == null) {
        node = new TrieNode();
        current.getChildren().put(ch, node);
      }
      current = node;
    }
    //mark the current nodes endOfWord as true
    current.setEndOfWord(true);
  }

  /**
   * Recursive implementation of insert into trie
   */
  public void insertRecursive(String word) {
    insertRecursive(root, word, 0);
  }

  private void insertRecursive(TrieNode current, String word, int index) {
    if (index == word.length()) {
      //if end of word is reached then mark endOfWord as true on current node
      current.setEndOfWord(true);
      return;
    }
    char ch = word.charAt(index);
    TrieNode node = current.getChildren().get(ch);

    //if node does not exists in map then create one and put it into map
    if (node == null) {
      node = new TrieNode();
      current.getChildren().put(ch, node);
    }
    insertRecursive(node, word, index + 1);
  }

  /**
   * Iterative implementation of search into trie.
   */
  public boolean search(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      TrieNode node = current.getChildren().get(ch);
      //if node does not exist for given char then return false
      if (node == null) {
        return false;
      }
      current = node;
    }
    //return true of current's endOfWord is true else return false.
    return current.isEndOfWord();
  }

  /**
   * Recursive implementation of search into trie.
   */
  public boolean searchRecursive(String word) {
    return searchRecursive(root, word, 0);
  }

  private boolean searchRecursive(TrieNode current, String word, int index) {
    if (index == word.length()) {
      //return true of current's endOfWord is true else return false.
      return current.isEndOfWord();
    }
    char ch = word.charAt(index);
    TrieNode node = current.getChildren().get(ch);
    //if node does not exist for given char then return false
    if (node == null) {
      return false;
    }
    return searchRecursive(node, word, index + 1);
  }

  /**
   * Delete word from trie.
   */
  public void delete(String word) {
    delete(root, word, 0);
  }

  /**
   * Returns true if parent should delete the mapping
   */
  private boolean delete(TrieNode current, String word, int index) {
    if (index == word.length()) {
      //when end of word is reached only delete if currrent.endOfWord is true.
      if (!current.isEndOfWord()) {
        return false;
      }
      current.setEndOfWord(false);
      //if current has no other mapping then return true
      return current.getChildren().size() == 0;
    }
    char ch = word.charAt(index);
    TrieNode node = current.getChildren().get(ch);
    if (node == null) {
      return false;
    }
    boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

    //if true is returned then delete the mapping of character and trienode reference from map.
    if (shouldDeleteCurrentNode) {
      current.getChildren().remove(ch);
      //return true if no mappings are left in the map.
      return current.getChildren().size() == 0;
    }
    return false;
  }

}
