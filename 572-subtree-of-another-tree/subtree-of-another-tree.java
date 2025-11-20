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




//apna college notes (recursion)
class Solution {

    // check if two trees are identical
    public boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;

        // recursively check left and right
        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }

    // LeetCode expects method name isSubtree (lowercase t)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // if subRoot is null, it's a subtree of any tree
        if (subRoot == null) return true;
        // if main tree is null but subRoot isn't, can't be a subtree
        if (root == null) return false;

        // if current node matches the root of subRoot, check identical
        if (root.val == subRoot.val && isIdentical(root, subRoot)) return true;

        // otherwise search left or right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
