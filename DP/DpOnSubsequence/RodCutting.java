// https://practice.geeksforgeeks.org/problems/rod-cutting0840/1
package DP.DpOnSubsequence;

import java.util.Arrays;

public class RodCutting {
    public int cutRod(int price[], int n) {
        //code here
        int[][] dp = new int[n][n+1];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }
        return solve(n-1, price, n, dp);
    }
    
    public int solve(int index, int price[], int n, int dp[][]) {
        if(index == 0) {
            return n * price[0];
        }
        if(dp[index][n] != -1) return dp[index][n];
        int notTake = 0 + solve(index-1, price, n, dp);
        int take = Integer.MIN_VALUE;
        int rodlength = index + 1;
        if(rodlength <= n) {
            take = price[index] + solve(index, price, n - rodlength, dp);
        }
        
        return dp[index][n] = Math.max(notTake, take);
    }
}
