package Recursion;

import java.util.ArrayList;

public class RatInMaze {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        
        int[][] vis = new int[n][n];
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                vis[i][j] = 0;
            }
        }
        
        if(m[0][0] == 0) return ans;
        
        solve(m, vis, n, 0, 0, ans, "");
        
        return ans;
    }
    
    public static void solve(int[][] m, int[][] vis, int n, int i, int j, ArrayList<String> ans, String str)
    {
        if(i == n - 1 && j == n - 1) {
            ans.add(str);
            return;
        }
        
        //downward
        if(i + 1 < n && vis[i+1][j] == 0 && m[i+1][j] != 0) {
            vis[i][j] = 1;
            solve(m, vis, n, i+1, j, ans, str + "D");
            vis[i][j] = 0;
        }
        
        //upward
        if(i - 1 >= 0 && vis[i-1][j] == 0 && m[i-1][j] != 0) {
            vis[i][j] = 1;
            solve(m, vis, n, i-1, j, ans, str + "U");
            vis[i][j] = 0;
        }
        
        //left
        if(j - 1 >= 0 && vis[i][j-1] == 0 && m[i][j-1] != 0) {
            vis[i][j] = 1;
            solve(m, vis, n, i, j-1, ans, str + "L");
            vis[i][j] = 0;
        }
        
        //right
        if(j + 1 < n && vis[i][j+1] == 0 && m[i][j+1] != 0) {
            vis[i][j] = 1;
            solve(m, vis, n, i, j+1, ans, str + "R");
            vis[i][j] = 0;
        }
    }
}
