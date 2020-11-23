package com.problem.solving.algorithms.strings;

import org.omg.PortableInterceptor.INACTIVE;

public class StringToInt {
   /*
   TC = O(N)
   SP = O(1)
   Steps ::
          1. Discard all the whitespaces at the begining of the string.
          2. There could be an optional sign of numeric value +/-. It
             should be noted that the integer is positive by default if there
             is no sign present and there could be at most one sign character.
          3. Build the result string using above algorithm until there exists a non
             whitespace character that is number 0-9.Simultaneously, check
             for overflow/underflow conditions at each step

      example : Numerical value is decimal value represented as base 10 in number system, each digit can be expressed as multiples
      of powers of 10.

      Example - "142" can repseneted as  "142" can be represented as 1 * (10^2) + 4 * (10^1) + 2 * (10^0)1∗(102)+4∗(101)+2∗(100)


    */

    public static void main(String[] args) {
        System.out.println(atoi("123"));
        System.out.println(parseInt("123", 10));
    }

    // atoi
    public static int atoi(String s) {
        int i = 0;
        int result = 0;
        int sign = 1;
        // Check String length
        if (s.length() == 0) {
            throw new NumberFormatException(s);
        }
        // Discard all whitespaces in the beginning
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        // Check for sign
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '+' ? 1 : -1;
        }

        // Build result check overflow and underflow condition
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (s.charAt(i++) - '0');

        }
        return result * sign;
    }

    // Java Implementation
    public static int parseInt(String s, int radix) throws NumberFormatException {

        if (s == null) {
            throw new NumberFormatException("null");
        }

        if (radix < Character.MIN_RADIX) {
            throw new NumberFormatException("radix " + radix +
                    " less than Character.MIN_RADIX");
        }

        if (radix > Character.MAX_RADIX) {
            throw new NumberFormatException("radix " + radix +
                    " greater than Character.MAX_RADIX");
        }

        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    throw new NumberFormatException(s);

                if (len == 1) // Cannot have lone "+" or "-"
                    throw new NumberFormatException(s);
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++), radix);
                if (digit < 0) {
                    throw new NumberFormatException(s);
                }
                if (result < multmin) {
                    throw new NumberFormatException(s);
                }
                result *= radix;
                if (result < limit + digit) {
                    throw new NumberFormatException(s);
                }
                result -= digit;
            }
        } else {
            throw new NumberFormatException(s);
        }
        return negative ? result : -result;
    }
}
