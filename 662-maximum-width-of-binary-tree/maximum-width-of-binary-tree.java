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

    int maxWidth=0;
    Map<Integer,Long> leftmost=new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root,0,1L);
        return maxWidth;
    }

    public void dfs(TreeNode root,int level,long index){

        //base case
        if(root==null){
            return;
        }


        //logic yaha se niche tak

        // store leftmost index of this level
        if(!leftmost.containsKey(level)){
            leftmost.put(level,index);
        }


        // width = current_index - first_index_level + 1
        long currentWidth=index-leftmost.get(level)+1;
        maxWidth=Math.max(maxWidth,(int) currentWidth);

        
        // move to left and right children with updated indices
        dfs(root.left,level+1,2*index);
        dfs(root.right,level+1,2*index+1);
    }
}