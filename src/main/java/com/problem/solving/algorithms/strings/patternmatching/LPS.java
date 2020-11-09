package com.problem.solving.algorithms.strings.patternmatching;

public class LPS {

  /*Time Complexity : O(n)
  Auxiliary Space : O(n)
  1. Create an array to compute LPS of size is equal to text
  2. Initialize LPS value to 0 for first char e.g lps[0] = 0;
  3. Iterate through text from first char to end of text and do following
      i. Compare char at 0th position with next char. e.g text.charAt(i)==text.charAt(j+1)
           a) If Both character matches increment indexes of characters
              and increment previous character index and assign it
              as LPS value e.g J++ lps[i]=j;
           b) If Characters doesn't match
                  i.  j is pointing at first char then set lps[i] = 0;
                  ii. if j is not at first char then check previous value of j
                        j = lps[j-1]

  */
  public static void main(String[] args) {
    LPS lps = new LPS();
    System.out.println(lps.lengthOfLPS("abcab"));
  }

  public int lengthOfLPS(String text) {
    int textLength = text.length();
    int i = 1;
    int j = 0;
    int[] lps = new int[textLength];
    // LPS of first char in text is alway ZERO
    lps[0] = 0;

    while (i < textLength) {

      // Compare char with previous char in text
      // if match increment both indexes
      if (text.charAt(j) == text.charAt(i)) {
        j++; // Increment index of previous character
        lps[i] = j; // LPS will be increment of previous char
        i++;
      }
      // If Not matching
      else {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          lps[i] = 0;
          i++;
        }
      }

    }
    int result = lps[textLength - 1];
    // since we are looking for non overlapping parts
    return (result > textLength / 2) ? textLength / 2 : result;
  }

}
