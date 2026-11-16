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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{p, q});

        while (!stack.isEmpty()){
            TreeNode[] cur = stack.pop();
            TreeNode pNode = cur[0], qNode = cur[1];

            if (pNode == null && qNode == null) continue;
            if (pNode == null || qNode == null || pNode.val != qNode.val) return false;
            stack.push(new TreeNode[]{pNode.left, qNode.left});
            stack.push(new TreeNode[]{pNode.right, qNode.right});
        }
        return true;
    }
}
