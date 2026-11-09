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
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        TreeNode node = root, last = null;

        while (!stack.isEmpty() || node != null){
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if (node.right == null || last == node.right){
                    stack.pop();
                    int left = map.getOrDefault(node.left, 0);
                    int right = map.getOrDefault(node.right, 0);
                    if (Math.abs(left - right) > 1) return false;
                    map.put(node, 1 + Math.max(left, right));
                    last = node;
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }
        return true;
    }
}
