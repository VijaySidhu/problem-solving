package com.problem.solving.algorithms.arrays;

public class NQueens {

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

}
