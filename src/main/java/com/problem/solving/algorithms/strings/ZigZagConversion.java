package com.problem.solving.algorithms.strings;

/*
Complexity Analysis
Time Complexity: O(n), where n == len(s). Each index is visited once.
Space Complexity: O(n). For the cpp implementation,O(1) if return string is not considered extra space.
 */
public class ZigZagConversion {

  public static void main(String[] args) {
    System.out.println(ZigZagConversion.convert("PAYPALISHIRING", 3));
  }

  /*
  Visit the character in same order as reading the ZigZag pattern
  line by line
  1. Char in row 0 are located at indexes k (2*numRows-2)
  2. Char in row numOfRows-1 are located at indexes(2*numRows-2)+i
    and (k+1)(2*numOfRows-2)-i.
   */
  public static String convert(String s, int numRows) {

    // If num of rows are 1 then return string
    if (numRows == 1) {
      return s;
    }

    StringBuilder ret = new StringBuilder();
    int n = s.length();
    int cycleLen = 2 * numRows - 2;

    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j + i < n; j += cycleLen) {
        ret.append(s.charAt(j + i));
        if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
          ret.append(s.charAt(j + cycleLen - i));
        }
      }
    }

    return ret.toString();
  }

}
