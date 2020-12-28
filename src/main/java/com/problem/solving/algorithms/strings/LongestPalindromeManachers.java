package com.problem.solving.algorithms.strings;

public class LongestPalindromeManachers {
    private int mLongestPalindromeLength;
    private int mLongestPalindromeStart = -1;

    public static void main(String[] args) {
        LongestPalindromeManachers mn = new LongestPalindromeManachers();
        mn.findLongestPalindrome("ababa");
        System.out.println(mn.getLongestPalindromeLength());


    }

    public void findLongestPalindrome(String string) {
        final int strlen = string.length();
        if (strlen == 0) {
            mLongestPalindromeStart = -1;
            mLongestPalindromeLength = 0;
            return;
        }
        final int helperLength = 2 * strlen - 1;
        final int[] helper = new int[helperLength];
        helper[mLongestPalindromeStart = 0] = mLongestPalindromeLength = 1;
        int lastIndex = 0;
        int lastMax = 0;
        for (int i = 1; i < helperLength - mLongestPalindromeLength; i++) {
            final int base = i / 2;
            final int mod = i % 2;
            int radius, offset;
            if (i < lastMax) {
                radius = Math.min(helper[2 * lastIndex - i], lastMax - i);
                offset = (radius + 1 - mod) / 2;
            } else {
                offset = radius = 1 - mod;
            }
            final int offsetLimit = Math.min(base + 1, strlen - base - mod);
            while (offset < offsetLimit &&
                    string.charAt(base - offset) == string.charAt(
                            base + offset + mod)) {
                radius += 2;
                offset++;
            }
            if ((helper[i] = radius) > mLongestPalindromeLength) {
                mLongestPalindromeStart = base + mod - radius / 2;
                mLongestPalindromeLength = radius;
            }
            if ((radius += i) > lastMax) {
                lastIndex = i;
                lastMax = radius;
            }
        }
    }

    public int getLongestPalindromeLength() {
        return mLongestPalindromeLength;
    }

    public int getLongestPalindromeStart() {
        return mLongestPalindromeStart;
    }
}
