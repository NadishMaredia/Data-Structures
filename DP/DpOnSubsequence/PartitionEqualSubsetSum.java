// https://leetcode.com/problems/partition-equal-subset-sum/description/
package DP.DpOnSubsequence;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int i: nums) {
            sum += i;
        }

        if (sum%2==1) {
            return false;
        } else {
            int[][] dp = new int[nums.length][sum+1];
            for(int[] i: dp) {
                Arrays.fill(i, -1);
            }
            return solve(nums.length - 1, nums, sum / 2, dp);
        }

        
    }

    public boolean solve(int index, int[] nums, int target, int[][] dp) {
        if(target == 0) return true;
        if(index == 0) {
            return nums[index] == target;
        }

        if(dp[index][target] != -1) return dp[index][target]==0?false:true;

        boolean notTake = solve(index-1, nums, target, dp);
        boolean take = false;
        if(nums[index] <= target) {
            take = solve(index-1, nums, target-nums[index], dp);
            dp[index][target] = take || notTake?1:0;
        }
        
        return (take || notTake);
    }
}
