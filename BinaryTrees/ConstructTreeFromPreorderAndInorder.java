// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
package BinaryTrees;

import java.util.HashMap;

public class ConstructTreeFromPreorderAndInorder {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        
        TreeNode root = solve(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
        
        return root;
    }

    public TreeNode solve(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int ele = map.get(root.val);
        int numLeft = ele - inStart;

        root.left = solve(preorder, preStart + 1, preStart + numLeft, inorder, inStart, ele - 1, map);
        root.right = solve(preorder, preStart + numLeft + 1, preEnd, inorder, ele + 1, inEnd, map);
        return root;
    }
}
