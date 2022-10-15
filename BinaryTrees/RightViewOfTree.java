// https://leetcode.com/problems/binary-tree-right-side-view/description/
package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinaryTrees.BalancedBinaryTree.TreeNode;

public class RightViewOfTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int levelSize = q.size();

            for(int i = 0;i<levelSize;i++) {

                if(q.peek().left != null) {
                    q.offer(q.peek().left);
                }

                if(q.peek().right != null) {
                    q.offer(q.peek().right);
                }

                if(i == levelSize - 1) {
                    ans.add(q.peek().val);
                }
                q.poll();
            }
        }
        return ans;
    }
}
