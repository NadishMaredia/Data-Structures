package BinaryTrees;

public class DiameterOfTree {

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
    
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        height(root, max);
        
        return max[0];
    }

    public int height(TreeNode root, int[] max) {
        if(root == null) return 0;

        int left = height(root.left, max);
        int right = height(root.right, max);

        max[0] = Math.max(max[0], left+right);

        return 1 + Math.max(left, right);
    }
}
