package DP.DpOnTwoD;

import java.util.Arrays;

public class NinjaTraining {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int dp[][] = new int[n][4];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return solve(n-1, 3, points, dp);
    }
    
    public static int solve(int day, int last, int points[][], int dp[][]) {
        if(day == 0) {
            int maxi = 0;
            for(int task = 0;task<=2;task++) {
                if(last != task) {
                    maxi = Math.max(maxi, points[day][task]);
                }
            }
            return dp[day][last] =  maxi;
        }
        
        if(dp[day][last] != -1) return dp[day][last];
        
        int maxi = 0;
            for(int task = 0;task<=2;task++) {
                if(last != task) {
                    maxi = Math.max(maxi, solve(day-1, task, points, dp) + points[day][task]);
                }
            }
          return dp[day][last] = maxi;
    }
}
