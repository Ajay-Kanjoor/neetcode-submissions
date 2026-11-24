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

class Solution {    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()){
            int right = -101;
            for (int i = nodes.size(); i > 0; i--){
                TreeNode node = nodes.poll();
                if (node != null){
                    right = node.val;
                    nodes.add(node.left);
                    nodes.add(node.right);
                }
            }
            if (right > -101) rightView.add(right);
        }
        return rightView;
    }
}
