// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
package DP.DpOnStocks;

import java.util.Arrays;

public class Stock2 {
    public int maxProfit(int[] prices) {
        
        int[][] dp = new int[prices.length][2];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }
        return solve(0, 0, prices, dp);
    }

    public int solve(int index, int buy, int[] prices, int[][] dp) {

        if(index == prices.length) return 0;
        
        if(dp[index][buy] != -1) return dp[index][buy];

        int profit = 0;
        if(buy == 0) {
            // have to buy
            int pick = -prices[index] + solve(index+1, 1, prices, dp);
            int notPick = 0 + solve(index+1, 0, prices, dp);
            profit = Math.max(pick, notPick);
        } else {
            // have to sell
            int pick = prices[index] + solve(index+1, 0, prices, dp);
            int notPick = 0 + solve(index+1, 1, prices, dp);
            profit = Math.max(pick, notPick);
        }

        return dp[index][buy] = profit;
    }
}
