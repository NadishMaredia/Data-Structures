package BinaryTrees;

public class BalancedBinaryTree {

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

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if(root == null) return 0;

        int left = height(root.left);
        if(left == -1) return -1;
        int right = height(root.right);
        if(right == -1) return -1;

        if(Math.abs(left-right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}
