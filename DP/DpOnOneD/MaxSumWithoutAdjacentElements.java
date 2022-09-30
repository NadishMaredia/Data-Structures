// https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=max-sum-without-adjacents
package DP.DpOnOneD;

import java.util.Arrays;

public class MaxSumWithoutAdjacentElements {
    int findMaxSum(int arr[], int n) {
        // code here
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n-1, arr, dp);
    }
    
    int solve(int index, int arr[], int dp[]) {
        if(index < 0) return 0;
        if(index == 0) return arr[index];
        
        if(dp[index] != -1) return dp[index];
        
        int take = arr[index] + solve(index - 2, arr, dp);
        int notTake = 0 + solve(index - 1, arr, dp);
        
        return dp[index] = Math.max(take, notTake);
    }
}
