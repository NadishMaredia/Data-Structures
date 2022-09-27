// https://leetcode.com/problems/palindrome-partitioning/
package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        
        solve(s, ans, 0, new ArrayList<>());
        
        return ans;
    }
    
    public void solve(String s, List<List<String>> ans, int start, List<String> output)
    {
        if(start >= s.length()) {
            ans.add(new ArrayList<>(output));
            return;
        }
        
        for(int end = start;end<s.length();end++) 
        {
            if(isPalindrome(s, start, end))
            {
                output.add(s.substring(start, end + 1));
                solve(s, ans, end + 1, output);
                output.remove(output.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int low, int high)
    {
        while(low < high)
        {
            if(s.charAt(low++) != s.charAt(high--)) return false;
        }
        
        return true;
    }
}
