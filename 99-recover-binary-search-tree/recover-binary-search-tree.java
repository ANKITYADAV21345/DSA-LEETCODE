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

    private TreeNode prev = null;
    private TreeNode one = null;
    private TreeNode two = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        // swapping the values of the two wrong nodes
        int temp = one.val;
        one.val = two.val;
        two.val = temp;
    }

    private void inorder(TreeNode cur) {
        if (cur == null) {
            return;
        }

        inorder(cur.left);

        // fix: ensure prev is not null before comparing values
        if (prev != null && prev.val > cur.val) {
            if (one == null) {
                one = prev;
            }
            two = cur;
        }

        prev = cur;
        inorder(cur.right);
    }
}
