package com.problem.solving.algorithms.strings;

public class MultiplicationString {

    public static void main(String[] args) {
        System.out.println(multiply("12", "12"));

    }

    private static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //Calculate indices where digits will be
                int p1 = i + j;
                int p2 = i + j + 1;
                // calculate sum
                int sum = product + pos[p2];
                // add carries digit to p1
                pos[p1] += sum / 10;
                // add it to sum
                pos[p2] = (sum) % 10;


            }
        }
        StringBuilder res = new StringBuilder();
        for (int p : pos) {
            if (!(res.length() == 0 && p == 0)) res.append(p);//skip the zero at front
        }
        return res.length() == 0 ? "0" : res.toString();//corner case like "0","0" -> [0, 0];
    }

}

