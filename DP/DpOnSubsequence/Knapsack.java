// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
public class Knapsack {
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
        int[][] dp = new int[n][W+1];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }
        return solve(n-1, W, wt, val, dp);
    } 
    
    static int solve(int index, int w, int wt[], int val[], int[][] dp) 
    {
        if(index == 0) {
            if(wt[0] <= w) {
                return val[0];
            }
            return 0;
        }
        
        if(dp[index][w] != -1) return dp[index][w];
        
        int notTake = solve(index-1, w, wt, val, dp);
        int take = 0;
        if(wt[index] <= w) {
            take = val[index] + solve(index-1, w-wt[index], wt, val, dp);
        }
        
        return dp[index][w] = Math.max(notTake, take);
    }
}
