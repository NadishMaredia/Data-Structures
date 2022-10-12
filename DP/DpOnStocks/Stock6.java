package DP.DpOnStocks;

import java.util.Arrays;

public class Stock6 {
    public int maxProfit(int[] prices, int fee) {
        
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }

        return solve(0, 0, n, prices, fee, dp);
    }

    public int solve(int index, int mode, int n, int[] prices, int fee, int[][] dp) {
        if(index == n) return 0;

        if(dp[index][mode] != -1) return dp[index][mode];

        int profit = 0;
        if(mode == 0) {
            int pick = -prices[index] + solve(index+1, 1, n, prices, fee, dp);
            int notPick = 0 + solve(index+1, 0, n, prices, fee, dp);
            profit = Math.max(pick, notPick);
        }
        if(mode == 1) {
            int pick = prices[index] - fee + solve(index+1, 0, n, prices, fee, dp);
            int notPick = 0 + solve(index+1, 1, n, prices, fee, dp);
            profit = Math.max(pick, notPick);
        }
        return dp[index][mode] = profit;
    }
}
