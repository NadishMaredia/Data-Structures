package DP.DpOnOneD;

import java.util.Arrays;

public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        int first = robHouse(0, n - 2, nums, dp);
        
        Arrays.fill(dp, -1);
        int second = robHouse(1, n-1, nums, dp);
        
        return Math.max(first, second);
    }

    public int robHouse(int low, int high, int[] nums, int[] dp) {
        
        if(low == high) return nums[high];
        if(high < low) return 0;
        
        if(dp[high] != -1) return dp[high];
        
        int notPick = 0 + robHouse(low, high-1, nums, dp);
        int Pick = nums[high] + robHouse(low, high-2, nums, dp);
        
        return dp[high] = Math.max(notPick, Pick);
    }
}
