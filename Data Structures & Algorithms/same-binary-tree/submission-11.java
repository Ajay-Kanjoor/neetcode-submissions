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

class Solution { //Iterative - Depth First
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // // 2 stacks
        // Stack<TreeNode> stackP = new Stack<>();
        // Stack<TreeNode> stackQ = new Stack<>();
        // stackP.push(p);
        // stackQ.push(q);

        // while (!stackP.isEmpty() && !stackQ.isEmpty()){
        //     // if (stackP.size() != stackQ.size()) return false;
        //     TreeNode pTop = stackP.pop();
        //     TreeNode qTop = stackQ.pop();
        //     if (pTop == null && qTop == null) continue;
        //     if (pTop == null ^ qTop == null) return false;
        //     if (pTop.val != qTop.val) return false;
        //     stackP.push(pTop.left);
        //     stackP.push(pTop.right);
        //     stackQ.push(qTop.left);
        //     stackQ.push(qTop.right);
        // }
        // return true;


        // Stack of Pair Arrays
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

    // T O(n)
    // S O(n)
}
