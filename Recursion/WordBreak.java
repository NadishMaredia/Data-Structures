// https://leetcode.com/problems/word-break/description/
package Recursion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return recur(0, s, new HashSet<>(wordDict), new Boolean[s.length()]);
    }

    public boolean recur(int start, String s, Set<String> word, Boolean[] memo) {
        if(start == s.length()) {
            return true;
        }

        if(memo[start] != null) {
            return memo[start];
        }

        for(int end = start + 1;end<=s.length();end++) {
            if(word.contains(s.substring(start, end)) && recur(end, s, word, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}
