package com.problem.solving.algorithms.tries;

public class Trie {

  private final TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  /**
   * Insert character into trie Search recursive O(Key_Lengh) Memory requirements
   * O(ALPHABET_SIZE*key_length*N)
   */
  public void insertRecursive(TrieNode current, String word, int index) {

    if (index == word.length()) {
      current.setEndOfWord(true);
      return;
    }

    char currentChar = word.charAt(index);

    // Check if current char is in trie
    TrieNode node = current.getChildren().get(currentChar);

    // If current character is not in trie create node
    if (node == null) {
      node = new TrieNode();
      node.getChildren().put(currentChar, node);
    }

    // If current character is in trie repeat the abpve steps
    insertRecursive(node, word, index + 1);
  }

  /**
   * Search recursive O(Key_Lengh) Memory requirements O(ALPHABET_SIZE*key_length*N)
   */
  private boolean searchRecursive(TrieNode current, String word, int index) {

    if (index == word.length()) {
      return current.isEndOfWord();
    }
    char ch = word.charAt(index);
    TrieNode node = current.getChildren().get(ch);
    if (node == null) {
      return false;
    }
    return searchRecursive(node, word, index + 1);
  }

  /*
  Key may not be there in trie. Delete operation should not modify trie.
  Key present as unique key (no part of key contains another key (prefix), nor the key itself is prefix of another key in trie). Delete all the nodes.
  Key is prefix key of another long key in trie. Unmark the leaf node.
  Key present in trie, having atleast one other key as prefix key. Delete nodes from end of key until first leaf node of longest prefix key.
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
