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



 //code shash
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSubTreeHeight = getHeight(root.left);
        int rightSubTreeHeight = getHeight(root.right);

        // If either subtree is unbalanced, propagate the failure
        if (leftSubTreeHeight == -1 || rightSubTreeHeight == -1) {
            return -1;
        }

        // If the difference in heights is more than 1, it's unbalanced
        if (Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) {
            return -1;
        }

        // Return the height of the tree
        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
    }
}
