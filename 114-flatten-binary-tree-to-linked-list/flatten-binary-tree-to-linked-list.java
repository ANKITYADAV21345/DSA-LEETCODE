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


 //apna college 
class Solution {
    private TreeNode nextRight = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // Recurse on right subtree first
        flatten(root.right);
        // Then recurse on left subtree
        flatten(root.left);

        // Rearrange pointers
        root.left = null;
        root.right = nextRight;
        nextRight = root;
    }
}