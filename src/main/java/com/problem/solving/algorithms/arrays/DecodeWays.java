package com.problem.solving.algorithms.arrays;

/**

 * Given a string s containing only digits, return the number of ways to decode it. leetcode 91
 * we are using an array dp to save the results for future. As we move ahead character by character of the given string, we look
 * back only two steps. For calculating dp[i] we need to know dp[i-1] and dp[i-2] only.
 * Thus, we can easily cut down our O(N) space requirement to O(1) by using only two variables to store the last two results.
 */
public class DecodeWays {

    public static void main(String[] args) {
        String str = "226";
        System.out.println(decodeWaysP(str));
    }

    public static int decodeWays(String str) {
        // An array that will store max number of ways to decode string upto index
        int[] dp = new int[str.length() + 1];
        // number of ways to decode string at 0 is 1
        dp[0] = 1;
        // number of ways to decode string at 1 depends upon it if it is 0 then 0 if it is not zero then 1
        dp[1] = str.charAt(0) == '0' ? 0 : 1;
        // Iterate through strings
        for (int i = 2; i <= str.length(); i++) {
            // Get digit for current character
            int oneDigit = Integer.valueOf(str.substring(i - 1, i));
            // Get digit for second charater
            int twoDigits = Integer.valueOf(str.substring(i - 2, i));
            // combine those and check if these has mappings
            // Check for single digit
            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            // Check for double digits
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[str.length()];
    }

    private static int decodeWaysP(String str) {
        int[] dp = new int[str.length() + 1];

        dp[0] = 1;
        dp[1] = str.charAt(0) == '0' ? 0 : 1;

        //
        for (int i = 2; i <= str.length(); i++) {

            int oneDigit = Integer.valueOf(str.substring(i - 1, i));
            int twoDigit = Integer.valueOf(str.substring(i - 2, i));

            if (oneDigit >= 1) {
                dp[i] = dp[i] + dp[i - 1];
            }
            if (twoDigit <= 26 && twoDigit > 9) {
                dp[i] = dp[i] + dp[i - 2];
            }

        }
        return dp[str.length()];
    }

}
