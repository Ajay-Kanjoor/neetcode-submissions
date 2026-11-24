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
        Queue<Pair<TreeNode, Integer>> nodes = new LinkedList<>();
        nodes.add(new Pair<>(root, 0));
        while (!nodes.isEmpty()) {
            Pair<TreeNode, Integer> curr = nodes.poll();
            if (curr.getKey() == null) continue;
            TreeNode node = curr.getKey();
            Integer height = curr.getValue();

            if (res.size() <= height) res.add(height, new ArrayList<Integer>());
            res.get(height).add(node.val);

            nodes.add(new Pair<>(node.left, height + 1));
            nodes.add(new Pair<>(node.right, height + 1));
        }
        return res;



        // List<List<Integer>> res = new ArrayList<>();
        // Queue<TreeNode> nodes = new LinkedList<>();
        // nodes.add(root);

        // while (!nodes.isEmpty()) {
        //     List<Integer> level = new ArrayList<>();

        //     for (int i = nodes.size(); i > 0; i--){
        //         TreeNode node = nodes.poll();
        //         if (node != null){
        //             level.add(node.val);
        //             nodes.add(node.left);
        //             nodes.add(node.right);
        //         }
        //     }
            
        //     if (level.size() > 0) res.add(level);
        // }
        // return res;

        

        
    }
}
