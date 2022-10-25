// https://leetcode.com/problems/remove-outermost-parentheses/description/
package Strings;

public class RemoveOutermostParanthesis {
    public String removeOuterParentheses(String s) {
        StringBuilder builder = new StringBuilder();

       int count = 0;
       int start = 0;
       for(int i = 0;i<s.length();i++) {
           if(s.charAt(i) == '(') {
               count++;
           } else {
               count--;
           }
           if(count == 0) {
               builder.append(s.substring(start + 1, i));
               start = i + 1;
           }
       }

       return builder.toString();
   }
}
