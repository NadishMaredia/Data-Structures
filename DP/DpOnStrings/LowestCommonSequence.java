// https://leetcode.com/problems/longest-common-subsequence/description/
package DP.DpOnStrings;

import java.util.Arrays;

public class LowestCommonSequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] i: dp)
            Arrays.fill(i, -1);
        return solve(n-1, m-1, text1, text2, dp);
    }

    public int solve(int i, int j, String text1, String text2, int[][] dp) {
        if(i < 0 || j < 0) {
            return 0;
        }
        if(dp[i][j] != - 1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + solve(i-1, j-1, text1, text2, dp);
        }
        else
        {
            return dp[i][j] = Math.max(solve(i-1, j, text1, text2, dp), solve(i, j-1, text1, text2, dp));
        }
    }
}
