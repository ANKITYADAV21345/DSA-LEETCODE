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
class Solution {
    
     public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length);
        
    }
    
    public TreeNode helper(int[] preorder, int rootindex, int right)
    {        
        if(rootindex >= right) return null;
        
        int value = preorder[rootindex];
        TreeNode root = new TreeNode(value);
        
        int i = rootindex+1;
	    while(i <= preorder.length-1 && preorder[i] < value)
        {
            i++;
        }
        root.left = helper(preorder, rootindex+1, i);
        root.right = helper(preorder,i, right);
        
        return root;        
    }
}