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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return dfs(root, 1000000001, -1000000001);
        // minimum so far between root and new values
        // maximum so far between root and new values

        // boolean state = true;
        // if (root.left != null) {
        //     if (root.left.val >= root.val) return false;
        // }
        // if (root.right != null) {
        //     if (root.right.val <= root.val) return false;
        // }
        // return isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean dfs(TreeNode node, int max, int min) {
        if (node == null) return true;
        if (node.val >= max || node.val <= min) return false;
        return dfs(node.left, node.val, min) && dfs(node.right, max, node.val);
    }
}
