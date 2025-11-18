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


 import java.util.*;
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
            int x = height(root.left);
            int y = height(root.right);
         if(Math.abs(x-y)>1){
                return false;
         }
         return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if(root == null) return 0;
        return 1+ Math.max(height(root.left),height(root.right));
    }
}