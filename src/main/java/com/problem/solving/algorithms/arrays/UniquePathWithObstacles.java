package com.problem.solving.algorithms.arrays;
// Leetcode 63
public class UniquePathWithObstacles {

    /*
        1. If the first cell i.e. obstacleGrid[0,0] contains 1, this means there is an obstacle in the first cell.
           Hence the robot won't be able to make any move and we would return the number of ways as 0.
        2. Otherwise, if obstacleGrid[0,0] has a 0 originally we set it to 1 and move ahead.
        3. Iterate the first row. If a cell originally contains a 1, this means the current cell has an obstacle and
           shouldn't contribute to any path.
           Hence, set the value of that cell to 0. Otherwise, set it to the value of previous cell
           i.e. obstacleGrid[i,j] = obstacleGrid[i,j-1]
        4. Iterate the first column. If a cell originally contains a 1, this means the current cell has an obstacle and shouldn't
           contribute to any path. Hence, set the value of that cell to 0.
           Otherwise, set it to the value of previous cell i.e. obstacleGrid[i,j] = obstacleGrid[i-1,j]
        5. Now, iterate through the array starting from cell obstacleGrid[1,1]. If a cell originally doesn't contain any obstacle
           then the number of ways of reaching
           that cell would be the sum of number of ways of reaching the cell above it and number of ways of reaching the cell to
           the left of it.
             obstacleGrid[i,j] = obstacleGrid[i-1,j] + obstacleGrid[i,j-1]
        6. If a cell contains an obstacle set it to 0 and continue. This is done to make sure it doesn't contribute to any other path.
      TC O(M*N)
      SC O(1)
     */
    public static int uniquePathsWithObstacles(int[][] obstaclesGrid) {

        int rows = obstaclesGrid.length;
        int cols = obstaclesGrid[0].length;
        // If starting cell has an obstacle, then simply return as there would be
        if (obstaclesGrid[0][0] == 1) {
            return 0;
        }
        // number of ways to reach starting cell is 0
        obstaclesGrid[0][0] = 1;
        // Filling the values for first the column. If cell is not obstacle and upper cell is 1 then assign 1 else 0
        for (int r = 1; r < rows; r++) {
            obstaclesGrid[r][0] = (obstaclesGrid[r][0] == 0 && obstaclesGrid[r - 1][0] == 1) ? 1 : 0;
        }
        // Fill first row if previous cell is and current cell is not obstacle set 1 else 0
        for (int c = 1; c < cols; c++) {
            obstaclesGrid[0][c] = (obstaclesGrid[0][c] == 0 && obstaclesGrid[0][c - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1), fill up the values
        // Number of ways of reaching cell[i][j] = cell[i-1][j] +cell[i][j-1];
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstaclesGrid[i][j] == 0) {
                    // e.g
                    obstaclesGrid[i][j] = obstaclesGrid[i - 1][j] + obstaclesGrid[i][j - 1];
                } else {
                    obstaclesGrid[i][j] = 0;
                }
            }
        }
        return obstaclesGrid[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
