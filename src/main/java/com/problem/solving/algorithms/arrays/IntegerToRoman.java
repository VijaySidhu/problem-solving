package com.problem.solving.algorithms.arrays;

public class IntegerToRoman {

    static final int[] values = new int[]{100, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static final String[] numerals = new String[]{"M", "CM", "D", "CD", "C", "XC",
            "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) throws Exception {
        System.out.println(integerToRoman(49));

    }

    public static String integerToRoman(int value) throws IllegalAccessException {
        if (value > 3999 || value < 1) throw new IllegalAccessException();
        StringBuilder numeral = new StringBuilder();
        int i = 0;
        while (value > 0) {
            if (value - values[i] >= 0) {
                numeral.append(numerals[i]);
                value = value - values[i];

            } else {
                i++;
            }

        }
        return numeral.toString();
    }


}
