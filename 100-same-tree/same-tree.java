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







// The intuition behind the solution is to recursively check if two binary trees are identical. If both trees are empty (null), they are considered identical. If only one tree is empty or the values of the current nodes are different, the trees are not identical. Otherwise, we recursively check if the left and right subtrees of both trees are identical.


//recursive solution done by my own




class Solution {
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        // Base case: if both trees are null, they are identical
        if (root1 == null && root2 == null) {
            return true;
        }
        // If only one tree is null or the values are different, they are not identical
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        // Recursively check if the left and right subtrees are identical
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}