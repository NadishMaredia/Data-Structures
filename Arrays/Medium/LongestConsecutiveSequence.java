package Arrays.Medium;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0)
            return 0;
         
         int maxStreak = 0;
         
         HashSet<Integer> set = new HashSet<>();
         for(int i: nums) {
             set.add(i);
         }
         
         for(int i: nums) {
             if(!set.contains(i-1)) {
                 int currentNum = i;
                 int currentStreak = 1;
                 
                 while(set.contains(currentNum + 1)) {
                     currentNum++;
                     currentStreak++;
                 }
                 
                 maxStreak = Math.max(maxStreak, currentStreak);
             }
         }
         
         return maxStreak;
     }
}
