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
    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, int[]> mp = new HashMap<>();
        mp.put(null, new int[]{0, 0});
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if (cur.left != null && !mp.containsKey(cur.left)) 
                stack.push(cur.left);
            else if (cur.right != null && !mp.containsKey(cur.right)) 
                stack.push(cur.right);
            else {
                cur = stack.pop();
                int[] leftData = mp.get(cur.left);
                int[] rightData = mp.get(cur.right);


                int height = 1 + Math.max(leftData[0], rightData[0]);
                int diameter = Math.max(leftData[0] + rightData[0], 
                                    Math.max(leftData[1], rightData[1]));
                mp.put(cur, new int[]{height, diameter});
            }
        }
        return mp.get(root)[1];
    }
}
