// https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=stickler-theif-
package DP.DpOnOneD;

import java.util.Arrays;

public class SticklerThief {
    public int FindMaxSum(int arr[], int n)
    {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n-1, arr, dp);
    }
    
    public int solve(int index, int arr[], int dp[]) {
        if(index == 0) {
            return arr[0];
        }
        if(index < 0) return 0;
        if(dp[index] != -1) return dp[index];
        int take = arr[index] + solve(index - 2, arr, dp);
        int notTake = 0 + solve(index - 1, arr, dp);
        
        return dp[index] = Math.max(take, notTake);
    }
}
