//https://leetcode.com/problems/3sum/
package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(nums);
        HashSet<String> set = new HashSet<>();
        
        int n = nums.length;
        
        for(int i = 0;i<n;i++)
        {
            int j = i + 1;
            int k = n - 1;
            
            while(j < k)
            {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    String str = nums[i]+""+nums[j]+""+nums[k];
                    if(!set.contains(str)) {
                        List<Integer> lst = new ArrayList<>();
                        lst.add(nums[i]);
                        lst.add(nums[j]);
                        lst.add(nums[k]);
                        res.add(lst);
                        
                        set.add(str);
                    }
                    
                    j++;
                    k--;
                }
                else if(nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        
        return res;
    }
}
