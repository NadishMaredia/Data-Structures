// https://practice.geeksforgeeks.org/problems/subset-sums2234/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=subset-sums
package Recursion;

import java.util.ArrayList;

public class SubsetSum {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        solve(arr, 0, res, 0);
        
        return res;
    }
    
    void solve(ArrayList<Integer> arr, int index, ArrayList<Integer> res, int sum)
    {
        if(index >= arr.size())
        {
            res.add(sum);
            return;
        }
        
        // not include
        solve(arr, index + 1, res, sum);
        
        // include
        solve(arr, index + 1, res, sum + arr.get(index));
    }
}
