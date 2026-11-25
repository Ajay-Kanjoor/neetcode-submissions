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
    private int dfs(TreeNode node, int localMax) {
        if (node == null) return 0;
        if (node.val >= localMax)
            return 1 + dfs(node.left, node.val) + dfs(node.right, node.val);
        return dfs(node.left, localMax) + dfs(node.right, localMax);
    }
    public int goodNodes(TreeNode root) {
        return dfs(root, -101);
    }
}
