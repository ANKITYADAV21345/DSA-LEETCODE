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



//apna college notes(recursion)
class Solution {


    public int height(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        return Math.max(leftHeight,rightHeight)+1;
    }



    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }

        int leftDiameter=diameterOfBinaryTree(root.left);
        int leftHeight=height(root.left);

        int rightDiameter=diameterOfBinaryTree(root.right);
        int rightHeight=height(root.right);

        int selfDiameter=leftHeight+rightHeight;   //iss question me max leangth eadge batani thi issliye +1 NAHI KIYA AND MAAM NE JO KARAYA THA VO MAX NODES IN LONGEST diamenter tha 

        return Math.max(selfDiameter,Math.max(leftDiameter,rightDiameter));
    }
}