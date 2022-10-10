// https://leetcode.com/problems/delete-operation-for-two-strings/description/
package DP.DpOnStrings;

import java.util.Arrays;

public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }

        int common = solve(word1.length()-1, word2.length()-1, word1, word2, dp);
        return (word1.length() - common) + (word2.length() - common);
    }

    public int solve(int i, int j, String word1, String word2, int[][] dp) {
        if(i < 0 || j < 0) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = 1 + solve(i-1, j-1, word1, word2, dp);
        } else {
            return dp[i][j] = Math.max(solve(i-1, j, word1, word2, dp), solve(i, j-1, word1, word2, dp));
        }
    }
}
