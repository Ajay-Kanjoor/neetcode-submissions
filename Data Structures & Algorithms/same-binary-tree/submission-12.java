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
        Queue<TreeNode> qP = new LinkedList<>();
        Queue<TreeNode> qQ = new LinkedList<>();
        qP.add(p);
        qQ.add(q);

        while(qP.size() > 0){
            TreeNode pTop = qP.remove();
            TreeNode qTop = qQ.remove();

            if (pTop == null && qTop == null) continue;
            if (pTop == null ^ qTop == null) return false;
            if (pTop.val != qTop.val) return false;
            qP.add(pTop.left);
            qP.add(pTop.right);
            qQ.add(qTop.left);
            qQ.add(qTop.right);
        }
        return true;
    }
}
