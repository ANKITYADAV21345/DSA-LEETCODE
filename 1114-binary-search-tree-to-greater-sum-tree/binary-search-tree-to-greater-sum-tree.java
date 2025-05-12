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

//methord 1   RECURSIVE APPROACH     TC  O(N)  SC  O(N)
// class Solution {
//     private int globalSum;

//     private void solve(TreeNode node) {
//         if (node == null) return;

//         solve(node.right);
//         globalSum += node.val;
//         node.val = globalSum; // update the node's value
//         solve(node.left);
//     }

//     public TreeNode bstToGst(TreeNode root) {
//         globalSum = 0;
//         solve(root);
//         return root;
//     }
// }



// //METHORD 2  ITERATIVE APROACH   TC  O(N)    SC O(N)
// class Solution {
//     private int globalSum;

//     public TreeNode bstToGst(TreeNode root){
//         globalSum=0;
//         Stack<TreeNode> stack=new Stack<>();
//         TreeNode node = root;

//         while(!stack.isEmpty()||node!=null){
//             while(node!=null){
//                 stack.push(node);
//                 node=node.right;
//             }
//             node=stack.pop();
//             globalSum=globalSum+node.val;
//             node.val=globalSum;

//             node=node.left;
//         }
//         return root;
//     }
// }





//aproach 3 by morish traversal TC O(N)  SC  O(1)
class Solution {
    private int globalSum;

    private TreeNode postExtremeLeftFunc(TreeNode node){
        TreeNode post=node.right;
        while(post.left!=null && post.left!=node){
            post=post.left;
        }
        return post;
    }


    public TreeNode bstToGst(TreeNode root){
        globalSum=0;
        TreeNode node=root;

        while(node!=null){
            TreeNode post=node.right;
            if(post==null){
                globalSum=globalSum+node.val;
                node.val=globalSum;
                node=node.left;
            }
            else{
                TreeNode postExtremeLeft=postExtremeLeftFunc(node);

                if(postExtremeLeft.left==null){
                    postExtremeLeft.left=node;
                    node=node.right;
                }
                else{
                    postExtremeLeft.left=null;
                    globalSum=globalSum+node.val;
                    node.val=globalSum;
                    node=node.left;
                }
            }
        }
        return root;
    }
}
