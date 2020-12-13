package com.problem.solving.algorithms.arrays;

public class NQueens {


/* Java program to solve N Queen Problem
using backtracking */

    static int N = 4;

    /* ld is an array where its indices indicate row-col+N-1
    (N-1) is for shifting the difference to store negative
    indices */
    static int[] ld = new int[30];

    /* rd is an array where its indices indicate row+col
    and used to check whether a queen can be placed on
    right diagonal or not*/
    static int[] rd = new int[30];

    /*column array where its indices indicates column and
    used to check whether a queen can be placed in that
        row or not*/
    static int[] cl = new int[30];

    /*
    The idea is to place queens one by one in different columns, starting from the leftmost column.
    When we place a queen in a column, we check for clashes with already placed queens.
    In the current column, if we find a row for which there is no clash, we mark this row and
    column as part of the solution. If we do not find such a row due to clashes then we backtrack
    and return false.
    1. Start in left most column
    2. If all queens are placed return true
    3. Try all rows in current column
        Do the following for every tried row

        a) If the queen can be placed safely in this row then mark this [row,col] as part of solution and recursivly check
        if placing queen here leads to a solution
        b) If placing the queen in [row, column] leads to a solution then return true.
        c) If placing queen doesn't lead to a solution then unmark this [row, column] (Backtrack) and go to
                step (a) to try other rows.
    4) If all rows have been tried and nothing worked, return false to trigger backtracking.

     */

    static boolean solveNQueens(int[][] board, int col) {
        /* base case: If all queens are placed
            then return true */
        if (col >= N) {
            return true;
        }

        /* Consider this column and try placing
    this queen in all rows one by one */
        for (int i = 0; i < N; i++) {
            // Check if the queen can be placed on board[i][col]
            // Check for left , right and diagonal indices
            if ((ld[i - col + N - 1] != 1 &&
                    rd[i + col] != 1) && cl[i] != 1) {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;
                // Update left right and diagonal indices with 1.Indicates queen is placed
                ld[i - col + N - 1] =
                        rd[i + col] = cl[i] = 1;

                /* recur to place rest of the queens */
                if (solveNQueens(board, col + 1))
                    return true;

                   /* If placing queen in board[i][col]
            doesn't lead to a solution, then
            remove queen from board[i][col] */
                board[i][col] = 0; // BACKTRACK
                ld[i - col + N - 1] =
                        rd[i + col] = cl[i] = 0;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        solveNQ();
    }

    static boolean solveNQ() {
        int board[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        if (solveNQueens(board, 0) == false) {
            System.out.printf("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    static void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.printf(" %d ", board[i][j]);
            System.out.printf("\n");
        }
    }


}
