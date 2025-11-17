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



// Root ke left aur right subtree ko mirror check karna hai.

// Mirror ka matlab:

// Left ka left == Right ka right

// Left ka right == Right ka left


// Agar values match nahi hui → false

// Agar structure mismatch (null mismatch) → false

// Agar sab match hua → true


//done by self(recursion)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        //base case
        if(root==null){
            return true;
        }

        return isMirror(root.left,root.right);
    }


    public boolean isMirror(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }

        if(left==null || right==null){
            return false;
        }

        if(left.val!=right.val){
            return false;
        }

        return isMirror(left.left,right.right)  && isMirror(left.right,right.left);
    }
}