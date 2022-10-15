// https://www.interviewbit.com/problems/path-to-given-node/
package BinaryTrees;

import java.util.ArrayList;

public class PathToGivenNode {
    class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) {
             val = x;
             left=null;
             right=null;
            }
        }
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        solve(A, B, ans);
        return ans;
    }
    
    public boolean solve(TreeNode A, int B, ArrayList<Integer> ans) {
        if(A == null) return false;
        
        ans.add(A.val);
        if(A.val == B) return true;
        if(solve(A.left, B, ans) || solve(A.right, B, ans)) return true;
        ans.remove(ans.size()-1);
        return false;
    }
}
