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

    static int preIdx = 0;

    public TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx]);
        preIdx++;

        int inIdx = search(inorder, left, right, root.val);

        root.left = helper(preorder, inorder, left, inIdx - 1);
        root.right = helper(preorder, inorder, inIdx + 1, right);

        return root;
    }

    public int search(int[] inorder, int left, int right, int key) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0; // reset important hai
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
}