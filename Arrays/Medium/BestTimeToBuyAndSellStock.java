//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
package Arrays.Medium;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        
        int max = 0;
        int min = prices[0];
        
        for(int i = 1;i<prices.length;i++) {
            if(min > prices[i]) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }
        
        return max;
    }
}
