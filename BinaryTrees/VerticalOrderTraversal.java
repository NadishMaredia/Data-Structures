// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
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
        int row;
        int col;

        public Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int col = pair.col;
            int row = pair.row;

            if(!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }

            if(!map.get(col).containsKey(row)) {
                map.get(col).put(row, new PriorityQueue<>());
            }

            map.get(col).get(row).add(node.val);

            if(node.left!=null) {
                q.offer(new Pair(node.left, row + 1, col - 1));
            }
            if(node.right!=null) {
                q.offer(new Pair(node.right, row + 1, col + 1));
            }
        }

        for(TreeMap<Integer,PriorityQueue<Integer>> ys: map.values()){
           ans.add(new ArrayList<>());
            //make a list for each col
            
            for(PriorityQueue<Integer> pq : ys.values()){
                //now we are inside a row(which will contain nodes)
                while(pq.size() > 0){
                    ans.get(ans.size() - 1).add(pq.poll());
                }
            }
        }
        return ans;
    }
}
