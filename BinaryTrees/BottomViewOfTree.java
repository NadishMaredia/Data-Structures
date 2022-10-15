package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BottomViewOfTree {
    class Node {
        int data;
        int hd;
        Node left, right;

        public Node(int key) {
            data = key;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<Node>();
        root.hd = 0;
        q.add(root);
        
        Map<Integer, Integer> map = new TreeMap<>();
        
        while(!q.isEmpty()) {
            Node temp = q.remove();
            int hd = temp.hd;
            int data = temp.data;
            map.put(hd, data);
            
            if(temp.left != null) {
                temp.left.hd = hd - 1;
                q.add(temp.left);
            }
            
            
            if(temp.right != null) {
                temp.right.hd = hd + 1;
                q.add(temp.right);
            }
            
        }
        
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            ans.add(entry.getValue()); 
        }
        return ans;
    }
}
