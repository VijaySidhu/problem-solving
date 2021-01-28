package com.problem.solving.algorithms.strings.patternmatching;
/*
input:                             output: (functionName)

GET/user                           getAllUsers
GET/user/<userID>                  getUserId
GET/user/<userID>/permissions      getUserIdPermissions
DELETE/user/<userID>               deleteUser

log:
GET/user/123 -> getUserId
Get/user/123abc/permissions  ->getUserIdPermissions
 */


import com.problem.solving.algorithms.tries.autocomplete.TrieCrud;

import java.util.Map;

public class LogMatc {


    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;
        String prefix;
        String suffix;
    }

    public class Operations {
        public void insert(TrieNode root, String word) {
            TrieNode current = root;
            // Iteration over the word
            for (int i = 0; i < word.length(); i++) {

                // If map doesn't contain char put it in map and also put prefix and suffix in map
                // ELSE
                // Increment current node pointer to find char in map
            }

        }

        public TrieNode search(String logWord) {

            return null;
        }

        public TrieNode findChildren(String logWord) {
            TrieNode trieNode = this.search(logWord);
            ///
            return null;
        }
    }

}

