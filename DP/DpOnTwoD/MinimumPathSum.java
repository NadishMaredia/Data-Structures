package DP.DpOnTwoD;

import java.util.Arrays;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][] dp = new int[r][c];
        for(int[] row: dp)
            Arrays.fill(row, -1);

        return solve(r-1, c-1, grid, dp);
    }

    public int solve(int i, int j, int[][] grid, int[][] dp) {
        if(i == 0 && j == 0) {
            return grid[0][0];
        }

        if(i < 0 || j < 0) return (int)Math.pow(10,9);

        if(dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + solve(i-1, j, grid, dp);
        int left = grid[i][j] + solve(i, j-1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }
}
