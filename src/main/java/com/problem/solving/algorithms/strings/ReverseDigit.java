package com.problem.solving.algorithms.strings;

public class ReverseDigit {

  public static void main(String[] args) {
    System.out.println(reverse(79867));
  }
  /*
    It can be done similar to reversing a string
    1. Repeatedly pop last digit of string and append it to back of rev
    2. print rev
   */

  public static int reverse(int x) {
    int rev = 0;
    while (x != 0) {
      int pop = x % 10;
      x = x / 10;
      rev = rev * 10 + pop;
    }
    return rev;
  }

}
