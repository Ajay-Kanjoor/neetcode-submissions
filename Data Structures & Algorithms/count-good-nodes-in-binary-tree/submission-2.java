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

class Solution { // BFS
    public int goodNodes(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, Integer.MIN_VALUE));
        int count = 0;

        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode node = p.getKey();
            int maxSoFarOnPath = p.getValue();
            if (node == null) continue;

            if (node.val >= maxSoFarOnPath) count++;
            maxSoFarOnPath = Math.max(node.val, maxSoFarOnPath);
            queue.add(new Pair<>(node.left, maxSoFarOnPath));
            queue.add(new Pair<>(node.right, maxSoFarOnPath));
        }
        return count;
    }
}
