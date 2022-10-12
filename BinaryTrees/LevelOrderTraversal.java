// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int levelSize = q.size();

            for(int i = 0;i<levelSize;i++) {
                if(q.peek().left != null) {
                    q.add(q.peek().left);
                }
                if(q.peek().right != null) {
                    q.add(q.peek().right);
                }
                list.add(q.poll().val);
            }
            ans.add(list);
        }
        
        return ans;
    }
}
