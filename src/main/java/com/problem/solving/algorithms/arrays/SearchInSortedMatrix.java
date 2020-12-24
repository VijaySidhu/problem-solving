package com.problem.solving.algorithms.arrays;

public class SearchInSortedMatrix {

    /*
        Use divide and conquer approach
        The simple idea is to remove a row or column in each comparison until an element is found.
        Start searching from the top-right corner of the matrix.
         There are three possible cases.
           1. The given number is greater than the current number: This will ensure, that all the elements in the current row are smaller than the given number as the pointer is already at the right-most element and the row is sorted. Thus, the entire row gets eliminated and continue the search on the next row. Here elimination means that row needs not to be searched.
           2 . The given number is smaller than the current number: This will ensure, that all the elements in the current column are greater than the given number. Thus, the entire column gets eliminated and continue the search on the previous column i.e. the column at the immediate left.
           3. The given number is equal to the current number: This will end the search.
     */

    private static void search(int[][] mat,
                               int n, int x) {

        // set indexes for top right
        int i = 0, j = n - 1;
        // element

        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                System.out.print("n Found at " +
                        i + " " + j);
                return;
            }
            if (mat[i][j] > x)
                j--;
            else // if mat[i][j] < x
                i++;
        }

        System.out.print("n Element not found");
        return; // if ( i==n || j== -1 )
    }

    public static void main(String[] args) {
        int mat[][] = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};

        search(mat, 4, 29);
    }


}
