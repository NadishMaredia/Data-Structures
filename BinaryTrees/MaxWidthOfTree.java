package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfTree {
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
    class Pair {
        TreeNode node;
        int num;
        public Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()) {
            int levelSize = q.size();
            int first=0, last=0;
            for(int i = 0;i<levelSize;i++) {
                int curId = q.peek().num;
                TreeNode node = q.peek().node;
                q.poll();

                if(i == 0) first = curId;
                if(i == levelSize - 1) last = curId;
                
                if(node.left != null) {
                    q.offer(new Pair(node.left, 2*curId+1));
                }
                if(node.right != null) {
                    q.offer(new Pair(node.right, 2*curId+2));
                }
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}
