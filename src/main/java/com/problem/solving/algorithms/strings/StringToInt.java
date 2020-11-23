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
    */

    public static void main(String[] args) {
        System.out.println(parseInt("123", 10));
    }

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
