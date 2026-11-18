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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if (p == null || q == null || root == null) return null;
        // if (p.val == q.val) return p;

        TreeNode node = root;
        while (node != null){
            if (p.val <= node.val && q.val >= node.val) return node;
            if (p.val >= node.val && q.val <= node.val) return node;
            if (p.val < node.val && q.val < node.val) node = node.left;
            if (p.val > node.val && q.val > node.val) node = node.right;
        }
        return new TreeNode();

    }
}
