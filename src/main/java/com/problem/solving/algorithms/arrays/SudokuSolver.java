package com.problem.solving.algorithms.arrays;

/*
    Write a program to solve a Sudoku puzzle by filling the empty cells.
     A sudoku solution must satisfy all of the following rules:
        Each of the digits 1-9 must occur exactly once in each row.
        Each of the digits 1-9 must occur exactly once in each column.
        Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
    The '.' character indicates empty cells.
    TC : (9!)^9
    let's discuss the number of operations needed : (9!)^9
 . Let's consider one row, i.e. not more than 9 cells to fill. There are not more than 9
   possibilities for the first number to put, not more than 9X8 for the second one, not more than 9 X 8
   In total that results in not more than 9!9! possibilities for a just one row, that means not more than (9!)^9
 */
public class SudokuSolver {

    /*
    Now everything is ready to write down the backtrack function backtrack(row = 0, col = 0).

            1. Start from the upper left cell row = 0, col = 0. Proceed till the first free cell.

            2. Iterate over the numbers from 1 to 9 and try to put each number d in the (row, col) cell.

                If number d is not yet in the current row, column and box :
                    Place the d in a (row, col) cell.
                    Write down that d is now present in the current row, column and box.
                    If we're on the last cell row == 8, col == 8 :
                    That means that we've solved the sudoku.
                    Else
                    Proceed to place further numbers.
                    Backtrack if the solution is not yet here : remove the last number from the (row, col) cell.
     */
    // box size
    int n = 3;
    // row size
    int N = n * n;

    int[][] rows = new int[N][N + 1];
    int[][] columns = new int[N][N + 1];
    int[][] subBoxes = new int[N][N + 1];

    char[][] board;

    boolean sudokuSolved = false;

    public boolean couldPlace(int d, int row, int col) {
        /*
        Check if one could place a number d in (row, col) cell
        */
        // enumerate sub-boxes
        int idx = (row / n) * n + col / n;
        return rows[row][d] + columns[col][d] + subBoxes[idx][d] == 0;
    }

    public void placeNumber(int d, int row, int col) {
    /*
    Place a number d in (row, col) cell
    */
        int idx = (row / n) * n + col / n;

        rows[row][d]++;
        columns[col][d]++;
        subBoxes[idx][d]++;
        board[row][col] = (char) (d + '0');
    }

    public void removeNumber(int d, int row, int col) {
    /*
    Remove a number which didn't lead to a solution
    */
        int idx = (row / n) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        subBoxes[idx][d]--;
        board[row][col] = '.';
    }

    public void placeNextNumbers(int row, int col) {
    /*
    Call backtrack function in recursion
    to continue to place numbers
    till the moment we have a solution
    */
        // if we're in the last cell
        // that means we have the solution
        if ((col == N - 1) && (row == N - 1)) {
            sudokuSolved = true;
        }
        // if not yet
        else {
            // if we're in the end of the row
            // go to the next row
            if (col == N - 1) backtrack(row + 1, 0);
                // go to the next column
            else backtrack(row, col + 1);
        }
    }

    public void backtrack(int row, int col) {
        /*
        Backtracking
        */
        // if the cell is empty
        if (board[row][col] == '.') {
            // iterate over all numbers from 1 to 9
            for (int d = 1; d < 10; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    // if sudoku is solved, there is no need to backtrack
                    // since the single unique solution is promised
                    if (!sudokuSolved) removeNumber(d, row, col);
                }
            }
        } else placeNextNumbers(row, col);
    }

    public void solveSudoku(char[][] board) {
        this.board = board;

        // init rows, columns and boxes
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        sudokuSolver.solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
