package com.problem.solving.algorithms.strings.patternmatching;

import java.util.HashMap;
import java.util.Map;

/*
*
* Leetcode 290
* Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
* */
public class WordPattern {

    private boolean isFollowSamePattern(String s,String str){
        if(s.length()!=str.length()){
            return false;
        }
        Map patternIndexMap = new HashMap<>();
        String[] words = str.split(" ");
        for(int i = 0 ;i<s.length();i++){
            char c = s.charAt(i);
            String w = words[i];
            if(!patternIndexMap.containsKey(c)){
            patternIndexMap.put(c,i);}
            if(!patternIndexMap.containsKey(w)) {
                patternIndexMap.put(w, i);
            }
            if(patternIndexMap.get(c)!=patternIndexMap.get(w)){
                return false;
            }
        }
        return true;
    }
}
