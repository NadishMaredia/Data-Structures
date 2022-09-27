//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneLetterCombination {
    public List<String> letterCombinations(String digits) {
        
        if(digits.length() == 0)
            return new ArrayList<>();
        
        List<String> res = new ArrayList<>();
        
        String[] mapping = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        solve(digits, mapping, res, new StringBuilder(), 0);
        
        return res;
    }
    
    public void solve(String digits, String[] mapping, List<String> res, StringBuilder st, int index) 
    {
        if(index >= digits.length()) {
            res.add(st.toString());
            return;
        }
        
        int value = digits.charAt(index) - '0';
        String elements = mapping[value];
        
        for(int i = 0;i<elements.length();i++)
        {
            st.append(elements.charAt(i));
            solve(digits, mapping, res, st, index+1);
            st.deleteCharAt(st.length()-1);
        }
    }
}
