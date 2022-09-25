//https://leetcode.com/problems/generate-parentheses/
package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        solve(0,0, ans, n, "");
        
        return ans;
    }
    
    public void solve(int open, int close, List<String> ans, int n, String s)
    {
        if(open == n && close == n) {
            ans.add(s);
            return;
        }
        
        if(open < n) {
            solve(open + 1, close, ans, n, s + "(");
        }
        
        if(close < open) {
            solve(open, close + 1, ans, n, s + ")");
        }
    }
}
