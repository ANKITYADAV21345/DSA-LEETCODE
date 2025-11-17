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




//done by my own (recursion)
 import java.util.*;
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        int x=maxDepth(root.left)+1;
        int y=maxDepth(root.right)+1;
        int result=Math.max(x,y);
        return result;
    }
}