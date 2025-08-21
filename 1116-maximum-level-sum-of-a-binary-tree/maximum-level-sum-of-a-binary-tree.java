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


 //keshav tyagi[bits mesra]
class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root==null){
            return 0;
        }

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        int maxLevelSum=Integer.MIN_VALUE;
        int ans=0;
        int curLevel=0;

        while(!queue.isEmpty()){
            int levelSize=queue.size();
            curLevel++;
            int curSum=0;
            for(int i=0;i<levelSize;i++){
                TreeNode node =queue.poll();

                curSum=curSum+node.val;

                if(node.left!=null){
                    queue.add(node.left);
                }

                if(node.right!=null){
                    queue.add(node.right);
                }
            }

            if(maxLevelSum<curSum){
                maxLevelSum=curSum;
                ans=curLevel;
            }
        }
        return ans;
    }
}