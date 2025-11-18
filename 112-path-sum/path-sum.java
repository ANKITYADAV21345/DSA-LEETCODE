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


 //done by own (recursion)
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //base case 
        if(root==null){
            return false;
        }


        if(root.left==null &&root.right==null){
            if(root.val==targetSum){
                return true;
            }else{
                return false;
            }
        }

        return hasPathSum(root.left, targetSum - root.val) ||
        hasPathSum(root.right, targetSum - root.val);
        
    }
}