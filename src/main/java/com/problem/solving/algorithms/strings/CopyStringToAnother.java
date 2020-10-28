package com.problem.solving.algorithms.strings;

public class CopyStringToAnother {

  public static void copy(char[] s1, char[] s2, int index) {
    // If end return
    if (index == s1.length - 1) {
      return;
    }
    s2[index] = s1[index];
    // copy each character to another string
    copy(s1, s2, index + 1);
  }

  public static void main(String[] args) {
    char[] s1 = "GEEKS".toCharArray();
    char[] s2 = new char[s1.length];
    int index = 0;
    copy(s1, s2, index);
    System.out.println(String.valueOf(s2));
  }

}
