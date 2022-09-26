package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve(0, candidates, target, res, new ArrayList<>());
        return res;
    }
    
    public void solve(int index, int[] candidates, int target, List<List<Integer>> res, List<Integer> output)
    {
        if(index >= candidates.length) {
            
            if(target == 0) {
                res.add(new ArrayList<>(output));
            }
            
            return;
        }
        
        if(candidates[index] <= target)
        {
            output.add(candidates[index]);
            solve(index, candidates, target - candidates[index], res, output);
            output.remove(output.size() - 1);
        }
        
        solve(index+1, candidates, target , res, output);
    }
}
