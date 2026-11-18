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

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;
            if (p.val <= node.val && q.val >= node.val) return node;
            if (p.val >= node.val && q.val <= node.val) return node;
            if (p.val < node.val && q.val < node.val) stack.push(node.left);
            if (p.val > node.val && q.val > node.val) stack.push(node.right);
        }
        return new TreeNode();

    }
}
