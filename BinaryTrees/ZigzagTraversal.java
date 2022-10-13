// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true; 

        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> lst = new ArrayList<>();

            for(int i = 0;i<levelSize;i++) {
                if(q.peek().left != null) {
                    q.add(q.peek().left);
                }

                if(q.peek().right != null) {
                    q.add(q.peek().right);
                }

                if(flag) {
                    lst.add(q.poll().val);
                } else {
                    lst.add(0, q.poll().val);
                }
            }
            flag = !flag;
            ans.add(lst);
        }

        return ans;
    }
}
