// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
package DP.DpOnSubsequence;

import java.util.Arrays;

public class MinStepsToMakeStringPalindrome {
    public int minInsertions(String s) {
        String reverse = "";
        for(int i = s.length()-1;i>=0;i--) {
            reverse += s.charAt(i);
        }

        int[][] dp = new int[s.length()][s.length()];
        for(int[] i: dp)
            Arrays.fill(i, -1);
        
        int lps = solve(s.length()-1, reverse.length() - 1, s, reverse, dp);

        return s.length() - lps;
    }

    public int solve(int i, int j, String s, String reverse, int[][] dp) {
        if(i < 0 || j < 0) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(s.charAt(i) == reverse.charAt(j)) {
            return dp[i][j] = 1 + solve(i - 1, j - 1, s, reverse, dp);
        } else {
            return dp[i][j] = Math.max(solve(i-1, j, s, reverse, dp), solve(i, j-1, s, reverse, dp));
        }
    }
}
