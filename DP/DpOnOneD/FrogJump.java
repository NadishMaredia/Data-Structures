// https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?leftPanelTab=0
package DP.DpOnOneD;

import java.util.Arrays;

public class FrogJump {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n - 1, heights, dp);
    }

    public static int solve(int index, int heights[], int dp[]) {
        if(index == 0) {
            return 0;
        }
        
        if(dp[index] != -1) {
            return dp[index];
        }
        
        int left = solve(index - 1, heights, dp) + Math.abs(heights[index] - heights[index-1]);
        int right = Integer.MAX_VALUE;
        if(index > 1)
            right = solve(index - 2, heights, dp) + Math.abs(heights[index] - heights[index-2]);
        return dp[index] = Math.min(left, right);
    }
}
