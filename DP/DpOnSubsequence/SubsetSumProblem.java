// https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
package DP.DpOnSubsequence;

import java.util.Arrays;

public class SubsetSumProblem {
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int[][] dp = new int[N][sum+1];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return solve(N-1, arr, sum, dp);
    }
    
    static Boolean solve(int index, int arr[], int sum, int[][] dp) {
        
        if(sum == 0) return true;
        if(index == 0) return arr[index] == sum;
        
        if(dp[index][sum] != -1) return dp[index][sum]==0?false:true;;
        
        Boolean notTake = solve(index-1, arr, sum, dp);
        Boolean Take = false;
        if(arr[index] <= sum) {
            Take = solve(index-1, arr, sum-arr[index], dp);
            dp[index][sum] = notTake||Take?1:0;
        }
        
        return (notTake || Take);
    }
}
