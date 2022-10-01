package DP.DpOnTwoD;

import java.util.Arrays;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1)
            return 0;

        int[][] dp = new int[r+1][c+1];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }

        return solve(r-1, c-1, obstacleGrid, dp);
    }

    public int solve(int i, int j, int[][] grid, int[][] dp) {
        if(i == 0 && j == 0) {
            return 1;
        }

        if(i < 0 || j < 0 || grid[i][j] == 1) {
            return 0;
        }

        if(dp[i][j] != -1)
            return dp[i][j];

        int up = solve(i-1, j, grid, dp);
        int down = solve(i, j-1, grid, dp);

        return dp[i][j] = up + down;
    }
}
