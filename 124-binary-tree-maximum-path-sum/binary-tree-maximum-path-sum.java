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


//code story with mik(recursion)
class Solution {

    int maxSum;

    public int solve(TreeNode root) {
        if (root == null) return 0;

        int l = solve(root.left);
        int r = solve(root.right);

        // (1) Path that goes through left + root + right
        int neeche_hi_milgaya_answer = l + r + root.val;

        // (2) Path that goes either left+root OR right+root
        int koi_ek_acha = Math.max(l, r) + root.val;

        // (3) Path containing only root
        int only_root_acha = root.val;

        // Update global max
        maxSum = Math.max(maxSum,
                Math.max(neeche_hi_milgaya_answer,
                        Math.max(koi_ek_acha, only_root_acha)));

        // Return “one side best path” for parent
        return Math.max(koi_ek_acha, only_root_acha);
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}