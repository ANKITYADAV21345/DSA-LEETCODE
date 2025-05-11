/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base condition: agar root null ho ya root hi p ya q ke barabar ho
        if (root == null || root == p || root == q) {
            return root;
        }

        // Agar dono nodes left subtree mein hain
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // Agar dono nodes right subtree mein hain
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // Agar ek node left mein hai aur dusra right mein,
        // toh current node hi lowest common ancestor hai
        return root;
    }
}
