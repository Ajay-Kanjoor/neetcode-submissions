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
    // Recursive, find matching root
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        Boolean m = false;
        if (root.val == subRoot.val) m = checkTree(root, subRoot);
        return m || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Same as last question, BFS - Iterative
    public boolean checkTree(TreeNode rootA, TreeNode rootB){
        Queue<TreeNode> qA = new LinkedList<>();
        Queue<TreeNode> qB = new LinkedList<>();
        qA.add(rootA);
        qB.add(rootB);
        while (!qA.isEmpty()){
            TreeNode aTop = qA.poll();
            TreeNode bTop = qB.poll();
            if (aTop == null && bTop == null) continue;
            if (aTop == null || bTop == null) return false;
            if (aTop.val != bTop.val) return false;
            qA.add(aTop.left);
            qA.add(aTop.right);
            qB.add(bTop.left);
            qB.add(bTop.right);
        }
        return true;
    }
}
