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
        if (p == null && q == null) return true;
        if (p == null ^ q == null) return false;
        if (p.val != q.val) return false;

        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.push(p);
        stackQ.push(q);

        while (!stackP.isEmpty() && !stackQ.isEmpty()){
            if (stackP.size() != stackQ.size()) return false;

            TreeNode pTop = stackP.pop();
            TreeNode qTop = stackQ.pop();
            if (pTop == null && qTop == null) continue;
            if (pTop == null ^ qTop == null) return false;
            if (pTop.val != qTop.val) return false;
            stackP.push(pTop.left);
            stackP.push(pTop.right);
            stackQ.push(qTop.left);
            stackQ.push(qTop.right);
        }
        return true;
    }
}
