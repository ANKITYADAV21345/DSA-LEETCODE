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


 //done by self(recursion)
class Solution {
    public int countNodes(TreeNode root) {
        
        //base case 
        if(root==null){
            return 0;
        }

        int leftcount=countNodes(root.left);
        int rightcount=countNodes(root.right);
        return leftcount + rightcount+1;
    }
}