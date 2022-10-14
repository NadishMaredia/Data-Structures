package BinaryTrees;

import java.util.ArrayList;

public class BoundaryTraversal {
    class Node  
    { 
        int data; 
        Node left, right; 
    
        public Node(int d)  
        { 
            data = d; 
            left = right = null; 
        } 
    }
    ArrayList <Integer> boundary(Node node)
	{
	    ArrayList <Integer> ans = new ArrayList<>();
	    if(isLeaf(node) == false) ans.add(node.data);
	    left(node, ans);
	    bottom(node, ans);
	    right(node, ans);
	    return ans;
	}
	
	void left(Node node, ArrayList <Integer> ans) {
	    Node temp = node.left;
	    while(temp != null) {
	        if(isLeaf(temp) == false) ans.add(temp.data);
	        if(temp.left != null) temp = temp.left;
	        else temp = temp.right;
	    }
	}
	
	void bottom(Node node, ArrayList <Integer> ans) {
	    if(isLeaf(node)) {
	        ans.add(node.data);
	        return;
	    }
	    
	    if (node.left != null) bottom(node.left, ans);
        if (node.right != null) bottom(node.right, ans);
	}
	
	void right(Node node, ArrayList <Integer> ans) {
	    Node temp = node.right;
	    List<Integer> lst = new ArrayList<>();
	    while(temp != null) {
	        if(isLeaf(temp) == false) lst.add(temp.data);
	        if(temp.right != null) temp = temp.right;
	        else temp = temp.left;
	    }
	    
	    for(int i = lst.size()-1;i>=0;i--) {
	        ans.add(lst.get(i));
	    }
	}
	
	
	boolean isLeaf(Node node) {
	    return node.left == null && node.right == null;
	}
}
