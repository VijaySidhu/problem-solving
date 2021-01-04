package com.problem.solving.algorithms.arrays;

public class FormStringShortWay {

    public static void main(String[] args) {
        String source = "xyz";
        String target = "xzyxz";
        System.out.println(shortestWay(source, target));

    }

    // Worst case O(n+m) source and target
    // O(n)
    public static int shortestWay(String source, String target) {
        int i = 0; // for source string
        int j = 0; // for target string
        int min = 0; // this is our answer
        int prev = 0; // to store the previous index of j

        while (j < target.length()) {

            if (source.charAt(i) == target.charAt(j)) {
                i++; //increment i
                j++; //increment j
            } else {
                i++; //if it does not match then just increment i to find the next match
            }

            if (i >= source.length() || j >= target.length()) {

                //we Store the previous value of j, so that if j did not move, then we did not find the jth character in the
                // original string and we should return -1
                if (prev == j) {
                    return -1;
                }

                min++; //increment min as we have exhausted the source string
                i = 0; // reset i to 0 so that we can start searching in the original string again
                prev = j; // assign prev to j to check for the condition when j did not move
            }
        }

        return min; //return the ans
    }
}
