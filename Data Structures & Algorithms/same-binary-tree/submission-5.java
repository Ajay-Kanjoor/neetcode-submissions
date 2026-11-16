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
            if (cur[0] == null && cur[1] == null) continue;
            if (cur[0] == null ^ cur[1] == null) return false;
            if (cur[0].val != cur[1].val) return false;
            stack.push(new TreeNode[]{cur[0].left, cur[1].left});
            stack.push(new TreeNode[]{cur[0].right, cur[1].right});
        }
        return true;
    }
}
