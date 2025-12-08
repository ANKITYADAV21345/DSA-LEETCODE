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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);

        int left_most=0;

        while(queue.size()>0)
        {
            left_most=queue.peek().val;
            int size=queue.size();
            for(int i=1;i<=size;i++)
            {
                TreeNode tmp=queue.poll();
                if(tmp.left!=null) queue.add(tmp.left);
                if(tmp.right!=null) queue.add(tmp.right);

            }

        }
        return left_most;

        }
        
    }