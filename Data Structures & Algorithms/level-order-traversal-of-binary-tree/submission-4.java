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

class Solution { // Breadth First Search
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            for (int i = nodes.size(); i > 0; i--){
                TreeNode node = nodes.poll();
                if (node != null){
                    level.add(node.val);
                    nodes.add(node.left);
                    nodes.add(node.right);
                }
            }
            
            if (level.size() > 0) res.add(level);
        }
        return res;
    }
}
