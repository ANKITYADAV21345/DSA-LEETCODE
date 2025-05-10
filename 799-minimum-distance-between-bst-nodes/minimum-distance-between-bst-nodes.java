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

    public void inorder(TreeNode root,List<Integer> inorder){
        if(root==null) return;

        inorder(root.left,inorder);
        inorder.add(root.val);
        inorder(root.right,inorder);
    }



    public int minDiffInBST(TreeNode root) {
        
        List<Integer> inorder=new ArrayList<>();

        inorder(root,inorder);

        int min =Integer.MAX_VALUE;

        for(int i=1;i<inorder.size();i++){
            min =Math.min(min,inorder.get(i)-inorder.get(i-1));
        }
        return min;
    }
}