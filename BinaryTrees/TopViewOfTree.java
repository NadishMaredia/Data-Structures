// https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=top-view-of-binary-tree
package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopViewOfTree {

    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    
    static class Pair {
        Node node;
        int level;
        public Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            Pair it = q.remove();
            int hd = it.level; 
            Node temp = it.node; 
            if(map.get(hd) == null) map.put(hd, temp.data); 
            if(temp.left != null) {
                
                q.add(new Pair(temp.left, hd - 1)); 
            }
            if(temp.right != null) {
                
                q.add(new Pair(temp.right, hd + 1)); 
            }
        }
        
        for(Map.Entry<Integer, Integer> item: map.entrySet()) {
            ans.add(item.getValue());
        }
        
        return ans;
    }
}
