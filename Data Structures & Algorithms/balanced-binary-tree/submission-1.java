/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = (root.left != null) ? dfs(root.left) : 0;
        int rightHeight = (root.right != null) ? dfs(root.right) : 0;
        // System.out.println(leftHeight + " " + rightHeight);
        if (Math.abs(leftHeight - rightHeight) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = (root.left != null) ? dfs(root.left) : 0;
        int rightHeight = (root.right != null) ? dfs(root.right) : 0;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
