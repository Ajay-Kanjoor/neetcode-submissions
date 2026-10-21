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

class Solution { // DFS Recursion
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftMax = 1;
        int rightMax = 1;

        if (root.left != null) leftMax += maxDepth(root.left);
        if (root.right != null) rightMax += maxDepth(root.right);
        return Math.max(leftMax, rightMax);
    }

    // T O(n)
    // S O(n)
}
