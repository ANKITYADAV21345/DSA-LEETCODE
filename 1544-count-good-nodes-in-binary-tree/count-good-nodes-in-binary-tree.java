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

 //engeniering digest
class Solution {
    public int goodNodes(TreeNode root) {
        return helper(root,0,Integer.MIN_VALUE);
    }

    public int helper(TreeNode root,int ans,int curMax){
        //base condition
        if(root==null){
            return 0;
        }
        int rootAnswer=0;

        if(root.val>=curMax){
            rootAnswer=1;
            curMax=root.val;
        }
        int lans=helper(root.left,ans,curMax);
        int rans=helper(root.right,ans,curMax);
        return lans+rans+rootAnswer;

    }
}