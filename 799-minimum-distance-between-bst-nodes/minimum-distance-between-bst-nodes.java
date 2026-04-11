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
    TreeNode prev=null;
    public int minDiffInBST(TreeNode root) {
        //base case
        if(root==null){
            return Integer.MAX_VALUE;
        }

        //kam
        int ans=Integer.MAX_VALUE;
        //left
        if(root.left!=null){
            int leftMin=minDiffInBST(root.left);
            ans=Math.min(ans,leftMin);
        }

        //root
        if(prev!=null){
            ans=Math.min(ans,root.val-prev.val);
        }
        prev=root;


        //right
        if(root.right!=null){
            int rightMin=minDiffInBST(root.right);
            ans=Math.min(ans,rightMin);
        }

        return ans;
    }
}