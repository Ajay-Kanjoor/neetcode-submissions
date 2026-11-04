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
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode root){
        if (root == null) return (new int[]{1, 0});
        int[] res = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[1] = 1 + Math.max(left[1], right[1]);
        res[0] = (left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1) ? 1 : 0;
        return res;
    }

    // DFS
}
