package com.problem.solving.algorithms.tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode_NotUsed {

  private Map<Character, TrieNode_NotUsed> children;

  private boolean isEndOfWord;

  public TrieNode_NotUsed() {
    children = new HashMap<>();
    isEndOfWord = false;
  }

  public Map<Character, TrieNode_NotUsed> getChildren() {
    return children;
  }

  public void setChildren(
          Map<Character, TrieNode_NotUsed> children) {
    this.children = children;
  }

  public boolean isEndOfWord() {
    return isEndOfWord;
  }

  public void setEndOfWord(boolean endOfWord) {
    isEndOfWord = endOfWord;
  }
}
