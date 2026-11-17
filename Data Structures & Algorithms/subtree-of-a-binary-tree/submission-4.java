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

class Solution {  // Serial + Pattern
    public String serial(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serial(root, res);
        return res.toString();
    }

    private void serial(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("$#");
            return;
        }
        res.append("$").append(root.val);
        serial(root.left, res);
        serial(root.right, res);
    }

    // public int[] z_function(String s){
    //     int[] z = new int[s.length()];
    //     int l = 0, r = 0, n = s.length();
    //     for (int i = 1; i < n; i++){
    //         if (i <= r) 
    //             z[i] = Math.min(r - i + 1, z[i - 1]);
    //         while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) 
    //             z[i]++;
    //         if (i + z[i] - 1 > r) {
    //             l = i;
    //             r = i + z[i] - 1;
    //         }
    //     }
    //     return z;
    // }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String s_root  = serial(root);
        String s_sub = serial(subRoot);
        // String combined = s_sub + "|" + s_root;

        // int[] z_values = z_function(combined);
        // int m = s_sub.length();

        // for (int i = m + 1; i < combined.length(); i++) {
        //     if (z_values[i] == sub_len) return true;
        // }
        int m = s_sub.length();
        // System.out.println(s_root);
        // System.out.println(s_sub);
        // System.out.println();
        for (int i = 0; i <= s_root.length() - m; i++){
            // System.out.println(s_root.substring(i));
            if (s_root.substring(i, i + m).equals(s_sub)) return true;
        }
        return false;
    }
}
