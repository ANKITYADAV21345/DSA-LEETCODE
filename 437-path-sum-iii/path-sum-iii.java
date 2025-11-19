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
    public int pathSum(TreeNode root, int targetSum) {
        

        //base case
        if(root==null){
            return 0;
        }

        int count=countPathsFromNode(root,(long)targetSum);
        count=count+pathSum(root.left,targetSum);
        count=count+pathSum(root.right,targetSum);

        return count;
    }

    public int countPathsFromNode(TreeNode root,long targetSum){

        //base case
        if(root==null){
            return 0;
        }

        int paths=0;

        if(root.val==targetSum){
            paths++;
        }
        paths=paths+countPathsFromNode(root.left,targetSum-root.val);
        paths=paths+countPathsFromNode(root.right,targetSum-root.val);
        return paths;
    }
}