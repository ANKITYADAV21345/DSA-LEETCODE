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

    public TreeNode insert(TreeNode root,int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(val<root.val){
            root.left=insert(root.left,val);
        }
        else{
            root.right=insert(root.right,val);
        }
        return root;
    }

     public void inorderHelper(TreeNode root,ArrayList <Integer> result){
        if(root==null) return;
        result.add(root.val);
        inorderHelper(root.left,result);
        inorderHelper(root.right,result);
        
    }


    public ArrayList <Integer> preorderTraversal(TreeNode root){
        ArrayList <Integer> result = new ArrayList<>();
        inorderHelper(root,result);
        return result;
    }
}