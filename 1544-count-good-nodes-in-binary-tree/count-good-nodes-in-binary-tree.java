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

 //destination FANG  NEETCODE 150
class Solution {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root,Integer.MIN_VALUE);

    }

    private int countGoodNodes(TreeNode node,int maxSoFar){
        if(node==null){
            return 0;
        }
        int count=0;

        //cheak if the current node is a good node
        if(node.val>=maxSoFar){
            count=1;  //current node is a good node
            maxSoFar=node.val;  //update the maximum value along the path
        }

        //count good nodes in the left and right subtrees
        count =count+countGoodNodes(node.left,maxSoFar);
        count=count+countGoodNodes(node.right,maxSoFar);
        return count;
    }
}