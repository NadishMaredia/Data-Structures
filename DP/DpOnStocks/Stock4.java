package DP.DpOnStocks;

public class Stock4 {
    public int maxProfit(int limit, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][limit+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                for(int k=0; k<=limit; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(0, 0, limit, prices, dp);
    }

    public int solve(int index, int buy, int limit, int[] prices, int[][][] dp) {

        if(index == prices.length || limit == 0) return 0;
        
        if(dp[index][buy][limit] != -1) return dp[index][buy][limit];

        int profit = 0;
        if(buy == 0) {
            // have to buy
            int pick = -prices[index] + solve(index+1, 1, limit, prices, dp);
            int notPick = 0 + solve(index+1, 0, limit, prices, dp);
            profit = Math.max(pick, notPick);
        } else {
            // have to sell
            int pick = prices[index] + solve(index+1, 0, limit - 1, prices, dp);
            int notPick = 0 + solve(index+1, 1, limit, prices, dp);
            profit = Math.max(pick, notPick);
        }

        return dp[index][buy][limit] = profit;
    }
}
