// https://leetcode.com/problems/merge-intervals/
package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> ans = new ArrayList<>();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int starti = intervals[0][0];
        int endi = intervals[0][1];
        
        for(int i = 0;i<intervals.length;i++)
        {
            int startj = intervals[i][0];
            int endj = intervals[i][1];
            
            if(startj <= endi) {
                endi = Math.max(endi, endj);
            } else {
                ans.add(new int[] {starti, endi});
                starti = startj;
                endi = endj;
            }
        }
        ans.add(new int[]{starti, endi});
        return ans.toArray(new int[0][]);
    }
}
