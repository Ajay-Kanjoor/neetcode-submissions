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

class Solution { // Recursion
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) 
            return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) 
            return lowestCommonAncestor(root.right, p, q);
        return root;

        // if (Math.max(p.val, q.val) < root.val) 
        //     return lowestCommonAncestor(root.left, p, q);
        // if (Math.min(p.val, q.val) > root.val) 
        //     return lowestCommonAncestor(root.right, p, q);
        // return root;
    }
}
