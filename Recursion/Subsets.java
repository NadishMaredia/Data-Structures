package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        solve(0, nums, res, new ArrayList<>());
        
        return res;
    }
    
    public void solve(int index, int[] nums, List<List<Integer>> res, List<Integer> output)
    {
        if(index >= nums.length) {
            res.add(new ArrayList<>(output));
            return;
        }
        
        output.add(nums[index]);
        solve(index+1, nums, res, output);
        output.remove(output.size()-1);
        
        solve(index+1, nums, res, output);
    }
}
